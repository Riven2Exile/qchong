package game.weapon;

/*
 *  ��������
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class ChongQiChuiZiWeapon extends BaseWeapon {

	public ChongQiChuiZiWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return WeaponType.WEAPON_LARGE; //��������
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.CHONG_QI_CHUI_ZI; //��������
	}

}