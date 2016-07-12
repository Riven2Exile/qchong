package game.weapon;

/*
 *  接力棒
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class JieLiBangWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.JIE_LI_BANG;	//接力棒 
		_weaponType = WeaponType.WEAPON_TINY;	//小型
	}
	
	public JieLiBangWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
