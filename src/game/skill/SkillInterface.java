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
	public final static int ZhuangSi_Skill		= 20;	//装死
	public final static int JiaoXie_Skill		= 21;	//缴械
	public final static int CanYing_Skill		= 22;	//残影
	public final static int KuangQuanShui_Skill	= 23;	//矿泉水
	public final static int JiaoShui_Skill		= 24;	//胶水
	public final static int TianShiZhiYi_Skill	= 25;	//天使之翼
	public final static int FoShanWuYingJiao_Skill	= 26;	//佛山无影脚
	public final static int ShiRuBaoYu_Skill	= 27;	//势如暴雨
	public final static int QiEHou_Skill		= 28;	//企鹅吼
	public final static int QiENaoYang_Skill	= 29;	//企鹅挠痒
	public final static int ShiFuJiaDao_Skill	= 30;	//师傅驾到
	public final static int RuLaiShenZhang_Skill= 31;	//如来神掌
	public final static int ShiXue_Skill		= 32;	//嗜血
	public final static int YiJinJing_Skill 	= 33;	//易筋经
	public final static int AnRanYiJi_Skill		= 34;	//黯然一击
	public final static int ChongFeng_Skill		= 35;	//冲锋
	public final static int DouDouQuan_Skill	= 36;	//抖抖拳
	public final static int JiFengBu_Skill		= 37;	//疾风步
	public final static int XiuXinShu_Skill		= 38;	//修心术
	public final static int MingYueDao_Skill	= 39;	//明月刀
	public final static int XueJiShu_Skill		= 40;	//血祭术
	public final static int RenPinBaoFa_Skill	= 41;	//人品爆发
	public final static int QiGong_Skill		= 42;	//气功
	public final static int ChongJiBo_Skill		= 43;	//冲击波
	public final static int CiKeZhiShu_Skill	= 44;	//刺客之术
	public final static int MengJiangZhiLi_Skill= 45;	//猛将之力
	public final static int DianXue_Skill		= 46;	//点穴
	public final static int JianKeZhiLing_Skill	= 47;	//剑客之灵
	public final static int ShenZhiZhuFu_Skill	= 48;	//神之祝福
	public final static int TaiJiQuanFa_Skill	= 49;	//太极拳法
	public final static int QiLiaoShu_Skill		= 50;	//气疗术
	public final static int TianCanJiao_Skill	= 51;	//天残脚
	public final static int GuiYingCanShen_Skill= 52;	//鬼影缠身
	public final static int BiXieJianPu_Skill	= 53;	//辟邪剑谱
	
	
	
	///// 技能类型
	int SKILLTYPE_UNDEFINE	= 0;	//未定义技能类型
	int SKILLTYPE_FOREVER 	= 1;	//永久型    (一般为加永久属性的技能)
	int SKILLTYPE_ACTIVE_MAIN = 2;	//主动技能 () 
	int SKILLTYPE_ACTIVE_TRIGGER = 3; 	//主动触发型 (如攻击两次, 残影)
	int SKILLTYPE_ATTACKED_TRIGGER = 4;	//被动触发性(如反击 )
	int SKILLTYPE_DYING_TRIGGER = 5;	//濒死触发性(如装死)
	
	// 计算属性 , 是否可以增加 buff增益(如命中等)
	abstract void takeEffect(Player attacker, Player defender);
	
	// 造成伤害
	abstract int getDamage(Player attacker, Player defender);
	
	// buff增益 , dot
}
