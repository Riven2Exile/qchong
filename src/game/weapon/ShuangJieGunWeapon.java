package game.weapon;

/*
 *  Ë«½Ø¹÷
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class ShuangJieGunWeapon extends BaseWeapon {
	
	public ShuangJieGunWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return WeaponType.WEAPON_MIDDLE;		//ÖÐÐÍÎäÆ÷
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.SHUANG_JIE_GUN;	//Ë«½Ø¹÷
	}

}
