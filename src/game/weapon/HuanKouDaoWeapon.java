package game.weapon;

import game.Player;
import game.define.WeaponKind;

public class HuanKouDaoWeapon extends BaseWeapon{

	public HuanKouDaoWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
		
		_weaponKind = WeaponKind.HUAN_KOU_DAO; 	//
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub
		
	}

	
}
