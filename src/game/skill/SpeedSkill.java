package game.skill;

import game.Player;

/*
 *  ����:����һ��
 * */
public class SpeedSkill extends BaseSkill{
	
	//public final static int SKILL_ID = SkillInterface.SPEED_SKILL; //����һ��
	
	
	public SpeedSkill(int lv) {
		super(lv);
	}

	public void CalcAttr(Player player) {
		int nAddSpeed = 0;
		switch (getSkillLv()) {
		case 0:
			nAddSpeed = (int)Math.floor( player.getAttr().get_total_base_speed() * 0.5 + 3);
			break;

		default:
			break;
		}
		
		player.getAttr().add_addi_speed_skill(nAddSpeed); //���Ӽ����ٶȼӳ�
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return SkillInterface.SPEED_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_FOREVER;
	}

}
