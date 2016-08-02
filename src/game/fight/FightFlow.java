package game.fight;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import game.BaseWeight;
import game.BaseWeightContent;
import game.ForeachInterface;
import game.Player;
import game.SkillHelper;
import game.WeaponHelper;
import game.define.WeaponKind;
import game.factory.SkillFactory;
import game.factory.WeaponFactory;
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
		p1.GetWeaponHelper().ForEach(attackerCon); //武器权重流
		
		
		// todo: “攻击权重随机之前触发型”
		
		// todo: 主要的攻击手段
		
		int nFightWay = 0 ;
		int id = 0 ; 
		
		int nHuihe = 20;
		String strOut;
		for (int i = 1; i <= nHuihe; ++i){
			nFightWay = attackerCon.getRandomFightWay();
			id = attackerCon.getRandomID(nFightWay);
			
			strOut = "第" + i + "回合, 使用出" + fightWay2String(nFightWay) + " " + id;
			out.println(strOut);
		}
		
		// 先随机出此次是 空手攻击，还是武器，还是技能，然后再分别随机各自的子类.... (但是首先，需要取身上可以随机的东西去随机，如果没有武器，怎么随机武器)
		
		// 伤害计算
		
		
		// 自身的消耗计算, 武器减1，技能使用次数+1
		
		return 0;
	}
	
	
	/**
	 * test 
	 */
	public void test(){
		Player p1 = new Player();
		p1.getAttr().set_base_three(5, 5, 7);
		WeaponHelper wh =  p1.GetWeaponHelper();
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.SHE_YING_GONG, 0)); //加蛇影弓
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.KUANG_MO_LIAN, 0)); //加狂魔镰
		
		SkillHelper sh = p1.GetSkillHelper();
		sh.addSkill(SkillFactory.getInstance(SkillInterface.SPEED_SKILL, 0));
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.HP_SKILL, 0));
		
		StartFight(p1, null);
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
	}
}







