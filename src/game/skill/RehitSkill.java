package game.skill;

/**
 *  反击技能 (暂未实现)
 * @author liupr
 *
 */
public class RehitSkill extends BaseSkill {

	public RehitSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BaseSkill.REHIT_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return BaseSkill.SKILLTYPE_BEAT_BACK;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "反击";
	}

}
