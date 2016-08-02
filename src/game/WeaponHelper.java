package game;

import java.util.HashMap;
import java.util.Map.Entry;

//import java.util.ArrayList;

import game.weapon.BaseWeapon;

public class WeaponHelper {
	//ArrayList<BaseWeapon> _weapon = new ArrayList<>(); //�����б� 
	HashMap<Integer, BaseWeapon> _weapon = new HashMap<>();
	
	//�������
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
	
	
	///// ��֮�����ɾ������ӿڣ�������
	public HashMap<Integer, BaseWeapon> GetFuckData(){
		return _weapon;
	}
	
	
	// ö������~
	public void tell(){
	
		// ����, ���������� ���ݲ�ͬ�����ͣ����ò�ͬ���͵��˺���������Ϊ��ʽ��ͬ
	}
}
