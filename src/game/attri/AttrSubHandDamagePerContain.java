package game.attri;

/**
 *  ���ּ��˰ٷֱ�
 * @author lpr
 *
 */

public class AttrSubHandDamagePerContain extends AttrContain {

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
	
	public AttrSubHandDamagePerContain() {
		super(base.num.ordinal(), fightAdd.num.ordinal());
		// TODO Auto-generated constructor stub
	}

}
