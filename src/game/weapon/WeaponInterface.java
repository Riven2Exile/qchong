package game.weapon;

import game.Player;
import game.Pair;

public interface WeaponInterface {
	
	//产生效果
	public void HandleEffect(Player attacker, Player defender); 
	
}

