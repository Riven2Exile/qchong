package game.fight;

import game.Player;

/**
 * ս����ʽ
 */

public interface FightWayInterface {
	int AW_Undefine 	= 0;	//δ����
	int AW_EmptyHand	= 1;	//���ֹ���
	int AW_Weapon		= 2;	//��������  (ֱ��ƽ�� or ����)
	int AW_ActiveMainSkill	= 3;	//��������
	int AW_ActiveTrigger	= 4; 	//��������Ч����, ����Ӱ�֣���Ӱ��
	int AW_AfterAttackHit = 5;		//�����������к󴥷�
	int AW_BeforeAttack	= 6;		//ȷ����������֮ǰ����
	
	
	void calcAttackEffect(Player attacker, Player defender); //���㹥��Ч��, ����������ӳɣ�Ҳ�����ǶԷ�dot
	int getFightWay();
}
