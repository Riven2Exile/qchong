package game.weapon;

/*
 *  Á÷ÐÇÇò
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class LiuXingQiuWeapon extends BaseWeapon {

	public LiuXingQiuWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return WeaponType.WEAPON_THROW;	//Í¶ÖÀÎäÆ÷
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.LIU_XING_QIU; 	//Á÷ÐÇÇò
	}

}
