package game.weapon;

/*
 *  幻影枪
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class HuanYingQiangWeapon extends BaseWeapon {

	
	public HuanYingQiangWeapon(int enhanceLv, int minDamage, int maxDamage) {
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
		return WeaponType.WEAPON_TINY;		//小型武器
	}

	@Override
	public int getWeaponKind() {
		// TODO Auto-generated method stub
		return WeaponKind.HUAN_YING_QIANG;	//幻影枪
	}

}
