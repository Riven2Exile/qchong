package game;

import java.util.HashMap;

//import java.util.ArrayList;

import game.weapon.BaseWeapon;

public class WeaponHelper {
	//ArrayList<BaseWeapon> _weapon = new ArrayList<>(); //�����б� 
	HashMap<Integer, BaseWeapon> _weapon = new HashMap<>();
	
	//�������
	public void addWeapon(BaseWeapon w){
		_weapon.put(w.getWeaponKind(), w);
	}
	
	public BaseWeapon getWeapon(int weaponID){
		return _weapon.get(_weapon);
	}
	
	// ö������~
	public void tell(){
	
		// ����, ���������� ���ݲ�ͬ�����ͣ����ò�ͬ���͵��˺���������Ϊ��ʽ��ͬ
	}
}
