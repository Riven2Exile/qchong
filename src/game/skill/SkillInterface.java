package game.skill;

import game.Player;

public interface SkillInterface {
	
	///// 技能id
	public final static int UNDEFINE_SKILL  = 0;	//未定义技能
	public final static int POWER_SKILL 	= 1;    //天生大力
	public final static int MINJIE_SKILL	= 2;	//身手敏捷
	public final static int SPEED_SKILL 	= 3;	//快人一步
	public final static int HP_SKILL		= 4; 	//强健身躯
	public final static int BALANCE_ATTR_SKILL	= 5;	//均衡发展
	public final static int WEAPON_GOOD_SKILL	= 6;	//武器好手
	public final static int HAND_GOOD_SKILL	= 7;	//肉搏好手
	public final static int REHIT_SKILL		= 8;	//第六感
	public final static int LOSS_LOVE_SKILL	= 9;	//晴天霹雳
	public final static int ATTACK_DOUBLE_SKILL	= 10;	//无影手
	public final static int BaoQiHuTi_SKILL	= 11;	//霸气护体
	public final static int DaHaiWuLiang_SKILL	= 12;	//大海无量
	public final static int PiCaoRouHou_Skill	= 13;	//皮糙肉厚
	public final static int LingBoWeiBu_Skill	= 14;	//凌波微步
	public final static int HeiLongBo_Skill		= 15;	//黑龙波
	public final static int LongJuanFeng_Skill	= 16;	//龙卷风
	public final static int GuanYongZhongWu_Skill	= 17;	//惯用重物
	public final static int BiZhongJiuQing_Skill	= 18;	//避重就轻
	public final static int ShenLaiYiJi_Skill		= 19;	//神来一击
	public final static int ZhuanSi_Skill		= 20;	//装死
	public final static int JiaoXie_Skill		= 21;	//缴械
	public final static int CanYing_Skill		= 22;	//残影
	public final static int KuangQuanShui_Skill	= 23;	//矿泉水
	public final static int JiaoShui_Skill		= 24;	//胶水
	public final static int TianShiZhiYi_Skill	= 25;	//天使之翼
	public final static int FoShanWuYingJiao_Skill	= 26;	//佛山无影脚
	//public final static int  //6.武器好手
	//7.肉搏好手
	//8.第六感
	
	
	
	///// 技能类型
	int SKILLTYPE_UNDEFINE	= 0;	//未定义技能类型
	int SKILLTYPE_FOREVER 	= 1;	//永久型    (一般为加永久属性的技能)
	int SKILLTYPE_ACTIVE_MAIN = 2;	//主动技能 () 
	
	// 计算属性 , 是否可以增加 buff增益(如命中等)
	abstract void CalcAttr(Player player);
	
	// 造成伤害
	abstract int getDamage(Player player);
	
	// buff增益 , dot
}
