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
		//// todo: 如果之前已经有这个Buff, 可能会时间覆盖, 或者时间叠加, 这个需要根据buff的配置而定, 先暂时实现为覆盖
		// 关于buff效果: 目前应该只有覆盖这一说
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
			
			buff.onClearBuff();	//清除buff的回调
		}
	}
	
	/**
	 *  玩家身上的buff各减少一回合
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
	 *  一个回合的开始
	 */
	public void onARoundStart(){
		for (Entry<Integer, BaseFightBuff> entry : mData.entrySet()){
			entry.getValue().onARoundStart(_player);
		}
	}
}
