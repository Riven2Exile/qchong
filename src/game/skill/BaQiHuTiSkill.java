package game.skill;

import game.CalcTool;
import game.fight.FightWayInterface;

/**
 * 霸气护体
 * @author lpr
 *
 */

public class BaQiHuTiSkill extends BaseDefenseSkill {

	public BaQiHuTiSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return SkillInterface.BaQiHuTi_SKILL;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "霸气护体";
	}

	public boolean canTrigger(int nFightWay, int id){
		if (nFightWay != FightWayInterface.AW_EmptyHand && nFightWay != FightWayInterface.AW_Weapon) {
			return false;
		}
		int lv = getSkillLv();
		if (lv == 0) {
			return CalcTool.probabilityInt(15);
		}
		return false;
	}
	
	public int defense(int damage){
		int lv = getSkillLv();
		if (0 == lv) {
			damage = (int)Math.floor(damage * 0.5);
		}
		return damage;
	}
}
