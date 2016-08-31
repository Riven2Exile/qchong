package game.skill;

import game.fight.FightWayInterface;

/**
 *  »ù´¡·ÀÓù¼¼ÄÜ
 * @author lpr
 *
 */

public abstract class BaseDefenseSkill extends BaseSkill {

	public BaseDefenseSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract int getSkillID();

	@Override
	public int getSkillType() {
		return SKILLTYPE_BEAT_DEFEND;
	}

	@Override
	public abstract String getName();

	public boolean canTrigger(int nFightWay, int id){
		return false;
	}
	
	public int defense(int damage){
		return damage;
	}
}
