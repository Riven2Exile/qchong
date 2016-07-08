package game;

import java.util.HashMap;

//import java.util.ArrayList;

import game.weapon.BaseWeapon;

public class WeaponHelper {
	//ArrayList<BaseWeapon> _weapon = new ArrayList<>(); //武器列表 
	HashMap<Integer, BaseWeapon> _weapon = new HashMap<>();
	
	//添加武器
	public void addWeapon(BaseWeapon w){
		_weapon.put(w.getWeaponKind(), w);
	}
	
	public BaseWeapon getWeapon(int weaponID){
		return _weapon.get(_weapon);
	}
	
	// 枚举武器~
	public void tell(){
	
		// 需求, 遍历武器， 根据不同的类型，调用不同类型的伤害函数，因为公式不同
	}
}
