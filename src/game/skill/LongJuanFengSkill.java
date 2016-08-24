package game.skill;

import game.Player;

/**
 * Áú¾í·ç
 */
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

	public int getDamage(Player attacker, Player defender) {
		int lv = getSkillLv();
		if(lv == 0) {
			return (int)Math.floor( 20 + attacker.getAttr().get_final_power() * 0.8 );
		}
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Áú¾í·ç";
	}
}
