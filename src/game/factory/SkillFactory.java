package game.factory;

import game.skill.AttackDoubleSkill;
import game.skill.BaQiHuTiSkill;
import game.skill.BalanceSkill;
import game.skill.BaseSkill;
import game.skill.CanYingSkill;
import game.skill.FoShanWuYingJiaoSkill;
import game.skill.HandGoodSkill;
import game.skill.HpSkill;
import game.skill.LingBoWeiBuSkill;
import game.skill.LongJuanFengSkill;
import game.skill.LossLoveSkill;
import game.skill.MinJieSkill;
import game.skill.PowerSkill;
import game.skill.QiENaoYangSkill;
import game.skill.RehitSkill;
import game.skill.SpeedSkill;
import game.skill.WeaponGoodSkill;
import game.skill.ZhuangSiSkill;

public class SkillFactory {
	public static BaseSkill getInstance(int id, int lv){
		switch(id){
		case BaseSkill.POWER_SKILL: return new PowerSkill(lv);		//天生大力
		case BaseSkill.MINJIE_SKILL: return new MinJieSkill(lv);	//身手敏捷
		case BaseSkill.SPEED_SKILL: return new SpeedSkill(lv);		//快人一步
		case BaseSkill.HP_SKILL: return new HpSkill(lv);			//强健身躯
		case BaseSkill.BALANCE_ATTR_SKILL: return new BalanceSkill(lv);	//均衡发展
		case BaseSkill.WEAPON_GOOD_SKILL: return new WeaponGoodSkill(lv);	//武器好手
		case BaseSkill.HAND_GOOD_SKILL: return new HandGoodSkill(lv);	//肉搏好手
		case BaseSkill.REHIT_SKILL: return new RehitSkill(lv);		//反击技能
		case BaseSkill.LOSS_LOVE_SKILL: return new LossLoveSkill(lv);	//晴天霹雳
		case BaseSkill.ATTACK_DOUBLE_SKILL: return new AttackDoubleSkill(lv);	//仙风云体
		case BaseSkill.BaQiHuTi_SKILL: return new BaQiHuTiSkill(lv); //【todo:】霸气护体
		case BaseSkill.DaHaiWuLiang_SKILL: return null; //【todo:】大海无量
		case BaseSkill.PiCaoRouHou_Skill: return null; //【todo:】皮糙肉厚
		case BaseSkill.LingBoWeiBu_Skill: return new LingBoWeiBuSkill(lv);	//凌波微步
		case BaseSkill.HeiLongBo_Skill: return null;//【todo:】黑龙波
		case BaseSkill.LongJuanFeng_Skill : return new LongJuanFengSkill(lv);	//龙卷风
		case BaseSkill.GuanYongZhongWu_Skill: return null; //【todo:】惯用重物
		case BaseSkill.BiZhongJiuQing_Skill: return null; //【todo:】避重就轻
		case BaseSkill.ShenLaiYiJi_Skill: return null; //【todo:】神来一击
		case BaseSkill.ZhuangSi_Skill: return new ZhuangSiSkill(lv);	//装死
		case BaseSkill.JiaoXie_Skill: return null; //【todo:】缴械
		case BaseSkill.CanYing_Skill: return new CanYingSkill(lv);	//残影
		case BaseSkill.KuangQuanShui_Skill: return null; //【todo:矿泉水】
		case BaseSkill.JiaoShui_Skill: return null; //【todo:胶水】
		case BaseSkill.TianShiZhiYi_Skill: return null; //【todo:天使之翼】
		case BaseSkill.FoShanWuYingJiao_Skill: return new FoShanWuYingJiaoSkill(lv);	//佛山无影脚
		case BaseSkill.ShiRuBaoYu_Skill: return null; //【todo:势如暴雨】
		case BaseSkill.QiEHou_Skill: return null; //【todo: 企鹅吼】
		case BaseSkill.QiENaoYang_Skill : return new QiENaoYangSkill(lv);	//企鹅挠痒
		
		case BaseSkill.RuLaiShenZhang_Skill: return null; //【todo:如来神掌】
		case BaseSkill.ShiXue_Skill: return null; //【todo:嗜血】
		case BaseSkill.YiJinJing_Skill: return null; //【todo:易筋经】
		case BaseSkill.AnRanYiJi_Skill: return null; //【todo:黯然一击】
		case BaseSkill.ChongFeng_Skill: return null; //【todo:冲锋】
		default: return null;
		}
	}
}
