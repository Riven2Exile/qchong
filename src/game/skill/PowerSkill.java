package game.skill;

import game.Player;

/*
 * 技能：天生大力
 */

public class PowerSkill extends BaseSkill{

	public PowerSkill(int lv) {
		super(lv);
	}


	public void calcAttr(Player player) {
		int nAddPower = 0;
		switch (getSkillLv()) {
		case 0:
			nAddPower = (int)Math.floor( player.getAttr().get_total_base_power() * 0.5 + 3); //【公式待确定】
			break;

		default:
			break;
		}
		
		player.getAttr().add_addi_power_skill(nAddPower); //增加技能力量加成
	}


	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return POWER_SKILL;
	}


	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_FOREVER;
	}
}
