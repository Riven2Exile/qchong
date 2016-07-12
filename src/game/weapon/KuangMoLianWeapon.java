package game.weapon;

/*
 *  ÎäÆ÷£º¿ñÄ§Á­
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;



public class KuangMoLianWeapon extends BaseWeapon {

	// ¾²Ì¬´úÂë¿é
	static {
		_weaponKind = WeaponKind.KUANG_MO_LIAN;	//¿ñÄ§Á­
		_weaponType = WeaponType.WEAPON_LARGE;	//´óĞÍÎäÆ÷ 
	}
	
	public KuangMoLianWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
