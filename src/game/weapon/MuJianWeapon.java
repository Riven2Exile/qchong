package game.weapon;

/*
 *  ľ��
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class MuJianWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.MU_JIAN;	//ľ��
		_weaponType = WeaponType.WEAPON_TINY;	//С������ ?
	}
	
	public MuJianWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
