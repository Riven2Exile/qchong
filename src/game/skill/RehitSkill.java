package game.skill;

/**
 *  �������� (��δʵ��)
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
		return BaseSkill.SKILLTYPE_ATTACKED_TRIGGER;
	}

}
