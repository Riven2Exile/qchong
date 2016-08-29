package game;

/**
 *  命中属性容器
 * @author liupr
 *
 */

public class AttrHitContain extends AttrContain{

	//基础命中 
	enum hitBase{
		hit_base, 
		hit_num,	//放在最后一项
	}
	
	/**
	 * 附加命中属性
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
