package game.skill;

/**
 * 技能:残影
 */
public class CanYingSkill extends BaseSkill {

	public CanYingSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return SkillInterface.CanYing_Skill;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_ACTIVE_TRIGGER; //... 这种类型 
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "残影";
	}

}
