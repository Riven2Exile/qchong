package game.skill;

import game.Player;

/**
 *  佛山无影脚
 * @author liupr
 *
 */

public class FoShanWuYingJiaoSkill extends BaseSkill{

	public FoShanWuYingJiaoSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return FoShanWuYingJiao_Skill;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_ACTIVE_MAIN;
	}
	

	/**
	 * 造成主动伤害
	 */
	public int GetDamage(Player player) {
		int lv = getSkillLv();
		if (lv == 0){
			return (int)Math.floor( 30 + player.getAttr().get_final_power() * 0.5 );
		}
		
		return 0;
	}

	
}
