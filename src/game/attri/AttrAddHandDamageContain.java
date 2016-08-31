package game.attri;

/**
 *  空手数值伤害
 * @author lpr
 *
 */

public class AttrAddHandDamageContain extends AttrContain {

	public enum base{
		base,
		skill,	//永久技能 
		
		num,
	}
	
	public enum fightAdd{
		skill,
		buff,
		
		num,
	}
	
	public AttrAddHandDamageContain() {
		super(base.num.ordinal(), fightAdd.num.ordinal());
		// TODO Auto-generated constructor stub
	}

}
