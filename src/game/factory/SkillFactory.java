package game.factory;

import game.skill.BaseSkill;
import game.skill.MinJieSkill;
import game.skill.PowerSkill;
import game.skill.SpeedSkill;

public class SkillFactory {
	public static BaseSkill getInstance(int id, int lv){
		switch(id){
		case BaseSkill.POWER_SKILL: return new PowerSkill(lv);
		case BaseSkill.MINJIE_SKILL: return new MinJieSkill(lv);
		case BaseSkill.SPEED_SKILL: return new SpeedSkill(lv);
		default: return null;
		}
	}
}
