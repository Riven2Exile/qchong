package game.weapon;

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

/*
 *  蛇影弓
 */
public class SheYingGongWeapon extends BaseWeapon{

	protected static int _weaponType = WeaponType.WEAPON_MIDDLE;  //子类复写
	protected static int _weaponKind = WeaponKind.SHE_YING_GONG;		  //子类复写之
	
	public SheYingGongWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return _weaponType;
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return _weaponKind;
	}

	
}
