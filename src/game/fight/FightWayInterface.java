package game.fight;

import game.Player;

/**
 * 战斗方式
 */

public interface FightWayInterface {
	int AW_Undefine 	= 0;	//未定义
	int AW_EmptyHand	= 1;	//空手攻击
	int AW_Weapon		= 2;	//武器攻击  (直接平砍 or 丢出)
	int AW_ActiveMainSkill	= 3;	//主动技能
	int AW_ActiveTrigger	= 4; 	//主动攻击效果型, （无影手，残影）
	int AW_AfterAttackHit = 5;		//主动攻击命中后触发
	int AW_BeforeAttack	= 6;		//确定攻击技能之前触发
	
	
	void calcAttackEffect(Player attacker, Player defender); //计算攻击效果, 可能是自身加成，也可能是对方dot
	int getFightWay();
}
