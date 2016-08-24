package game.skill;

import game.CalcTool;
import game.Player;

/**
 *  仙风云体
 * @author liupr
 *
 */

public class AttackDoubleSkill extends BaseSkill {

	public AttackDoubleSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BaseSkill.ATTACK_DOUBLE_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_ACTIVE_TRIGGER;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "仙风云体";
	}

	public void takeEffect(Player attacker, Player defender){
		// 子类有需求再去实现
		int lv = getSkillLv();
		int rate = 0;
		if (0 == lv) {
			rate = 20; //20%
		}
		
		if( CalcTool.probabilityInt(rate) ){
			System.out.println(attacker.GetPlayerName() + "触发仙风云体");
			attacker.getAttr().set_doubleHit(100); //必定连击
		}
	}

	
}
