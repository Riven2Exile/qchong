package game.fight;

import java.util.HashMap;
import java.util.Map.Entry;

import game.BaseWeight;
import game.BaseWeightContent;
import game.ForeachInterface;
import game.skill.BaseSkill;
import game.weapon.BaseWeapon;

/**
 *  战斗容器
 * @author liupr
 *
 */
class FightCon implements ForeachInterface{
	private HashMap<Integer, FightWight> _mapWeapon	= new HashMap<>();			//武器列表
	private HashMap<Integer, FightWight> _mapActiveSkill = new HashMap<>();	//主动技能
	
	public BaseWeapon _curWeaponInHand = null;	//当前手持的武器(不包含投掷武器，或者是投掷出去的手持武器)
	
	public int _nFightWay = 0;	//当前准备随机的攻击方式  FightWayInterface
	
	////// 需要存储战斗状态(buff, dot)
	// 1.眩晕   2.不能使用远程技能  3.
	public int _nXuanYun = 0; 		//眩晕
	public int _nCanFarSkill = 0;	//不能使用远程技能
	public int _nDoubleAttack = 0;	//连击率! ， 每一回合之前都会计算的
	
	
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
	
	/*
	 *  移除当前武器
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