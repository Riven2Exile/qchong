package game.weapon;

/*
 *  ¿íÈÐ½£
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class KuanRenJianWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.KUAN_REN_JIAN;	//¿íÈÐ½£
		_weaponType = WeaponType.WEAPON_MIDDLE;	//ÖÐÐÍÎäÆ÷
	}
	
	public KuanRenJianWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
