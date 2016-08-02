package game;

import java.util.HashMap;
import java.util.Map.Entry;

//import java.util.ArrayList;

import game.weapon.BaseWeapon;

public class WeaponHelper {
	//ArrayList<BaseWeapon> _weapon = new ArrayList<>(); //武器列表 
	HashMap<Integer, BaseWeapon> _weapon = new HashMap<>();
	
	//添加武器
	public void addWeapon(BaseWeapon w){
		_weapon.put(w.getWeaponKind(), w);
	}
	
	public void addAllWeapon(HashMap<Integer, BaseWeapon> data){
		_weapon.putAll(data);
	}
	
	public BaseWeapon getWeapon(int weaponID){
		return _weapon.get(weaponID);
	}
	
	
	
	public <T extends ForeachInterface> void ForEach(T o)
	{
		for (Entry<Integer, BaseWeapon> entry: _weapon.entrySet() )
		{
			o.doFun(entry.getValue());
		}
	}
	
	
	///// 【之后最好删掉这个接口！！！】
	public HashMap<Integer, BaseWeapon> GetFuckData(){
		return _weapon;
	}
	
	
	// 枚举武器~
	public void tell(){
	
		// 需求, 遍历武器， 根据不同的类型，调用不同类型的伤害函数，因为公式不同
	}
}
