package game;

public class Player {
	
	String _name = "";
	int _level = 0;
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
	
	public void setLevel(int l){
		_level = l;
	}
	public int getLevel(){
		return _level;
	}
	// ����list -> �������,  ��Ҫ��һ�����, �Ƿ�ʹ��
}