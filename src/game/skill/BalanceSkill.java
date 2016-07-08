package game.skill;

import game.Player;

/*
 *  技能：均衡发展
 */

public class BalanceSkill extends BaseSkill {

	public BalanceSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
		SKILL_ID = BALANCE_ATTR_SKILL;  //均衡发展
	}

	public void CalcAttr(Player player) {
		int nAddPower = 0;
		int nAddMinjie = 0;
		int nAddSpeed = 0;
		
		int nTotalBasePower = player.getAttr().get_total_base_power();
		int nTotalBaseMinjie = player.getAttr().get_total_base_minjie();
		int nTotalBaseSpeed = player.getAttr().get_total_base_speed();
		
		switch (getSkillLv()) {
		case 0:
			nAddPower = (int)Math.floor( nTotalBasePower * 0.5 + 2);
			nAddMinjie = (int)Math.floor( nTotalBaseMinjie * 0.5 + 2); //【公式待确定】
			nAddSpeed = (int)Math.floor( nTotalBaseSpeed * 0.5 + 2);
			break;

		default:
			break;
		}
		
		player.getAttr().add_addi_power_skill(nAddPower);
		player.getAttr().add_addi_minjie_skill(nAddMinjie); //增加技能敏捷加成
		player.getAttr().add_addi_speed_skill(nAddSpeed);
	}
}
