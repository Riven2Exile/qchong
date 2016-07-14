package game.weapon;

/*
 *  ÆûË®¹Þ
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class QiShuiGuanWeapon extends BaseWeapon {
	
	public QiShuiGuanWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return WeaponKind.QI_SHUI_GUAN;	//ÆûË®¹Þ
	}

}
