package game.weapon;

/*
 *  ¿œ Û
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class LaoShuWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.LAO_SHU;	//¿œ Û
		_weaponType = WeaponType.WEAPON_THROW;	//Õ∂÷¿Œ‰∆˜
	}
	
	public LaoShuWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
