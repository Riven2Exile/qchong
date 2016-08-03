package game.skill;

import game.Attr;
import game.Player;

/**
 * hp ¼¼ÄÜ
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

	public void calcAttr(Player player){
		int lv = getSkillLv();
		Attr attr = player.getAttr();
		if(0 == lv){
			attr.add_addi_hp(  (int) Math.floor(attr.get_base_hp() * 0.15 + 8 )   );
		}
	}
}
