package game.gametest;

import game.Attr;
import game.CalcTool;
import game.Player;

/*
 *   伤害测试
 *   
 *   空手, 武器, 技能 等等
 *    
 */

public class TestDamage {
	
	public static void TestEmptyHandDamage(){
		// 攻击者
		Player attacker = new Player();
		
		// 防御者
		Player defender = new Player();
		
		
		
		// 设置玩家基本属性值, 以及装备，技能等
		Attr atkAttr = attacker.getAttr();
		atkAttr.set_base_three(4, 4, 4);
		atkAttr.CalFinalThree();
		
		// 统计伤害
		atkAttr.tell();
		System.out.println("统计伤害");
		for (int i = 0; i < 10; ++i){
			double r = CalcTool.random(1.5, 2);
			int nDamage = (int)Math.floor( atkAttr.get_final_power() * r ); // 猜测公式
			System.out.println(nDamage);
		}
	}
	
	
	
	
}
