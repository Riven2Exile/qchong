package game.skill;

import game.Player;

public interface SkillInterface {
	// ��������
	abstract void CalcAttr(Player player);
	
	// ����˺�
	abstract int GetDamage(Player player);
}
