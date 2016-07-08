package game.skill;

import game.Player;

public interface SkillInterface {
	
	public final static int UNDEFINE_SKILL  = 0;	//未定义技能
	public final static int POWER_SKILL 	= 1;    //天生大力
	public final static int MINJIE_SKILL	= 2;	//身手敏捷
	public final static int SPEED_SKILL 	= 3;	//快人一步
	public final static int HP_SKILL		= 4; 	//强健身躯
	public final static int BALANCE_ATTR_SKILL	= 5;	//均衡发展
	//public final static int  //6.武器好手
	//7.肉搏好手
	//8.第六感
	
	// 计算属性 , 是否可以增加 buff增益(如命中等)
	abstract void CalcAttr(Player player);
	
	// 造成伤害
	abstract int GetDamage(Player player);
	
	// buff增益 , dot
}
