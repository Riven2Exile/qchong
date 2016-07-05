package game;

import java.util.HashMap;

import game.skill.BaseSkill;

public class Player {
	Attr _attr;
	
	// 技能map -> 方便查找
	HashMap<Integer, BaseSkill> _skill;
	
	
	
	public Attr getAttr(){
		return _attr;
	}
	
	
	
	
	// 武器list -> 无须查找,  需要有一个标记, 是否使用
}