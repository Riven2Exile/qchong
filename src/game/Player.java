package game;

import java.util.HashMap;

import game.skill.BaseSkill;

public class Player {
	Attr _attr = new Attr();
	
	// ����map -> �������
	SkillHelper _skill = new SkillHelper();
	
	
	
	public Attr getAttr(){
		return _attr;
	}
	
	public SkillHelper GetSkillHelper() {
		return _skill;
	}
	
	
	// ����list -> �������,  ��Ҫ��һ�����, �Ƿ�ʹ��
}