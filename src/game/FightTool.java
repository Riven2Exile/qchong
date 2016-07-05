package game;

/*
 *  战斗相关
 */


public class FightTool {
	//功能接口
	public static void doFight(Player p1, Player p2){
		
	}
	
	
	
	public static void testEmptyHandDamage(Player attacker, Player defender) {
		
	}
	
	public static int CalcEmptyDamage(Player attacker) {
		attacker.getAttr().get_final_power();
		return 0;
	}
}
