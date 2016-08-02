package game.skill;

import game.Player;

public class LongJuanFengSkill extends BaseSkill {

	public LongJuanFengSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BaseSkill.LongJuanFeng_Skill;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SkillInterface.SKILLTYPE_ACTIVE_MAIN;
	}

	public int getDamage(Player player) {
		int lv = getSkillLv();
		if(lv == 0) {
			return (int)Math.floor( 20 + player.getAttr().get_final_power() * 0.8 );
		}
		return 0;
	}
}
