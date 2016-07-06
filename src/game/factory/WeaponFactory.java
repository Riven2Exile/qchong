package game.factory;

import game.define.WeaponKind;
import game.weapon.BaseWeapon;
import game.weapon.SheYingGongWeapon;

public class WeaponFactory {
		static class minmax{
			public minmax() {}
			public int min = 0;
			public int max = 0;
		}
		
	public static BaseWeapon getInstance(int weaponKind, int enhanceLv){
		minmax m = new minmax();
		getDamageValue(weaponKind, enhanceLv, m);
		switch (weaponKind){
		case WeaponKind.SHE_YING_GONG: return new SheYingGongWeapon(enhanceLv, m.min, m.max);
		}
		return null;
	}
	
	
	///// 先用这种很挫的方式写
	public static void getDamageValue(int weaponKind, int enhanceLv, minmax m){
		if (WeaponKind.SHE_YING_GONG == weaponKind){
			if (0 == enhanceLv){
				m.min = 20;
				m.max = 22;
			}
		}
	}
}
