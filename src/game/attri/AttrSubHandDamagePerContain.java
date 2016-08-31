package game.attri;

/**
 *  空手减伤百分比
 * @author lpr
 *
 */

public class AttrSubHandDamagePerContain extends AttrContain {

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
	
	public AttrSubHandDamagePerContain() {
		super(base.num.ordinal(), fightAdd.num.ordinal());
		// TODO Auto-generated constructor stub
	}

}
