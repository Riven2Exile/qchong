package game.weapon;

/*
 *  ����
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class TieChanWeapon extends BaseWeapon {
	
	public TieChanWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	// ����������� (������Ҫ���¶���)
	public final int getWeaponType(){
		return WeaponType.WEAPON_MIDDLE; //��������
	}
	
	//�����������, ˵������������id
	public final int getWeaponKind(){ //����
		return WeaponKind.TIE_CHAN;
	}
	
	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
