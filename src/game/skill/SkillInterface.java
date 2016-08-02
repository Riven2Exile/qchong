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
	public final static int WEAPON_GOOD_SKILL	= 6;	//��������
	public final static int HAND_GOOD_SKILL	= 7;	//�ⲫ����
	public final static int REHIT_SKILL		= 8;	//������
	public final static int LOSS_LOVE_SKILL	= 9;	//��������
	public final static int ATTACK_DOUBLE_SKILL	= 10;	//��Ӱ��
	public final static int BaoQiHuTi_SKILL	= 11;	//��������
	public final static int DaHaiWuLiang_SKILL	= 12;	//������
	public final static int PiCaoRouHou_Skill	= 13;	//Ƥ�����
	public final static int LingBoWeiBu_Skill	= 14;	//�貨΢��
	public final static int HeiLongBo_Skill		= 15;	//������
	public final static int LongJuanFeng_Skill	= 16;	//�����
	public final static int GuanYongZhongWu_Skill	= 17;	//��������
	public final static int BiZhongJiuQing_Skill	= 18;	//���ؾ���
	public final static int ShenLaiYiJi_Skill		= 19;	//����һ��
	public final static int ZhuanSi_Skill		= 20;	//װ��
	public final static int JiaoXie_Skill		= 21;	//��е
	public final static int CanYing_Skill		= 22;	//��Ӱ
	public final static int KuangQuanShui_Skill	= 23;	//��Ȫˮ
	public final static int JiaoShui_Skill		= 24;	//��ˮ
	public final static int TianShiZhiYi_Skill	= 25;	//��ʹ֮��
	public final static int FoShanWuYingJiao_Skill	= 26;	//��ɽ��Ӱ��
	//public final static int  //6.��������
	//7.�ⲫ����
	//8.������
	
	
	
	///// ��������
	int SKILLTYPE_UNDEFINE	= 0;	//δ���弼������
	int SKILLTYPE_FOREVER 	= 1;	//������    (һ��Ϊ���������Եļ���)
	int SKILLTYPE_ACTIVE_MAIN = 2;	//�������� () 
	
	// �������� , �Ƿ�������� buff����(�����е�)
	abstract void CalcAttr(Player player);
	
	// ����˺�
	abstract int getDamage(Player player);
	
	// buff���� , dot
}
