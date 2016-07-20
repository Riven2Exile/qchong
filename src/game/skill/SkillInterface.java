package game.skill;

import game.Player;

public interface SkillInterface {
	
	///// ����id
	public final static int UNDEFINE_SKILL  = 0;	//δ���弼��
	public final static int POWER_SKILL 	= 1;    //��������
	public final static int MINJIE_SKILL	= 2;	//��������
	public final static int SPEED_SKILL 	= 3;	//����һ��
	public final static int HP_SKILL		= 4; 	//ǿ������
	public final static int BALANCE_ATTR_SKILL	= 5;	//���ⷢչ
	//public final static int  //6.��������
	//7.�ⲫ����
	//8.������
	
	
	
	///// ��������
	int SKILLTYPE_UNDEFINE	= 0;	//δ���弼������
	int SKILLTYPE_FOREVER 	= 1;	//������    (һ��Ϊ���������Եļ���)
	
	// �������� , �Ƿ�������� buff����(�����е�)
	abstract void CalcAttr(Player player);
	
	// ����˺�
	abstract int GetDamage(Player player);
	
	// buff���� , dot
}
