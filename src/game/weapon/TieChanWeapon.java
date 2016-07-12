package game.weapon;

/*
 *  Ìú²ù
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class TieChanWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.TIE_CHAN;		//Ìú²ù
		_weaponType = WeaponType.WEAPON_MIDDLE;	//ÖÐÐÍÎäÆ÷
	}
	
	public TieChanWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
