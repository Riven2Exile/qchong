package game.weapon;

import game.define.WeaponKind;
import game.define.WeaponType;

public abstract class BaseWeapon implements WeaponInterface{
	
	int _enhanceLv = 0; //强化等级
	int _nMinDamage = 0;	
	int _nMaxDamage = 0;
	boolean _hasUsed = false; //是否已经被使用
	
	public BaseWeapon(int enhanceLv, int minDamage, int maxDamage){
		_enhanceLv = enhanceLv;
		this._nMinDamage = minDamage;
		this._nMaxDamage = maxDamage;
	}
	
	// 获得武器类型 (子类需要重新定义)
	public abstract int getWeaponType(); //{ return WeaponType.WEAPON_UNDEFINE;}
	
	//获得武器种类, 说白了是武器的id
	public abstract int getWeaponKind(); //{	return WeaponKind.UNDEFINE; }
	
	public final int getMinDamage(){
		return _nMinDamage;
	}
	
	public final int getMaxDamage(){
		return _nMaxDamage;
	}
	
	//@Override
	//public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub
		
	//}
	
	//魂珠
	//其他..
}
