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
		
		int nFightWay = 0 ;
		int id = 0 ; 
		
		int nHuihe = 20;
		String strOut;
		for (int i = 1; i <= nHuihe; ++i){
			nFightWay = attackerCon.getRandomFightWay();
			id = attackerCon.getRandomID(nFightWay);
			
			////// todo: ���м���
			
			////// �˺�����
			int nSelfDamage = 0;
			if (FightWayInterface.AW_Weapon == nFightWay){
				BaseWeapon weapon = p1.GetWeaponHelper().getWeapon(id);
				if(weapon != null){
					nSelfDamage = TestDamage.genWeaponDamage(p1, weapon);
				}
			}
			else if(FightWayInterface.AW_EmptyHand == nFightWay){
				nSelfDamage = TestDamage.genEmptyHandDamage(p1.getAttr());
			}
			else if(FightWayInterface.AW_ActiveMainSkill == nFightWay){
				BaseSkill skill = p1.GetSkillHelper().getSkill(id);
				if(skill != null){
					nSelfDamage = skill.GetDamage(p1);
				}
			}
			
			// todo:�Ƿ�������
			
			///// �˺����� end
			
			strOut = "��" + i + "�غ�, ʹ�ó�" + fightWay2String(nFightWay) + " " + id + ", ���" + nSelfDamage + "�������˺�";
			out.println(strOut);
			
			// ��������ļ���, ������1������ʹ�ô���+1
			if (FightWayInterface.AW_Weapon == nFightWay){
				attackerCon.remove(nFightWay, id);
			}
		}
		
		// ��������˴��� ���ֹ������������������Ǽ��ܣ�Ȼ���ٷֱ�������Ե�����.... (�������ȣ���Ҫȡ���Ͽ�������Ķ���ȥ��������û����������ô�������)
		
		// �˺�����
		
		
		
		
		return 0;
	}
	
	
	/**
	 * test 
	 */
	public void test(){
		Player p1 = new Player();
		p1.getAttr().set_base_three(5, 5, 7);
		p1.getAttr().set_base_hp(200);
		// todo, ������ܻ�ӻ������Ե�buff
		p1.getAttr().CalcBaseThree();
		
		WeaponHelper wh =  p1.GetWeaponHelper();
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.SHE_YING_GONG, 0)); //����Ӱ��
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.KUANG_MO_LIAN, 0)); //�ӿ�ħ��
		
		SkillHelper sh = p1.GetSkillHelper();
		sh.addSkill(SkillFactory.getInstance(SkillInterface.SPEED_SKILL, 0));
		sh.addSkill(SkillFactory.getInstance(SkillInterface.FoShanWuYingJiao_Skill, 0));
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.HP_SKILL, 0));
		
		p1.getAttr().CalcAddictionThree();
		p1.getAttr().CalcFinalThree();
		
		
		
		StartFight(p1, null);
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







