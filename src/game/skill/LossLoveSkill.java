package game.skill;

import game.Player;

/**
 * «ÁÃÏ≈˘ˆ®
 * @author liupr
 *
 */

public class LossLoveSkill extends BaseSkill {

	public LossLoveSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BaseSkill.LOSS_LOVE_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return BaseSkill.SKILLTYPE_ACTIVE_MAIN;
	}

	public int getDamage(Player attacker, Player defender) {
		int lv = getSkillLv();
		if (0 == lv){
			int nDamage = (int)Math.floor( 15 + attacker.getLevel() * 1.5 );
			if(attacker.getSex() != defender.getSex()){
				nDamage += nDamage * 0.1;   //“Ï–‘…À∫¶+ 10%
			}
			return nDamage;
		}
		return 0;
	}
}
