package game;

import buff.FightBuffHelper;
import game.define.SexType;

public class Player {
	
	String _name = "";
	int _level = 0;
	int _sex = SexType.SEX_GIRL;
	
	Attr _attr = new Attr();
	
	// ����map -> �������
	SkillHelper _skill = new SkillHelper();
	
	// ����
	WeaponHelper _weapon = new WeaponHelper();
	
	// ս��buff
	FightBuffHelper _fFightBuffHelper = new FightBuffHelper(this);
	
	
	
	/* ************* ����   *************/
	
	public void SetName(String s){
		_name = s;
	}
	
	public String GetPlayerName(){
		return _name;
	}
	
	public void setLevel(int l){
		_level = l;
	}
	public int getLevel(){
		return _level;
	}
	
	public void setSex(int sex){
		_sex = sex;
	}
	public int getSex(){
		return _sex;
	}
	
	public Attr getAttr(){
		return _attr;
	}
	
	/**
	 * ����Ƿ�����
	 * @return
	 */
	public boolean isDie(){
		return _attr.get_final_hp() <= 0;
	}
	
	public SkillHelper GetSkillHelper() {
		return _skill;
	}
	
	public WeaponHelper GetWeaponHelper(){
		return _weapon;
	}
	
	public FightBuffHelper GetFightBuffHelper(){
		return _fFightBuffHelper;
	}
	
	
	// ����list -> �������,  ��Ҫ��һ�����, �Ƿ�ʹ��
}