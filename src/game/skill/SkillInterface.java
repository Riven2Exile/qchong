package game.skill;

import game.Player;

public interface SkillInterface {
	// �������� , �Ƿ�������� buff����(�����е�)
	abstract void CalcAttr(Player player);
	
	// ����˺�
	abstract int GetDamage(Player player);
	
	// buff���� , dot
}
