package game.skill;

import game.Player;

public abstract class BaseSkill implements SkillInterface{
	int _skillLv = 0;	//技能等级
	int _useCount = 0;	//技能使用次数

	public BaseSkill(int lv) {
		_skillLv = lv;
	}
	
	public int getSkillLv() {
		return _skillLv;
	}

	public void setSkillLv(int _skillLv) {
		this._skillLv = _skillLv;
	}
	
	public void setUseCount(int n){
		this._useCount = n;
	}
	public int getUseCount(){
		return this._useCount;
	}
	public void addUseCount(int n){
		this._useCount += n;
	}
	
	
	//public abstract void setSkillID(int id);
	public abstract int getSkillID();
	public abstract int getSkillType(); //技能类型
	
	/**
	 *  技能效果
	 */
	public void takeEffect(Player attacker, Player defender){
		// 子类有需求再去实现
	}
	
	public int getDamage(Player attacker, Player defender) {
		return 0;
	}
}
