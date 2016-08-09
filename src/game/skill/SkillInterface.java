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
	public final static int ZhuangSi_Skill		= 20;	//װ��
	public final static int JiaoXie_Skill		= 21;	//��е
	public final static int CanYing_Skill		= 22;	//��Ӱ
	public final static int KuangQuanShui_Skill	= 23;	//��Ȫˮ
	public final static int JiaoShui_Skill		= 24;	//��ˮ
	public final static int TianShiZhiYi_Skill	= 25;	//��ʹ֮��
	public final static int FoShanWuYingJiao_Skill	= 26;	//��ɽ��Ӱ��
	public final static int ShiRuBaoYu_Skill	= 27;	//���籩��
	public final static int QiEHou_Skill		= 28;	//����
	public final static int QiENaoYang_Skill	= 29;	//�������
	public final static int ShiFuJiaDao_Skill	= 30;	//ʦ���ݵ�
	public final static int RuLaiShenZhang_Skill= 31;	//��������
	public final static int ShiXue_Skill		= 32;	//��Ѫ
	public final static int YiJinJing_Skill 	= 33;	//�׽
	public final static int AnRanYiJi_Skill		= 34;	//��Ȼһ��
	public final static int ChongFeng_Skill		= 35;	//���
	public final static int DouDouQuan_Skill	= 36;	//����ȭ
	public final static int JiFengBu_Skill		= 37;	//���粽
	public final static int XiuXinShu_Skill		= 38;	//������
	public final static int MingYueDao_Skill	= 39;	//���µ�
	public final static int XueJiShu_Skill		= 40;	//Ѫ����
	public final static int RenPinBaoFa_Skill	= 41;	//��Ʒ����
	public final static int QiGong_Skill		= 42;	//����
	public final static int ChongJiBo_Skill		= 43;	//�����
	public final static int CiKeZhiShu_Skill	= 44;	//�̿�֮��
	public final static int MengJiangZhiLi_Skill= 45;	//�ͽ�֮��
	public final static int DianXue_Skill		= 46;	//��Ѩ
	public final static int JianKeZhiLing_Skill	= 47;	//����֮��
	public final static int ShenZhiZhuFu_Skill	= 48;	//��֮ף��
	public final static int TaiJiQuanFa_Skill	= 49;	//̫��ȭ��
	public final static int QiLiaoShu_Skill		= 50;	//������
	public final static int TianCanJiao_Skill	= 51;	//��н�
	public final static int GuiYingCanShen_Skill= 52;	//��Ӱ����
	public final static int BiXieJianPu_Skill	= 53;	//��а����
	
	
	
	///// ��������
	int SKILLTYPE_UNDEFINE	= 0;	//δ���弼������
	int SKILLTYPE_FOREVER 	= 1;	//������    (һ��Ϊ���������Եļ���)
	int SKILLTYPE_ACTIVE_MAIN = 2;	//�������� () 
	int SKILLTYPE_ACTIVE_TRIGGER = 3; 	//���������� (�繥������, ��Ӱ)
	int SKILLTYPE_ATTACKED_TRIGGER = 4;	//����������(�練�� )
	int SKILLTYPE_DYING_TRIGGER = 5;	//����������(��װ��)
	
	// �������� , �Ƿ�������� buff����(�����е�)
	abstract void takeEffect(Player attacker, Player defender);
	
	// ����˺�
	abstract int getDamage(Player attacker, Player defender);
	
	// buff���� , dot
}
