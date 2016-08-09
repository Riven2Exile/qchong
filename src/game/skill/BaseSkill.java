package game.skill;

import game.Player;

public abstract class BaseSkill implements SkillInterface{
	int _skillLv = 0;	//���ܵȼ�
	int _useCount = 0;	//����ʹ�ô���

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
	public abstract int getSkillType(); //��������
	
	/**
	 *  ����Ч��
	 */
	public void takeEffect(Player attacker, Player defender){
		// ������������ȥʵ��
	}
	
	public int getDamage(Player attacker, Player defender) {
		return 0;
	}
}
