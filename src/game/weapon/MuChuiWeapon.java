package game.weapon;

/*
 *  Ä¾é³
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class MuChuiWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.MU_CHUI;	//Ä¾é³
		_weaponType = WeaponType.WEAPON_LARGE;	//´óÐÍÎäÆ÷
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
