package game.attri;

/**
 *  ������ֵ�˺�
 * @author lpr
 *
 */

public class AttrAddHandDamageContain extends AttrContain {

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
	
	public AttrAddHandDamageContain() {
		super(base.num.ordinal(), fightAdd.num.ordinal());
		// TODO Auto-generated constructor stub
	}

}
