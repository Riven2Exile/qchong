package game.weapon;

/*
 *  С��ɵ�
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class XiaoLiFeiDaoWeapon extends BaseWeapon {

	static {
		_weaponKind = WeaponKind.FEI_DAO;	//С��ɵ�
		_weaponType = WeaponType.WEAPON_THROW;	//Ͷ������
	}
	
	public XiaoLiFeiDaoWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
