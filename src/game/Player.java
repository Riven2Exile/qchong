package game;

import java.util.HashMap;

import game.skill.BaseSkill;

public class Player {
	Attr _attr = new Attr();
	
	// 技能map -> 方便查找
	SkillHelper _skill = new SkillHelper();
	
	
	
	public Attr getAttr(){
		return _attr;
	}
	
	public SkillHelper GetSkillHelper() {
		return _skill;
	}
	
	
	// 武器list -> 无须查找,  需要有一个标记, 是否使用
}