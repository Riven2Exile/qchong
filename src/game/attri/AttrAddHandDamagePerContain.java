package game.attri;

/**
 *  �������˰ٷֱ�
 * @author lpr
 *
 */

public class AttrAddHandDamagePerContain extends AttrContain {

	public enum base{
		base,
		skill,	//���ü��� 
		
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
