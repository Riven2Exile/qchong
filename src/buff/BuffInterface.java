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
	
	
	/*****
	 *  buff type
	 */
	int BuffType_good 	= 0;	//����buff
	int BuffType_dot	= 1;	//����buff
	
	/******
	 *  buff ö��
	 */
	int Buff_Undefine 	= -1;	//δ����
	int Buff_QErNaoYang	= 0;	//�������
}
