package game.attri;

/**
 *  ÉÁ±ÜÂÊ
 * @author lpr
 *
 */

public class AttrDodgeContain extends AttrContain {

	/**
	 * »ù´¡ÉÁ±Ü
	 */
	public enum dodgeBase{
		dodge_base,
		
		
		dodge_num,
	}
	
	public enum dodgeAddi{
		dodge_skill,
		dodge_equip,
		dodge_buff,
		
		dodge_num,
	}
	
	public AttrDodgeContain(int baseSize, int addSize) {
		super(baseSize, addSize);
		// TODO Auto-generated constructor stub
	}

}
