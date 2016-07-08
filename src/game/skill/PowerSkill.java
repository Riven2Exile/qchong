package game.skill;

import game.Player;

/*
 * ���ܣ���������
 */

public class PowerSkill extends BaseSkill{

	public PowerSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
		SKILL_ID = SkillInterface.POWER_SKILL; //��������
	}


	public void CalcAttr(Player player) {
		int nAddPower = 0;
		switch (getSkillLv()) {
		case 0:
			nAddPower = (int)Math.floor( player.getAttr().get_total_base_power() * 0.5 + 3); //����ʽ��ȷ����
			break;

		default:
			break;
		}
		
		player.getAttr().add_addi_power_skill(nAddPower); //���Ӽ��������ӳ�
	}
}
