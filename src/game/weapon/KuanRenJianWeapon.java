package game.weapon;

/*
 *  ¿íÈÐ½£
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class KuanRenJianWeapon extends BaseWeapon {
	
	public KuanRenJianWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getWeaponType() {
		// TODO Auto-generated method stub
		return WeaponType.WEAPON_MIDDLE;	//ÖÐÐÍÎäÆ÷
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.KUAN_REN_JIAN;	//¿íÈÐ½£
	}

}
