package game.skill;

import game.Player;

/*
 *  ���ܣ���������
 */

public class MinJieSkill extends BaseSkill {

	public MinJieSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
		SKILL_ID = MINJIE_SKILL;	// ��������
	}

	public void CalcAttr(Player player) {
		int nAddMinjie = 0;
		int nTotalBaseMinjie = player.getAttr().get_total_base_minjie();
		switch (getSkillLv()) {
		case 0:
			nAddMinjie = (int)Math.floor( nTotalBaseMinjie * 0.5 + 3); //����ʽ��ȷ����
			break;

		default:
			break;
		}
		
		player.getAttr().add_addi_minjie_skill(nAddMinjie); //���Ӽ������ݼӳ�
	}
}