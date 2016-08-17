package game.weapon;

/**
 *  武器： 短剑    （增加连击率）
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class DuanJianWeapon extends BaseWeapon {
	public DuanJianWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub
		int lv = getWeaponLv();
		if (0 == lv) {
			attacker.getAttr().add_doubleHit(25);	// 25%连续攻击
		}
	}

	@Override
	public int getWeaponType() {
		// TODO Auto-generated method stub
		return WeaponType.WEAPON_TINY;	//小型武器
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.DUAN_JIAN;		//短剑;
	}

}
