package game;

public class Player {
	Attr _attr = new Attr();
	
	// 技能map -> 方便查找
	SkillHelper _skill = new SkillHelper();
	
	// 武器
	WeaponHelper _weapon = new WeaponHelper();
	
	public Attr getAttr(){
		return _attr;
	}
	
	public SkillHelper GetSkillHelper() {
		return _skill;
	}
	
	public WeaponHelper GetWeaponHelper(){
		return _weapon;
	}
	// 武器list -> 无须查找,  需要有一个标记, 是否使用
}