package game.gametest;

import game.Attr;
import game.CalcTool;
import game.Player;

/*
 *   �˺�����
 *   
 *   ����, ����, ���� �ȵ�
 *    
 */

public class TestDamage {
	
	public static void TestEmptyHandDamage(){
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
		System.out.println("ͳ���˺�");
		for (int i = 0; i < 10; ++i){
			double r = CalcTool.random(1.5, 2);
			int nDamage = (int)Math.floor( atkAttr.get_final_power() * r ); // �²⹫ʽ
			System.out.println(nDamage);
		}
	}
	
	
	
	
}
