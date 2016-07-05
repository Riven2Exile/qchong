package game.factory;

import game.skill.BaseSkill;
import game.skill.SpeedSkill;

public class SkillFactory {
	public static BaseSkill getInstance(int id, int lv){
		switch(id){
		case BaseSkill.SPEED_SKILL: return new SpeedSkill(lv);
		default: return null;
		}
	}
}
