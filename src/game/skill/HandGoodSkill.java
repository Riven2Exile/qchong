package game.skill;

import game.Attr;
import game.Player;

/**
 *  肉搏好手
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

	public void calcAttr(Player player){
		int lv = getSkillLv();
		Attr attr = player.getAttr();
		if (0 == lv){
			attr.add_addEmptyHandDamagePer(20); //空手伤害增加了20%
		}
	}
}
