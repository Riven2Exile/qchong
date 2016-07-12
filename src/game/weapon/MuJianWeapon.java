package game.weapon;

/*
 *  Ä¾½£
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class MuJianWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.MU_JIAN;	//Ä¾½£
		_weaponType = WeaponType.WEAPON_TINY;	//Ð¡ÐÍÎäÆ÷ ?
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
