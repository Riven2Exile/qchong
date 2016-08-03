package game.skill;

import game.Player;

/*
 *  技能：均衡发展
 */

public class BalanceSkill extends BaseSkill {

	public BalanceSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	public void calcAttr(Player player) {
		int nAddPower = 0;
		int nAddMinjie = 0;
		int nAddSpeed = 0;
		
		int nTotalBasePower = player.getAttr().get_total_base_power();
		int nTotalBaseMinjie = player.getAttr().get_total_base_minjie();
		int nTotalBaseSpeed = player.getAttr().get_total_base_speed();
		
		switch (getSkillLv()) {
		case 0:
			nAddPower = (int)Math.floor( nTotalBasePower * 0.2 + 1);
			nAddMinjie = (int)Math.floor( nTotalBaseMinjie * 0.2 + 1); 
			nAddSpeed = (int)Math.floor( nTotalBaseSpeed * 0.2 + 1);
			break;

		default:
			break;
		}
		
		player.getAttr().add_addi_power_skill(nAddPower);
		player.getAttr().add_addi_minjie_skill(nAddMinjie); //增加技能敏捷加成
		player.getAttr().add_addi_speed_skill(nAddSpeed);
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BALANCE_ATTR_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_FOREVER;
	}
}
