package game;

import java.util.HashMap;

import game.skill.BaseSkill;

public class Player {
	Attr _attr;
	
	// ����map -> �������
	HashMap<Integer, BaseSkill> _skill;
	
	
	
	public Attr getAttr(){
		return _attr;
	}
	
	
	
	
	// ����list -> �������,  ��Ҫ��һ�����, �Ƿ�ʹ��
}