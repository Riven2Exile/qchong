package game.weapon;

import game.Player;
import game.RangeInt;
import game.define.WeaponKind;
import game.define.WeaponType;

/*
 *  ��Ӱ��
 */
public class SheYingGongWeapon extends BaseWeapon{
	
	public SheYingGongWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
		_weaponKind = WeaponKind.SHE_YING_GONG;	// ��Ӱ��
		_weaponType = WeaponType.WEAPON_MIDDLE;	// ��������
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub
		
	}

	
}
