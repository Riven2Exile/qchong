package game;

/**
 *  ������������
 * @author liupr
 *
 */

public class AttrHitContain extends AttrContain{

	//�������� 
	enum hitBase{
		hit_base, 
		hit_num,	//�������һ��
	}
	
	/**
	 * ������������
	 */
	enum hitAddi{
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
