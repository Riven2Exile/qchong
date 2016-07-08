package game.gametest;

import game.Attr;
import game.CalcTool;
import game.Player;
import game.weapon.BaseWeapon;

/*
 *   �˺�����
 *   
 *   ����, ����, ���� �ȵ�
 *    
 */

public class TestDamage {
	
	//
	public static void doTest(){
		// ������
		Player attacker = new Player();
		
		// ������
		Player defender = new Player();
		
		// ������һ�������ֵ, �Լ�װ�������ܵ�
		Attr atkAttr = attacker.getAttr();
		atkAttr.set_base_three(4, 4, 4);
		atkAttr.CalFinalThree();
		
		// ͳ���˺�
		atkAttr.tell();
		
		////���Կ����˺�
		TestEmptyHandDamage(atkAttr, null);  //�������ݲ�����
		
	}
	
	
	// ���Կ����˺�
	public static void TestEmptyHandDamage(Attr atkAttr, Attr defAttr){
		
		double nMinRange = 1.5;		//�����˺��ķ�Χ
		double nMaxRange = 2.0;
		
		int nMinDamage = (int)(atkAttr.get_final_power() * nMinRange);  //�²⹫ʽ
		int nMaxDamage = (int)(atkAttr.get_final_power() * nMaxRange);
		System.out.println("�����˺�ֵ:"+ nMinDamage + "-" + nMaxDamage );
	}
	
	
	// ���������˺�
	public static void TestWeaponDamage(Player attacker, Player defender){
		
	}
	
	// �������������˺�
	public static void TestMiddleWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		
	}
}
