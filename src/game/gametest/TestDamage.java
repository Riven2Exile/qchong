package game.gametest;

import game.Attr;
import game.CalcTool;
import game.Player;
import game.weapon.BaseWeapon;

/*
 *   伤害测试
 *   
 *   空手, 武器, 技能 等等
 *    
 */

public class TestDamage {
	
	//
	public static void doTest(){
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
		
		////测试空手伤害
		TestEmptyHandDamage(atkAttr, null);  //防御者暂不考虑
		
	}
	
	
	// 测试空手伤害
	public static void TestEmptyHandDamage(Attr atkAttr, Attr defAttr){
		
		double nMinRange = 1.5;		//空手伤害的范围
		double nMaxRange = 2.0;
		
		int nMinDamage = (int)(atkAttr.get_final_power() * nMinRange);  //猜测公式
		int nMaxDamage = (int)(atkAttr.get_final_power() * nMaxRange);
		System.out.println("空手伤害值:"+ nMinDamage + "-" + nMaxDamage );
	}
	
	
	// 测试武器伤害
	public static void TestWeaponDamage(Player attacker, Player defender){
		
	}
	
	// 测试中型武器伤害
	public static void TestMiddleWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		
	}
}
