package game.weapon;

import game.Player;
import game.RangeInt;

public interface WeaponInterface {
	
	//产生效果
	public abstract void HandleEffect(Player attacker, Player defender); 
	
}

