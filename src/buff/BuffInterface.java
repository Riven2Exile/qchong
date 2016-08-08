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
}
