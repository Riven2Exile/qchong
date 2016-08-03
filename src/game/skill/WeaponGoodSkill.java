package game.skill;

import game.Attr;
import game.Player;

public class WeaponGoodSkill extends BaseSkill {

	public WeaponGoodSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return BaseSkill.WEAPON_GOOD_SKILL;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return BaseSkill.SKILLTYPE_FOREVER;
	}

	@Override
	public void calcAttr(Player player){
		int lv = getSkillLv();
		Attr attr = player.getAttr();
		if (0 == lv){
			attr.add_addLargeWeaponDamagePer(20); //20%
			attr.add_addMidWeaponDamagePer(20);
			attr.add_addTinyWeaponDamagePer(20);
			attr.add_addThrowWeaponDamagePer(20);
		}
	}
}
