package game.skill;

import game.Player;

public class BaseSkill implements SkillInterface{
	int _skillLv = 0;

	public int get_skillLv() {
		return _skillLv;
	}

	public void set_skillLv(int _skillLv) {
		this._skillLv = _skillLv;
	}
	
	public void CalcAttr(Player player){
		// ������������ȥʵ��
	}
	
	public int GetDamage(Player player) {
		return 0;
	}
}
