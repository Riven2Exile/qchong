package game.weapon;

/*
 *  小李飞刀
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class XiaoLiFeiDaoWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.FEI_DAO;	//小李飞刀
		_weaponType = WeaponType.WEAPON_THROW;	//投掷武器
	}
	
	public XiaoLiFeiDaoWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
