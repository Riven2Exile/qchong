package game.weapon;

/*
 *  开山斧
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class KaiShanFuWeapon extends BaseWeapon {

	public KaiShanFuWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return WeaponType.WEAPON_LARGE;	//大型武器
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.KAI_SHAN_FU; //开山斧
	}

}
