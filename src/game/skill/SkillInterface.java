package game.skill;

import game.Player;

public interface SkillInterface {
	// 计算属性
	abstract void CalcAttr(Player player);
	
	// 造成伤害
	abstract int GetDamage(Player player);
}
