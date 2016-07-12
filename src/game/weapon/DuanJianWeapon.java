package game.weapon;

/*
 *  ¶Ì½£
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class DuanJianWeapon extends BaseWeapon {
	static {
		_weaponKind = WeaponKind.DUAN_JIAN;		//¶Ì½£
		_weaponType = WeaponType.WEAPON_TINY;	//Ð¡ÐÍÎäÆ÷
	}
	public DuanJianWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
