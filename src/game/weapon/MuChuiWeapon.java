package game.weapon;

/*
 *  ľ�
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class MuChuiWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.MU_CHUI;	//ľ�
		_weaponType = WeaponType.WEAPON_LARGE;	//��������
	}
	
	public MuChuiWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
