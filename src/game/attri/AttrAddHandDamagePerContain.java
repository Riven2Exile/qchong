package game.attri;

/**
 *  空手增伤百分比
 * @author lpr
 *
 */

public class AttrAddHandDamagePerContain extends AttrContain {

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
	
	public AttrAddHandDamagePerContain() {
		super(base.num.ordinal(), fightAdd.num.ordinal());
		// TODO Auto-generated constructor stub
	}

}
