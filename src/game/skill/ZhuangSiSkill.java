package game.skill;

import game.Player;

/**
 *  装死
 *
 */

public class ZhuangSiSkill extends BaseSkill {

	public ZhuangSiSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return SkillInterface.ZhuangSi_Skill;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return BaseSkill.SKILLTYPE_DYING_TRIGGER;
	}

	public void takeEffect(Player self, Player defender){
		switch (getSkillLv())
		{
		case 0:{
			self.getAttr().set_final_hp(1);	//生命值变成1
		}break;
		}

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "装死";
	}
}
