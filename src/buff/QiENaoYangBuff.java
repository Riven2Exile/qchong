package buff;

import game.Player;

public class QiENaoYangBuff extends BaseFightBuff {

	public QiENaoYangBuff() {
		// TODO Auto-generated constructor stub
	}

	public int getBuffID() {
		// TODO Auto-generated method stub
		return Buff_QErNaoYang;
	}
	
	public int getBuffType(){
		return BuffType_dot;
	}
	
	public void onARoundStart(Player player){
		// 扣血
		player.getAttr().add_final_hp(-getData());
		System.out.println("玩家"+player.GetPlayerName()+"由于企鹅挠痒被扣血" + getData() + "剩余血量" + player.getAttr().get_final_hp() + "/" + player.getAttr().get_max_hp());
	}
}
