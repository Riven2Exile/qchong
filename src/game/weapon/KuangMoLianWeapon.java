package game.weapon;

/*
 *  ��������ħ��
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;



public class KuangMoLianWeapon extends BaseWeapon {

	// ��̬�����
	static {
		_weaponKind = WeaponKind.KUANG_MO_LIAN;	//��ħ��
		_weaponType = WeaponType.WEAPON_LARGE;	//�������� 
	}
	
	public KuangMoLianWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
