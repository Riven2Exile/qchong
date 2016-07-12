package game.weapon;

/*
 *  ������
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class LiuXingQiuWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.LIU_XING_QIU; 	//������
		_weaponType = WeaponType.WEAPON_THROW;	//Ͷ������
	}
	
	public LiuXingQiuWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
