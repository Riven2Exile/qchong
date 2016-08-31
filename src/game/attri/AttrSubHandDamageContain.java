package game.attri;

/**
 *  空手减伤 数值
 * @author lpr
 *
 */

public class AttrSubHandDamageContain extends AttrContain {

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
	
	public AttrSubHandDamageContain() {
		super(base.num.ordinal(), fightAdd.num.ordinal());
		// TODO Auto-generated constructor stub
	}

}
