package game.weapon;

/*
 *  ÅÐ¹Ù±Ê
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class PanGuanBiWeapon extends BaseWeapon {
	
	public PanGuanBiWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return WeaponType.WEAPON_TINY;	//Ð¡ÐÍ
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.PAN_GUAN_BI;	//ÅÐ¹Ù±Ê
	}

}
