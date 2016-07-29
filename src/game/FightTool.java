package game;

/*
 *  战斗相关
 */


public class FightTool {
	//功能接口
	public static void doFight(Player p1, Player p2){
		// 先将空手， 拥有的主动技能，以及武器，放入到权重容器中, 
		
	}
	
	
	
	public static void testEmptyHandDamage(Player attacker, Player defender) {
		
	}
	
	public static int CalcEmptyDamage(Player attacker) {
		attacker.getAttr().get_final_power();
		return 0;
	}
	
	
	
	// 权重项目
	class WeightTip{
		int nWeightTipType;	//权重类型
		int nWeight;		//权重数
	}
}
