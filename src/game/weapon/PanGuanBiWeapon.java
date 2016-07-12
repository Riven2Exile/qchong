package game.weapon;

/*
 *  ÅÐ¹Ù±Ê
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class PanGuanBiWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.PAN_GUAN_BI;	//ÅÐ¹Ù±Ê
		_weaponType = WeaponType.WEAPON_TINY;	//Ð¡ÐÍ
	}
	
	public PanGuanBiWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
