package game.weapon;

/*
 *  Ä¾é³
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class MuChuiWeapon extends BaseWeapon {
	
	public MuChuiWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return WeaponType.WEAPON_LARGE;	//´óÐÍÎäÆ÷
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.MU_CHUI;	//Ä¾é³
	}

}
