package game.skill;

import game.Attr;
import game.Player;

/**
 * hp 技能
 * @author liupr
 *
 */
public class HpSkill extends BaseSkill {

	public HpSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BaseSkill.HP_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_FOREVER;
	}

	public void takeEffect(Player attacker, Player defender){
		int lv = getSkillLv();
		Attr attr = attacker.getAttr();
		if(0 == lv){
			attr.add_addi_hp(  (int) Math.floor(attr.get_base_hp() * 0.15 + 8 )   );
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "hp 技能";
	}
}
