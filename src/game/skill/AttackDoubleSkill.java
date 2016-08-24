package game.skill;

import game.CalcTool;
import game.Player;

/**
 *  �ɷ�����
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
		return "�ɷ�����";
	}

	public void takeEffect(Player attacker, Player defender){
		// ������������ȥʵ��
		int lv = getSkillLv();
		int rate = 0;
		if (0 == lv) {
			rate = 20; //20%
		}
		
		if( CalcTool.probabilityInt(rate) ){
			System.out.println(attacker.GetPlayerName() + "�����ɷ�����");
			attacker.getAttr().set_doubleHit(100); //�ض�����
		}
	}

	
}
