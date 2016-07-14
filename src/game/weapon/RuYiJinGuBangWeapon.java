package game.weapon;

/*
 *  如意金箍棒
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class RuYiJinGuBangWeapon extends BaseWeapon {
	
	public RuYiJinGuBangWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return WeaponKind.RU_YI_JIN_GU_BANG; //如意金箍棒
	}

}
