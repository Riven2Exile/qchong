package game.fight;

import java.util.HashMap;
import java.util.Map.Entry;

import game.BaseWeight;
import game.BaseWeightContent;
import game.ForeachInterface;
import game.skill.BaseSkill;
import game.weapon.BaseWeapon;

/**
 *  ս������
 * @author liupr
 *
 */
class FightCon implements ForeachInterface{
	private HashMap<Integer, FightWight> _mapWeapon	= new HashMap<>();			//�����б�
	private HashMap<Integer, FightWight> _mapActiveSkill = new HashMap<>();	//��������
	
	public BaseWeapon _curWeaponInHand = null;	//��ǰ�ֳֵ�����(������Ͷ��������������Ͷ����ȥ���ֳ�����)
	
	public int _nFightWay = 0;	//��ǰ׼������Ĺ�����ʽ  FightWayInterface
	
	////// ��Ҫ�洢ս��״̬(buff, dot)
	// 1.ѣ��   2.����ʹ��Զ�̼���  3.
	public int _nXuanYun = 0; 		//ѣ��
	public int _nCanFarSkill = 0;	//����ʹ��Զ�̼���
	public int _nDoubleAttack = 0;	//������! �� ÿһ�غ�֮ǰ��������
	
	
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
	
	/*
	 *  �Ƴ���ǰ����
	 */
	public void removeCurrentWeapon(){
		if (_curWeaponInHand != null) {
			_mapWeapon.remove(_curWeaponInHand.getWeaponKind());
			_curWeaponInHand = null;
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