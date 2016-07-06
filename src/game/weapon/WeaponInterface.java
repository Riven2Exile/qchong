package game.weapon;

import game.Player;

public interface WeaponInterface {
	
	//产生效果
	public abstract void HandleEffect(Player attacker, Player defender); 
}

