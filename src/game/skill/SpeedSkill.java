package game.skill;

import game.Player;

public class SpeedSkill extends BaseSkill{
	
	public void CalcAttr(Player player) {
		int nAddSpeed = 0;
		switch (get_skillLv()) {
		case 0:
			nAddSpeed = (int)Math.floor( player.getAttr().get_total_base_speed() * 0.5 + 3);
			break;

		default:
			break;
		}
		
		player.getAttr().add_addi_speed_skill(nAddSpeed); //增加技能速度加成
	}
}
