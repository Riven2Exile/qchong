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
		// ��Ѫ
		player.getAttr().add_final_hp(-getData());
		System.out.println("���"+player.GetPlayerName()+"���������������Ѫ" + getData() + "ʣ��Ѫ��" + player.getAttr().get_final_hp() + "/" + player.getAttr().get_max_hp());
	}
}
