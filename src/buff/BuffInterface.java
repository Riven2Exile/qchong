package buff;

/**
 * ͨ�� buff �ӿ�
 */
public interface BuffInterface {
	
	/**
	 * ���buffID
	 */
	int getBuffID();
	
	/**
	 * ���Buff֮���
	 */
	void onAddBuff();
	
	/**
	 * buff���֮��
	 */
	void onClearBuff();
	
	
	/******
	 *  buff ö��
	 */
	int Buff_Undefine 	= -1;	//δ����
	int Buff_QErNaoYang	= 0;	//�������
}
