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
 *  ս������
 */

public class FightFlow {

	public FightFlow() {
		// TODO Auto-generated constructor stub
	}

	public String fightWay2String(int way){
		if(FightWayInterface.AW_Undefine == way){
			return "δ����";
		}else if(FightWayInterface.AW_EmptyHand == way){
			return "���ֹ���";
		}else if(FightWayInterface.AW_Weapon == way){
			return "��������";
		}
		else if(FightWayInterface.AW_ActiveMainSkill == way){
			return "��������";
		}
		else{
			return "δ֪!?";
		}
	}
	
	
	/*
	 *  ��ʼս�������������Ѿ���ʼ����Player
	 */
	public int StartFight(Player p1, Player p2){
		
		FightCon attackerCon = new FightCon();
		
		attackerCon._nFightWay = FightWayInterface.AW_Weapon;
		p1.GetWeaponHelper().ForEach(attackerCon); 	//����Ȩ����
		attackerCon._nFightWay = FightWayInterface.AW_ActiveMainSkill;
		p1.GetSkillHelper().ForEach(attackerCon);	//��������Ȩ����
		
		// todo: ������Ȩ�����֮ǰ�����͡�
		
		// todo: ��Ҫ�Ĺ����ֶ�
		
		int nHuihe = 20;
		for (int i = 1; i <= nHuihe; ++i){
			
			// ȷ����ĳ�˵�����,
			p1.GetFightBuffHelper().onARoundStart();
			if (p1.isDie()) {
				out.println(p1.GetPlayerName() + "�����ˣ�");
				break;
			}
			
			// �Ȳ������ٶȵĸ���, ÿ�˸���һ��
			attackOnce(p1, p2, attackerCon, i);	// ������һ�Ρ�
			
			if(p1.getAttr().get_final_hp() <= 0){
				out.println(p1.GetPlayerName() + "������!"); 
				break;
			}
			if(p2.getAttr().get_final_hp() <= 0){
				out.println(p2.GetPlayerName() + "������!"); 
				break;
			}
			
			p2.GetFightBuffHelper().onARoundStart();
			if(p2.isDie()){
				out.println(p2.GetPlayerName()+"�����ˣ�");
				break;
			}
			attackOnce(p2, p1, attackerCon, i);
			if(p1.getAttr().get_final_hp() <= 0){
				out.println(p1.GetPlayerName() + "������!"); 
				break;
			}
			if(p2.getAttr().get_final_hp() <= 0){
				out.println(p2.GetPlayerName() + "������!"); 
				break;
			}
		}
		
		// ��������˴��� ���ֹ������������������Ǽ��ܣ�Ȼ���ٷֱ�������Ե�����.... (�������ȣ���Ҫȡ���Ͽ�������Ķ���ȥ��������û����������ô�������)
		
		// �˺�����
		
		return 0;
	}
	
	/**
	 * ����һ��
	 */
	public void attackOnce(Player atk, Player def, FightCon attackerCon, int i){
		int nFightWay = 0 ;
		int id = 0 ; 
		nFightWay = attackerCon.getRandomFightWay();
		id = attackerCon.getRandomID(nFightWay);
		String strOut;
		////// todo: ���м���
		
		////// �˺�����
		int nSelfDamage = 0;
		int nWeaponType = WeaponType.WEAPON_UNDEFINE; //��������
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
				nSelfDamage = skill.getDamage(atk, def); //�����˺�
				skill.takeEffect(atk, def); //����Ч��
			}
		}
		
		
		// ---->>>>>>>  ��ֵ������
		int nAddDamageChangeNum = calcAddDamageNumber(atk.getAttr(), nFightWay, nWeaponType);
		if(nAddDamageChangeNum > 0){
			nSelfDamage += nAddDamageChangeNum;
		}
		// ---->>>>>>>  �ٷֱ�����
		int nAddDamageChangePer = calcAddDamagePer(atk.getAttr(), nFightWay, nWeaponType);
		if(nAddDamageChangePer > 0){
			nSelfDamage = (int)Math.floor( nSelfDamage * ((100 + nAddDamageChangePer) / (double)100) );
		}
		
		// ---->>>>>>>  ��ֵ�ͼ���
		int nSubDamageChangeNum = calcSubDamageNumber(def.getAttr(), nFightWay, nWeaponType);
		if(nSubDamageChangeNum > 0){
			nSelfDamage -= nSubDamageChangeNum;
			if(nSelfDamage < 0){
				nSelfDamage = 0;
			}
		}
		// ---->>>>>>>  �ٷֱȼ���
		int nSubDamageChangePer = calcSubDamagePer(def.getAttr(), nFightWay, nWeaponType); //����Ӧ�����ֻ�ܼ� 100%��
		if(nSelfDamage > 0 && nSubDamageChangePer > 0){
			nSelfDamage = nSelfDamage - (int)Math.floor(nSelfDamage * ((100 - nSubDamageChangePer)/(double)100) ); //
			if(nSelfDamage < 0){
				nSelfDamage = 0;
			}
		}
		
		// todo: �������ط��ı�������, ����Ƿ��˼��ܣ� ����Ҫ����һ��  attackOnce����
		
		
		// Ѫ���仯
		def.getAttr().add_final_hp(-nSelfDamage);
		
		// todo: �ж�����, ������������, ��˳��ģ�һ������װ������
		if( def.getAttr().get_final_hp() <= 0){
			// todo
			BaseSkill sk = def.GetSkillHelper().getSkill(SkillInterface.ZhuangSi_Skill);
			if (sk != null && sk.getUseCount() < 1){
				sk.takeEffect(def, null);
				sk.addUseCount(1);
				out.println(def.GetPlayerName() + "������װ������!");//print
			}
		}
		
		///// �˺����� end
		strOut = "��" + i + "�غ�, [" + atk.GetPlayerName() + "]ʹ�ó�" + fightWay2String(nFightWay) + " " + id + ", ���" 
		+ nSelfDamage + "�������˺�, [" + def.GetPlayerName() + "]ʣ��Ѫ��" + def.getAttr().get_final_hp() + "/" + def.getAttr().get_max_hp();
		out.println(strOut);
		
		// ��������ļ���, ������1������ʹ�ô���+1
		if (FightWayInterface.AW_Weapon == nFightWay){
			attackerCon.remove(nFightWay, id);
		}
	}
	
	/**
	 *  ������ֵ������
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
	 *  ����ٷֱ�����
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
	 *  ������ֵ�ͼ���
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
	 * ����ٷֱȼ���
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
	 * test ����
	 */
	public void test(){
		Player p1 = new Player();
		p1.SetName("������1");
		p1.getAttr().set_base_three(13, 5, 6);
		p1.getAttr().set_base_hp(200);
		// todo, ������ܻ�ӻ������Ե�buff
		p1.getAttr().CalcBaseThree();
		
		Player wood = new Player();	//ľ׮
		wood.SetName("ľ׮");
		wood.getAttr().set_base_hp(500);
		wood.getAttr().CalcFinalThree();
		wood.GetSkillHelper().addSkill(SkillFactory.getInstance(SkillInterface.ZhuangSi_Skill, 0));	//װ��
		
		WeaponHelper wh =  p1.GetWeaponHelper();
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.SHE_YING_GONG, 0)); //����Ӱ��
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.KUANG_MO_LIAN, 0)); //�ӿ�ħ��
		
		SkillHelper sh = p1.GetSkillHelper();
		sh.addSkill(SkillFactory.getInstance(SkillInterface.SPEED_SKILL, 0));
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.FoShanWuYingJiao_Skill, 0)); 	//��ɽ��Ӱ��
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.LongJuanFeng_Skill, 0));		//�����
		sh.addSkill(SkillFactory.getInstance(SkillInterface.HAND_GOOD_SKILL, 0));	//�ⲫ����
		sh.addSkill(SkillFactory.getInstance(SkillInterface.WEAPON_GOOD_SKILL, 0));	//��������
		sh.addSkill(SkillFactory.getInstance(SkillInterface.QiENaoYang_Skill, 0));	//�������
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.HP_SKILL, 0));
		
		/// ����ļ��������Գ�ȡ�ɺ���
		p1.GetSkillHelper().reCaclForeverAttr(p1);
		p1.getAttr().CalcAddictionThree();
		p1.getAttr().CalcFinalThree();
		
		
		
		StartFight(p1, wood);
	}
	
}



class FightWight extends BaseWeight{
	private int _id = 0;	//�����Ǽ���id, ����id
	
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
 *  ս������
 * @author liupr
 *
 */
class FightCon implements ForeachInterface{
	private HashMap<Integer, FightWight> _mapWeapon	= new HashMap<>();			//�����б�
	private HashMap<Integer, FightWight> _mapActiveSkill = new HashMap<>();	//��������
	
	public int _nFightWay = 0;	//��ǰ׼������Ĺ�����ʽ  FightWayInterface
	
	public void clearAll(){
		
	}
	
	public void addWeapon(FightWight w){
		_mapWeapon.put(w.getID(), w);
	}
	
	public void addActiveSkill(FightWight w){
		_mapActiveSkill.put(w.getID(), w);
	}
	
	
	public int getRandomFightWay(){
		//����Ȩ��
		BaseWeightContent w = new BaseWeightContent();
		w.putAData(new BaseWeight(0));	//AW_Undefine
		w.putAData(new BaseWeight(1)); // AW_EmptyHand ����;
		w.putAData(new BaseWeight(_mapWeapon.size())); //AW_Weapon ����
		w.putAData(new BaseWeight(_mapActiveSkill.size())); //��������
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







