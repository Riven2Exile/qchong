package game;

public class Player {
	
	String _name = "";
	Attr _attr = new Attr();
	
	// ����map -> �������
	SkillHelper _skill = new SkillHelper();
	
	// ����
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
	// ����list -> �������,  ��Ҫ��һ�����, �Ƿ�ʹ��
}