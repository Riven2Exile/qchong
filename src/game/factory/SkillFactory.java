package game.factory;

import game.skill.BaseSkill;
import game.skill.FoShanWuYingJiaoSkill;
import game.skill.LongJuanFengSkill;
import game.skill.MinJieSkill;
import game.skill.PowerSkill;
import game.skill.SpeedSkill;

public class SkillFactory {
	public static BaseSkill getInstance(int id, int lv){
		switch(id){
		case BaseSkill.POWER_SKILL: return new PowerSkill(lv);
		case BaseSkill.MINJIE_SKILL: return new MinJieSkill(lv);
		case BaseSkill.SPEED_SKILL: return new SpeedSkill(lv);
		
		case BaseSkill.LongJuanFeng_Skill : return new LongJuanFengSkill(lv);
		
		case BaseSkill.FoShanWuYingJiao_Skill: return new FoShanWuYingJiaoSkill(lv);	//·ðÉ½ÎÞÓ°½Å
		default: return null;
		}
	}
}
