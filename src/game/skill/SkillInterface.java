package game.skill;

import game.Player;

public interface SkillInterface {
	
	public final static int SPEED_SKILL = 3;	//����һ��
	
	// �������� , �Ƿ�������� buff����(�����е�)
	abstract void CalcAttr(Player player);
	
	// ����˺�
	abstract int GetDamage(Player player);
	
	// buff���� , dot
}
