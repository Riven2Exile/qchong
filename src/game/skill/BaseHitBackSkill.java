package game.skill;

/**
 *  ������������
 * @author lpr
 *
 */

public abstract class BaseHitBackSkill extends BaseSkill {

	public BaseHitBackSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	public abstract int getSkillID();
	public int getSkillType(){ return SKILLTYPE_ATTACKED_BACK; } //��������
	public abstract String getName();	//��������

	public boolean canTrigger(){
		return true;
	}
	
	
}
