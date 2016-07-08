package game.skill;

import game.Player;

/*
 *  ���ܣ����ⷢչ
 */

public class BalanceSkill extends BaseSkill {

	public BalanceSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
		SKILL_ID = BALANCE_ATTR_SKILL;  //���ⷢչ
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
			nAddMinjie = (int)Math.floor( nTotalBaseMinjie * 0.5 + 2); //����ʽ��ȷ����
			nAddSpeed = (int)Math.floor( nTotalBaseSpeed * 0.5 + 2);
			break;

		default:
			break;
		}
		
		player.getAttr().add_addi_power_skill(nAddPower);
		player.getAttr().add_addi_minjie_skill(nAddMinjie); //���Ӽ������ݼӳ�
		player.getAttr().add_addi_speed_skill(nAddSpeed);
	}
}
