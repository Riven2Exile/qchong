package buff;

import game.Player;

/**
 *  回合制战斗中使用的buff
 * @author lpr
 *
 */
public class BaseFightBuff implements BuffInterface{

	int _leftRound = 0;	//剩余回合数
	int _data = 0;	//各自的buff有各自的意义
	//boolean _bLimitRound = false; //是否为无限时间的buff
	
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
	 *  一个buff开始之前要触发什么?
	 * @param player
	 */
	public void onARoundStart(Player player){
		
	}
	
	/**
	 *  一个dot结束的时候要触发什么?
	 * @return
	 */
	public void onARoundEnd(Player player){
		
	}
	
	public int getBuffType(){
		return BuffType_good;
	}

}
