package game.weapon;

/*
 *  铁铲
 */

import game.Player;
import game.define.WeaponKind;
import game.define.WeaponType;

public class TieChanWeapon extends BaseWeapon {
	
	public TieChanWeapon(int enhanceLv, int minDamage, int maxDamage) {
		super(enhanceLv, minDamage, maxDamage);
		// TODO Auto-generated constructor stub
	}

	// 获得武器类型 (子类需要重新定义)
	public final int getWeaponType(){
		return WeaponType.WEAPON_MIDDLE; //中型武器
	}
	
	//获得武器种类, 说白了是武器的id
	public final int getWeaponKind(){ //铁铲
		return WeaponKind.TIE_CHAN;
	}
	
	@Override
	public void HandleEffect(Player attacker, Player defender) {
		// TODO Auto-generated method stub

	}

}
