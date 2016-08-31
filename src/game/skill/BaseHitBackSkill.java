package game.skill;

/**
 *  基础反击技能
 * @author lpr
 *
 */

public abstract class BaseHitBackSkill extends BaseSkill {

	public BaseHitBackSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	public abstract int getSkillID();
	public int getSkillType(){ return SKILLTYPE_ATTACKED_BACK; } //技能类型
	public abstract String getName();	//技能名称

	public boolean canTrigger(){
		return true;
	}
	
	
}
