package game.skill;

import game.Attr;
import game.Player;

/**
 *  �ⲫ����
 * @author liupr
 *
 */
public class HandGoodSkill extends BaseSkill {

	public HandGoodSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BaseSkill.HAND_GOOD_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return BaseSkill.SKILLTYPE_FOREVER;
	}

	public void takeEffect(Player attacker, Player defender){
		int lv = getSkillLv();
		Attr attr = attacker.getAttr();
		if (0 == lv){
			attr.add_addEmptyHandDamagePer(20); //�����˺�������20%
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "�ⲫ����";
	}
}
