package game.weapon;

/*
 *  ��ˮ��
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class QiShuiGuanWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.QI_SHUI_GUAN;	//��ˮ��
		_weaponType = WeaponType.WEAPON_THROW;	//Ͷ������
	}
	
	public QiShuiGuanWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
