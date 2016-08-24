package game.skill;

import game.Player;

/*
 *  技能：身手敏捷
 */

public class MinJieSkill extends BaseSkill {

	public MinJieSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	public void takeEffect(Player attacker, Player defender) {
		int nAddMinjie = 0;
		int nTotalBaseMinjie = attacker.getAttr().get_total_base_minjie();
		switch (getSkillLv()) {
		case 0:
			nAddMinjie = (int)Math.floor( nTotalBaseMinjie * 0.5 + 3); //【公式待确定】
			break;

		default:
			break;
		}
		
		attacker.getAttr().add_addi_minjie_skill(nAddMinjie); //增加技能敏捷加成
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return MINJIE_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_FOREVER;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "身手敏捷";
	}
}
