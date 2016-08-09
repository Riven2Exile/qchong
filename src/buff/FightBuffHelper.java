package buff;

import java.util.HashMap;
import java.util.Map.Entry;

import game.Player;

public class FightBuffHelper {

	HashMap<Integer, BaseFightBuff> mData = new HashMap<>();
	Player _player;
	
	public FightBuffHelper(Player p) {
		// TODO Auto-generated constructor stub
		_player = p;
	}

	
	public void addBuff(BaseFightBuff buff){
		//// todo: ���֮ǰ�Ѿ������Buff, ���ܻ�ʱ�串��, ����ʱ�����, �����Ҫ����buff�����ö���, ����ʱʵ��Ϊ����
		// ����buffЧ��: ĿǰӦ��ֻ�и�����һ˵
		BaseFightBuff bBuff = mData.get(buff.getBuffID());
		if (bBuff != null) {
			bBuff.onClearBuff();
		}
		
		mData.put(buff.getBuffID(), buff);
		buff.onAddBuff();
	}
	
	public void removeBuff(int buffID){
		BaseFightBuff buff = mData.get(buffID);
		if (buff != null) {
			mData.remove(buffID);
			
			buff.onClearBuff();	//���buff�Ļص�
		}
	}
	
	/**
	 *  ������ϵ�buff������һ�غ�
	 */
	public void buffSubARound(){
		for (Entry<Integer, BaseFightBuff> entry : mData.entrySet()){
			if (entry.getValue().get_leftRound() <= 1) {
				removeBuff(entry.getKey());
			}
			else{
				entry.getValue().addLeftRound(-1);
			}
		}
	}
	
	/**
	 *  һ���غϵĿ�ʼ
	 */
	public void onARoundStart(){
		for (Entry<Integer, BaseFightBuff> entry : mData.entrySet()){
			entry.getValue().onARoundStart(_player);
		}
	}
}
