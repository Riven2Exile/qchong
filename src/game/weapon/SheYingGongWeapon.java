package game.weapon;

import game.Player;
import game.Pair;
import game.define.WeaponKind;
import game.define.WeaponType;

/*
 *  蛇影弓
 */
public class SheYingGongWeapon extends BaseWeapon{
	
	static {
		_weaponKind = WeaponKind.SHE_YING_GONG;	// 蛇影弓
		_weaponType = WeaponType.WEAPON_MIDDLE;	// 中型武器
	}
	
	public SheYingGongWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub
		
	}

	
}
