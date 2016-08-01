package game.fight;

import game.BaseWeight;
import game.Player;

/*
 *  战斗流程
 */

public class FightFlow {

	public FightFlow() {
		// TODO Auto-generated constructor stub
	}

	
	/*
	 *  开始战斗，传入两个已经初始化的Player
	 */
	public int StartFight(Player p1, Player p2){
		
		// 多次循环,
		// 先随机出此次是 空手攻击，还是武器，还是技能，然后再分别随机各自的子类.... (但是首先，需要取身上可以随机的东西去随机，如果没有武器，怎么随机武器)
		// 伤害计算
		
		return 0;
	}
	
	
	
}



class FightWight extends BaseWeight{
	private int id = 0;	//可以是技能id, 武器id
	
	public FightWight(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
}