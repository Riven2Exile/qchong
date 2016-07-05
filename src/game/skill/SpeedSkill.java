package game.skill;

import game.Player;

/*
 *  技能:快人一步
 * */
public class SpeedSkill extends BaseSkill{
	
	public SpeedSkill(int id, int lv) {
		super(id, lv);
		// TODO Auto-generated constructor stub
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
		
		player.getAttr().add_addi_speed_skill(nAddSpeed); //增加技能速度加成
	}
}
