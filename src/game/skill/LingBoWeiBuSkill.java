package game.skill;

import game.Player;

/**
 *  �貨΢��
 * @author lpr
 *
 */

public class LingBoWeiBuSkill extends BaseSkill {

	public LingBoWeiBuSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BaseSkill.LingBoWeiBu_Skill;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_FOREVER;
	}
	
	// ����Ч��
	public void takeEffect(Player attacker, Player defender){
		int lv = getSkillLv();
		if (0 == lv) {
			attacker.getAttr().add_addi_dodge(7); //7%��������
		}
	}

}
