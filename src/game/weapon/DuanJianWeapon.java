package game.weapon;

/**
 *  ������ �̽�    �����������ʣ�
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class DuanJianWeapon extends BaseWeapon {
	public DuanJianWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub
		int lv = getWeaponLv();
		if (0 == lv) {
			attacker.getAttr().add_doubleHit(25);	// 25%��������
		}
	}

	@Override
	public int getWeaponType() {
		// TODO Auto-generated method stub
		return WeaponType.WEAPON_TINY;	//С������
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.DUAN_JIAN;		//�̽�;
	}

}
