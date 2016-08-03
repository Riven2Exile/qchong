package game.skill;

/**
 *  œ…∑Á‘∆ÃÂ
 * @author liupr
 *
 */

public class AttackDoubleSkill extends BaseSkill {

	public AttackDoubleSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BaseSkill.ATTACK_DOUBLE_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_ACTIVE_TRIGGER;
	}

}
