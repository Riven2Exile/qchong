package game.attri;

/**
 *  ���ּ��� ��ֵ
 * @author lpr
 *
 */

public class AttrSubHandDamageContain extends AttrContain {

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
	
	public AttrSubHandDamageContain() {
		super(base.num.ordinal(), fightAdd.num.ordinal());
		// TODO Auto-generated constructor stub
	}

}
