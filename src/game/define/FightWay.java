package game.define;

/*
 * ������ʽ
 */

interface FightWay {
	int FIGHTWAY_UNDEFINE	= 0;	//δ����
	int WAY_EMPTY_HAND 	= 1; //���ֹ���
	int WAY_SKILL		= 2; //����
	int WAY_WEAPON		= 3; //����ֱ�ӹ���
}


// ����������ʽ
interface WeaponWay{
	int WEAPON_WAY_UNDEFINE	= 0;	//δ����
	int WEAPON_WAY_DIRECT 	= 1;	//ֱ�ӹ���
	int WEAPON_WAY_THROW	= 2;	//��������
}