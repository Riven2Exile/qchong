package game.fight;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import game.Attr;
import game.BaseWeight;
import game.BaseWeightContent;
import game.ForeachInterface;
import game.Player;
import game.SkillHelper;
import game.WeaponHelper;
import game.define.WeaponKind;
import game.define.WeaponType;
import game.factory.SkillFactory;
import game.factory.WeaponFactory;
import game.gametest.TestDamage;
import game.skill.BaseSkill;
import game.skill.SkillInterface;
import game.weapon.BaseWeapon;

/*
 *  战斗流程
 */

public class FightFlow {

	public FightFlow() {
		// TODO Auto-generated constructor stub
	}

	public String fightWay2String(int way){
		if(FightWayInterface.AW_Undefine == way){
			return "未定义";
		}else if(FightWayInterface.AW_EmptyHand == way){
			return "空手攻击";
		}else if(FightWayInterface.AW_Weapon == way){
			return "武器攻击";
		}
		else if(FightWayInterface.AW_ActiveMainSkill == way){
			return "主动技能";
		}
		else{
			return "未知!?";
		}
	}
	
	
	/*
	 *  开始战斗，传入两个已经初始化的Player
	 */
	public int StartFight(Player p1, Player p2){
		
		FightCon attackerCon = new FightCon();
		
		attackerCon._nFightWay = FightWayInterface.AW_Weapon;
		p1.GetWeaponHelper().ForEach(attackerCon); 	//武器权重流
		attackerCon._nFightWay = FightWayInterface.AW_ActiveMainSkill;
		p1.GetSkillHelper().ForEach(attackerCon);	//主动技能权重流
		
		// todo: “攻击权重随机之前触发型”
		
		// todo: 主要的攻击手段
		
		int nHuihe = 20;
		for (int i = 1; i <= nHuihe; ++i){
			
			// 确定到某人的流程,
			p1.GetFightBuffHelper().onARoundStart();
			if (p1.isDie()) {
				out.println(p1.GetPlayerName() + "死亡了！");
				break;
			}
			
			// 先不考虑速度的概念, 每人各打一次
			attackOnce(p1, p2, attackerCon, i);	// 【攻击一次】
			
			if(p1.getAttr().get_final_hp() <= 0){
				out.println(p1.GetPlayerName() + "死亡了!"); 
				break;
			}
			if(p2.getAttr().get_final_hp() <= 0){
				out.println(p2.GetPlayerName() + "死亡了!"); 
				break;
			}
			
			p2.GetFightBuffHelper().onARoundStart();
			if(p2.isDie()){
				out.println(p2.GetPlayerName()+"死亡了！");
				break;
			}
			attackOnce(p2, p1, attackerCon, i);
			if(p1.getAttr().get_final_hp() <= 0){
				out.println(p1.GetPlayerName() + "死亡了!"); 
				break;
			}
			if(p2.getAttr().get_final_hp() <= 0){
				out.println(p2.GetPlayerName() + "死亡了!"); 
				break;
			}
		}
		
		// 先随机出此次是 空手攻击，还是武器，还是技能，然后再分别随机各自的子类.... (但是首先，需要取身上可以随机的东西去随机，如果没有武器，怎么随机武器)
		
		// 伤害计算
		
		return 0;
	}
	
	/**
	 * 攻击一次
	 */
	public void attackOnce(Player atk, Player def, FightCon attackerCon, int i){
		int nFightWay = 0 ;
		int id = 0 ; 
		nFightWay = attackerCon.getRandomFightWay();
		id = attackerCon.getRandomID(nFightWay);
		String strOut;
		////// todo: 命中计算
		
		////// 伤害计算
		int nSelfDamage = 0;
		int nWeaponType = WeaponType.WEAPON_UNDEFINE; //武器类型
		if (FightWayInterface.AW_Weapon == nFightWay){
			BaseWeapon weapon = atk.GetWeaponHelper().getWeapon(id);
			if(weapon != null){
				nWeaponType = weapon.getWeaponType();
				nSelfDamage = TestDamage.genWeaponDamage(atk, weapon);
			}
		}
		else if(FightWayInterface.AW_EmptyHand == nFightWay){
			nSelfDamage = TestDamage.genEmptyHandDamage(atk.getAttr());
		}
		else if(FightWayInterface.AW_ActiveMainSkill == nFightWay){
			BaseSkill skill = atk.GetSkillHelper().getSkill(id);
			if(skill != null){
				nSelfDamage = skill.getDamage(atk, def); //计算伤害
				skill.takeEffect(atk, def); //触发效果
			}
		}
		
		
		// ---->>>>>>>  数值型增伤
		int nAddDamageChangeNum = calcAddDamageNumber(atk.getAttr(), nFightWay, nWeaponType);
		if(nAddDamageChangeNum > 0){
			nSelfDamage += nAddDamageChangeNum;
		}
		// ---->>>>>>>  百分比增伤
		int nAddDamageChangePer = calcAddDamagePer(atk.getAttr(), nFightWay, nWeaponType);
		if(nAddDamageChangePer > 0){
			nSelfDamage = (int)Math.floor( nSelfDamage * ((100 + nAddDamageChangePer) / (double)100) );
		}
		
		// ---->>>>>>>  数值型减伤
		int nSubDamageChangeNum = calcSubDamageNumber(def.getAttr(), nFightWay, nWeaponType);
		if(nSubDamageChangeNum > 0){
			nSelfDamage -= nSubDamageChangeNum;
			if(nSelfDamage < 0){
				nSelfDamage = 0;
			}
		}
		// ---->>>>>>>  百分比减伤
		int nSubDamageChangePer = calcSubDamagePer(def.getAttr(), nFightWay, nWeaponType); //减伤应该最多只能减 100%吧
		if(nSelfDamage > 0 && nSubDamageChangePer > 0){
			nSelfDamage = nSelfDamage - (int)Math.floor(nSelfDamage * ((100 - nSubDamageChangePer)/(double)100) ); //
			if(nSelfDamage < 0){
				nSelfDamage = 0;
			}
		}
		
		// todo: 触发防守方的被动技能, 如果是反伤技能， 还需要再走一次  attackOnce方法
		
		
		// 血量变化
		def.getAttr().add_final_hp(-nSelfDamage);
		
		// todo: 判断死亡, 触发临死技能, 有顺序的，一般是是装死技能
		if( def.getAttr().get_final_hp() <= 0){
			// todo
			BaseSkill sk = def.GetSkillHelper().getSkill(SkillInterface.ZhuangSi_Skill);
			if (sk != null && sk.getUseCount() < 1){
				sk.takeEffect(def, null);
				sk.addUseCount(1);
				out.println(def.GetPlayerName() + "触发了装死技能!");//print
			}
		}
		
		///// 伤害计算 end
		strOut = "第" + i + "回合, [" + atk.GetPlayerName() + "]使用出" + fightWay2String(nFightWay) + " " + id + ", 造成" 
		+ nSelfDamage + "点主观伤害, [" + def.GetPlayerName() + "]剩余血量" + def.getAttr().get_final_hp() + "/" + def.getAttr().get_max_hp();
		out.println(strOut);
		
		// 自身的消耗计算, 武器减1，技能使用次数+1
		if (FightWayInterface.AW_Weapon == nFightWay){
			attackerCon.remove(nFightWay, id);
		}
	}
	
	/**
	 *  计算数值型增伤
	 * @return
	 */
	public int calcAddDamageNumber(Attr atk, int fightway, int weaponType){
		int n = 0;
		if (FightWayInterface.AW_EmptyHand == fightway){
			n = atk.get_addEmptyHandDamage();
		}
		else if(FightWayInterface.AW_Weapon == fightway){
			if(WeaponType.WEAPON_LARGE == weaponType){
				n = atk.get_addLargeWeaponDamage();
			}else if(WeaponType.WEAPON_MIDDLE == weaponType){
				n = atk.get_addMidWeaponDamage();
			}else if(WeaponType.WEAPON_TINY == weaponType){
				n = atk.get_addTinyWeaponDamage();
			}else if(WeaponType.WEAPON_THROW == weaponType){
				n = atk.get_addThrowWeaponDamage();
			}
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			n = atk.get_addSkillDamage();
		}
		
		return n;
	}
	
	/**
	 *  计算百分比增伤
	 */
	public int calcAddDamagePer(Attr atk, int fightway, int weaponType){
		int n = 0;
		if (FightWayInterface.AW_EmptyHand == fightway){
			n = atk.get_addEmptyHandDamagePer();
		}
		else if(FightWayInterface.AW_Weapon == fightway){
			if(WeaponType.WEAPON_LARGE == weaponType){
				n = atk.get_addLargeWeaponDamagePer();
			}else if(WeaponType.WEAPON_MIDDLE == weaponType){
				n = atk.get_addMidWeaponDamagePer();
			}else if(WeaponType.WEAPON_TINY == weaponType){
				n = atk.get_addTinyWeaponDamagePer();
			}else if(WeaponType.WEAPON_THROW == weaponType){
				n = atk.get_addThrowWeaponDamagePer();
			}
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			n = atk.get_addSkillDamagePer();
		}
		
		return n;
	}
	
	/**
	 *  计算数值型减伤
	 */
	public int calcSubDamageNumber(Attr def, int fightway, int weaponType){
		int n = 0;
		if (FightWayInterface.AW_EmptyHand == fightway){
			n = def.get_subEmptyHandDamage();
		}
		else if(FightWayInterface.AW_Weapon == fightway){
			if(WeaponType.WEAPON_LARGE == weaponType){
				n = def.get_subLargeWeaponDamage();
			}else if(WeaponType.WEAPON_MIDDLE == weaponType){
				n = def.get_subMidWeaponDamage();
			}else if(WeaponType.WEAPON_TINY == weaponType){
				n = def.get_subTinyWeaponDamage();
			}else if(WeaponType.WEAPON_THROW == weaponType){
				n = def.get_subThrowWeaponDamage();
			}
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			n = def.get_subSkillDamage();
		}
		
		return n;
	}
	
	/**
	 * 计算百分比减伤
	 */
	public int calcSubDamagePer(Attr def, int fightway, int weaponType){
		int n = 0;
		if (FightWayInterface.AW_EmptyHand == fightway){
			n = def.get_subEmptyHandDamagePer();
		}
		else if(FightWayInterface.AW_Weapon == fightway){
			if(WeaponType.WEAPON_LARGE == weaponType){
				n = def.get_subLargeWeaponDamagePer();
			}else if(WeaponType.WEAPON_MIDDLE == weaponType){
				n = def.get_subMidWeaponDamagePer();
			}else if(WeaponType.WEAPON_TINY == weaponType){
				n = def.get_subTinyWeaponDamagePer();
			}else if(WeaponType.WEAPON_THROW == weaponType){
				n = def.get_subThrowWeaponDamagePer();
			}
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			n = def.get_subSkillDamagePer();
		}
		return n;
	}
	
	/**
	 * test 测试
	 */
	public void test(){
		Player p1 = new Player();
		p1.SetName("测试者1");
		p1.getAttr().set_base_three(13, 5, 6);
		p1.getAttr().set_base_hp(200);
		// todo, 这里可能会加基础属性的buff
		p1.getAttr().CalcBaseThree();
		
		Player wood = new Player();	//木桩
		wood.SetName("木桩");
		wood.getAttr().set_base_hp(500);
		wood.getAttr().CalcFinalThree();
		wood.GetSkillHelper().addSkill(SkillFactory.getInstance(SkillInterface.ZhuangSi_Skill, 0));	//装死
		
		WeaponHelper wh =  p1.GetWeaponHelper();
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.SHE_YING_GONG, 0)); //加蛇影弓
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.KUANG_MO_LIAN, 0)); //加狂魔镰
		
		SkillHelper sh = p1.GetSkillHelper();
		sh.addSkill(SkillFactory.getInstance(SkillInterface.SPEED_SKILL, 0));
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.FoShanWuYingJiao_Skill, 0)); 	//佛山无影腿
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.LongJuanFeng_Skill, 0));		//龙卷风
		sh.addSkill(SkillFactory.getInstance(SkillInterface.HAND_GOOD_SKILL, 0));	//肉搏好手
		sh.addSkill(SkillFactory.getInstance(SkillInterface.WEAPON_GOOD_SKILL, 0));	//武器好手
		sh.addSkill(SkillFactory.getInstance(SkillInterface.QiENaoYang_Skill, 0));	//企鹅挠痒
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.HP_SKILL, 0));
		
		/// 下面的计算语句可以抽取成函数
		p1.GetSkillHelper().reCaclForeverAttr(p1);
		p1.getAttr().CalcAddictionThree();
		p1.getAttr().CalcFinalThree();
		
		
		
		StartFight(p1, wood);
	}
	
}



class FightWight extends BaseWeight{
	private int _id = 0;	//可以是技能id, 武器id
	
	public FightWight(int nWeight) {
		super(nWeight);
		// TODO Auto-generated constructor stub
	}
	
	public FightWight(int nWeight, int id){
		super(nWeight);
		_id = id;
	}
	
	public int getID(){
		return _id;
	}
}

/**
 *  战斗容器
 * @author liupr
 *
 */
class FightCon implements ForeachInterface{
	private HashMap<Integer, FightWight> _mapWeapon	= new HashMap<>();			//武器列表
	private HashMap<Integer, FightWight> _mapActiveSkill = new HashMap<>();	//主动技能
	
	public int _nFightWay = 0;	//当前准备随机的攻击方式  FightWayInterface
	
	public void clearAll(){
		
	}
	
	public void addWeapon(FightWight w){
		_mapWeapon.put(w.getID(), w);
	}
	
	public void addActiveSkill(FightWight w){
		_mapActiveSkill.put(w.getID(), w);
	}
	
	
	public int getRandomFightWay(){
		//构造权重
		BaseWeightContent w = new BaseWeightContent();
		w.putAData(new BaseWeight(0));	//AW_Undefine
		w.putAData(new BaseWeight(1)); // AW_EmptyHand 空手;
		w.putAData(new BaseWeight(_mapWeapon.size())); //AW_Weapon 武器
		w.putAData(new BaseWeight(_mapActiveSkill.size())); //主动技能
		return w.getWeightIndex();
	}
	
	public int getRandomID(int fightway){
		BaseWeightContent w = new BaseWeightContent();
		if (FightWayInterface.AW_Weapon == fightway ){
			for ( Entry<Integer, FightWight>va : _mapWeapon.entrySet()){
				w.putAData(va.getValue());
			}
			
			FightWight fw = (FightWight)w.getWeightData();
			if (fw != null){
				return fw.getID();
			}
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			for (Entry<Integer, FightWight> va : _mapActiveSkill.entrySet()){
				w.putAData(va.getValue());
			}
			
			FightWight fw = (FightWight)w.getWeightData();
			if (fw != null){
				return fw.getID();
			}
		}
		
		
		return 0;
	}
	
	public void remove(int fightway, int id){
		if(FightWayInterface.AW_Weapon == fightway){
			_mapWeapon.remove(id);
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			_mapActiveSkill.remove(id);
		}
	}

	@Override
	public <T> void doFun(T obj) {
		// TODO Auto-generated method stub
		if( FightWayInterface.AW_Weapon == _nFightWay ){
			BaseWeapon w = (BaseWeapon)obj;
			addWeapon(new FightWight(1, w.getWeaponKind()));
		}
		else if(FightWayInterface.AW_ActiveMainSkill == _nFightWay){
			BaseSkill sk = (BaseSkill)obj;
			if(sk.getSkillType() == BaseSkill.SKILLTYPE_ACTIVE_MAIN){
				addActiveSkill(new FightWight(1, sk.getSkillID()) );
			}
			
		}
	}
}







