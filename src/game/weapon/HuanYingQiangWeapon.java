package game.weapon;

/*
 *  ��Ӱǹ
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class HuanYingQiangWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.HUAN_YING_QIANG;	//��Ӱǹ
		_weaponType = WeaponType.WEAPON_TINY;		//С������
	}
	
	public HuanYingQiangWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
