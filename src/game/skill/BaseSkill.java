package game.skill;

import game.Player;

public abstract class BaseSkill implements SkillInterface{
	public static int SKILL_ID = UNDEFINE_SKILL;
	int _skillLv = 0;

	public BaseSkill(int lv) {
		_skillLv = lv;
	}
	
	public int getSkillLv() {
		return _skillLv;
	}

	public void setSkillLv(int _skillLv) {
		this._skillLv = _skillLv;
	}
	
	//public abstract void setSkillID(int id);
	public int getSkillID(){
		return SKILL_ID;
	}
	
	public void CalcAttr(Player player){
		// 子类有需求再去实现
	}
	
	public int GetDamage(Player player) {
		return 0;
	}
}
