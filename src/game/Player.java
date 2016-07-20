package game;

public class Player {
	
	String _name = "";
	int _level = 0;
	Attr _attr = new Attr();
	
	// 技能map -> 方便查找
	SkillHelper _skill = new SkillHelper();
	
	// 武器
	WeaponHelper _weapon = new WeaponHelper();
	
	public void SetName(String s){
		_name = s;
	}
	
	public String GetPlayerName(){
		return _name;
	}
	
	public Attr getAttr(){
		return _attr;
	}
	
	public SkillHelper GetSkillHelper() {
		return _skill;
	}
	
	public WeaponHelper GetWeaponHelper(){
		return _weapon;
	}
	
	public void setLevel(int l){
		_level = l;
	}
	public int getLevel(){
		return _level;
	}
	// 武器list -> 无须查找,  需要有一个标记, 是否使用
}