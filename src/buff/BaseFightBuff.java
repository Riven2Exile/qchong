package buff;

import game.Player;

/**
 *  �غ���ս����ʹ�õ�buff
 * @author lpr
 *
 */
public class BaseFightBuff implements BuffInterface{

	int _leftRound = 0;	//ʣ��غ���
	int _data = 0;	//���Ե�buff�и��Ե�����
	//boolean _bLimitRound = false; //�Ƿ�Ϊ����ʱ���buff
	
	public BaseFightBuff() {
		// TODO Auto-generated constructor stub
	}

	public void set_leftRound(int _leftRound) {
		this._leftRound = _leftRound;
	}
	public int get_leftRound() {
		return _leftRound;
	}
	public void addLeftRound(int n){
		this._leftRound += n;
	}
	
	public void setData(int data) {
		_data = data;
	}
	public int getData() {
		return _data;
	}
	
	@Override
	public int getBuffID() {
		// TODO Auto-generated method stub
		return Buff_Undefine;
	}

	@Override
	public void onAddBuff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClearBuff() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 *  һ��buff��ʼ֮ǰҪ����ʲô?
	 * @param player
	 */
	public void onARoundStart(Player player){
		
	}
	
	/**
	 *  һ��dot������ʱ��Ҫ����ʲô?
	 * @return
	 */
	public void onARoundEnd(Player player){
		
	}
	
	public int getBuffType(){
		return BuffType_good;
	}

}
