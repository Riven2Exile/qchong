package game;

import buff.FightBuffHelper;
import game.define.SexType;

public class Player {
	
	String _name = "";
	int _level = 0;
	int _sex = SexType.SEX_GIRL;
	
	Attr _attr = new Attr();
	
	// 技能map -> 方便查找
	SkillHelper _skill = new SkillHelper();
	
	// 武器
	WeaponHelper _weapon = new WeaponHelper();
	
	// 战斗buff
	FightBuffHelper _fFightBuffHelper = new FightBuffHelper(this);
	
	
	
	/* ************* 方法   *************/
	
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
	 * 玩家是否死亡
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
	
	
	// 武器list -> 无须查找,  需要有一个标记, 是否使用
}