package game.weapon;

import game.define.WeaponKind;
import game.define.WeaponType;

public abstract class BaseWeapon implements WeaponInterface{
	
	static int _weaponType = WeaponType.WEAPON_UNDEFINE;	// 武器类型
	static int _weaponKind = WeaponKind.UNDEFINE;			// 武器种类
	
	
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
	public final int getWeaponType(){
		return _weaponType;
	}
	
	//获得武器种类, 说白了是武器的id
	public final int getWeaponKind(){
		return _weaponKind;
	}
	
	//@Override
	//public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub
		
	//}
	
	//魂珠
	//其他..
}
