package game.attri;

/**
 *  ������������
 * @author liupr
 *
 */

public class AttrHitContain extends AttrContain{

	//�������� 
	public enum hitBase{
		hit_base, 
		hit_num,	//�������һ��
	}
	
	/**
	 * ������������
	 */
	public enum hitAddi{
		hit_skill,
		hit_buff,
		bit_equip,
		hit_num,
	}
	
	public AttrHitContain(int baseSize, int addSize) {
		super(baseSize, addSize);
		// TODO Auto-generated constructor stub
	}

	
}
