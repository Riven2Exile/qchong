package buff;

/**
 * 通用 buff 接口
 */
public interface BuffInterface {
	
	/**
	 * 获得buffID
	 */
	int getBuffID();
	
	/**
	 * 获得Buff之后的
	 */
	void onAddBuff();
	
	/**
	 * buff清除之后
	 */
	void onClearBuff();
	
	
	/*****
	 *  buff type
	 */
	int BuffType_good 	= 0;	//增益buff
	int BuffType_dot	= 1;	//减益buff
	
	/******
	 *  buff 枚举
	 */
	int Buff_Undefine 	= -1;	//未定义
	int Buff_QErNaoYang	= 0;	//企鹅挠痒
}
