package game;

/*
 *  ս�����
 */


public class FightTool {
	//���ܽӿ�
	public static void doFight(Player p1, Player p2){
		// �Ƚ����֣� ӵ�е��������ܣ��Լ����������뵽Ȩ��������, 
		
	}
	
	
	
	public static void testEmptyHandDamage(Player attacker, Player defender) {
		
	}
	
	public static int CalcEmptyDamage(Player attacker) {
		attacker.getAttr().get_final_power();
		return 0;
	}
	
	
	
	// Ȩ����Ŀ
	class WeightTip{
		int nWeightTipType;	//Ȩ������
		int nWeight;		//Ȩ����
	}
}
