package game.weapon;

import game.define.WeaponKind;
import game.define.WeaponType;

public abstract class BaseWeapon implements WeaponInterface{
	
	static int _weaponType = WeaponType.WEAPON_UNDEFINE;	// ��������
	static int _weaponKind = WeaponKind.UNDEFINE;			// ��������
	
	
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
	public final int getWeaponType(){
		return _weaponType;
	}
	
	//�����������, ˵������������id
	public final int getWeaponKind(){
		return _weaponKind;
	}
	
	//@Override
	//public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub
		
	//}
	
	//����
	//����..
}
