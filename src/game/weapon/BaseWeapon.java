package game.weapon;

import game.define.WeaponKind;
import game.define.WeaponType;

public abstract class BaseWeapon implements WeaponInterface{
	
	int _enhanceLv = 0; //ǿ���ȼ�
	int _nMinDamage = 0;	
	int _nMaxDamage = 0;
	boolean _hasUsed = false; //�Ƿ��Ѿ���ʹ��
	
	public BaseWeapon(int enhanceLv, int minDamage, int maxDamage){
		_enhanceLv = enhanceLv;
		this._nMinDamage = minDamage;
		this._nMaxDamage = maxDamage;
	}
	
	// ����������� (������Ҫ���¶���)
	public abstract int getWeaponType(); //{ return WeaponType.WEAPON_UNDEFINE;}
	
	//�����������, ˵������������id
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
	
	//����
	//����..
}
