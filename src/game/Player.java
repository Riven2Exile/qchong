package game;

public class Player {
	Attr _attr = new Attr();
	
	// ����map -> �������
	SkillHelper _skill = new SkillHelper();
	
	// ����
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
	// ����list -> �������,  ��Ҫ��һ�����, �Ƿ�ʹ��
}