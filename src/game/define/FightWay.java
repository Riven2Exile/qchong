package game.define;

/*
 * 攻击方式
 */

interface FightWay {
	int FIGHTWAY_UNDEFINE	= 0;	//未定义
	int WAY_EMPTY_HAND 	= 1; //空手攻击
	int WAY_SKILL		= 2; //技能
	int WAY_WEAPON		= 3; //武器直接攻击
}


// 武器攻击方式
interface WeaponWay{
	int WEAPON_WAY_UNDEFINE	= 0;	//未定义
	int WEAPON_WAY_DIRECT 	= 1;	//直接攻击
	int WEAPON_WAY_THROW	= 2;	//丢弃武器
}