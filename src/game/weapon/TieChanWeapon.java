package game.weapon;

/*
 *  ����
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class TieChanWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.TIE_CHAN;		//����
		_weaponType = WeaponType.WEAPON_MIDDLE;	//��������
	}
	
	public TieChanWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
