package game.skill;

import game.Player;

public interface SkillInterface {
	
	public final static int SPEED_SKILL = 3;	//快人一步
	
	// 计算属性 , 是否可以增加 buff增益(如命中等)
	abstract void CalcAttr(Player player);
	
	// 造成伤害
	abstract int GetDamage(Player player);
	
	// buff增益 , dot
}
