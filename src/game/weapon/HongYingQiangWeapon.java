package game.weapon;

/*
 *  ��ӧǹ
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class HongYingQiangWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.HONG_YING_QIANG;	//��ӧǹ
		_weaponType = WeaponType.WEAPON_MIDDLE;		//��������
	}
	
	public HongYingQiangWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
