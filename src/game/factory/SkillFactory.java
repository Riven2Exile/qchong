package game.factory;

import game.skill.AttackDoubleSkill;
import game.skill.BaQiHuTiSkill;
import game.skill.BalanceSkill;
import game.skill.BaseSkill;
import game.skill.CanYingSkill;
import game.skill.FoShanWuYingJiaoSkill;
import game.skill.HandGoodSkill;
import game.skill.HpSkill;
import game.skill.LingBoWeiBuSkill;
import game.skill.LongJuanFengSkill;
import game.skill.LossLoveSkill;
import game.skill.MinJieSkill;
import game.skill.PowerSkill;
import game.skill.QiENaoYangSkill;
import game.skill.RehitSkill;
import game.skill.SpeedSkill;
import game.skill.WeaponGoodSkill;
import game.skill.ZhuangSiSkill;

public class SkillFactory {
	public static BaseSkill getInstance(int id, int lv){
		switch(id){
		case BaseSkill.POWER_SKILL: return new PowerSkill(lv);		//��������
		case BaseSkill.MINJIE_SKILL: return new MinJieSkill(lv);	//��������
		case BaseSkill.SPEED_SKILL: return new SpeedSkill(lv);		//����һ��
		case BaseSkill.HP_SKILL: return new HpSkill(lv);			//ǿ������
		case BaseSkill.BALANCE_ATTR_SKILL: return new BalanceSkill(lv);	//���ⷢչ
		case BaseSkill.WEAPON_GOOD_SKILL: return new WeaponGoodSkill(lv);	//��������
		case BaseSkill.HAND_GOOD_SKILL: return new HandGoodSkill(lv);	//�ⲫ����
		case BaseSkill.REHIT_SKILL: return new RehitSkill(lv);		//��������
		case BaseSkill.LOSS_LOVE_SKILL: return new LossLoveSkill(lv);	//��������
		case BaseSkill.ATTACK_DOUBLE_SKILL: return new AttackDoubleSkill(lv);	//�ɷ�����
		case BaseSkill.BaQiHuTi_SKILL: return new BaQiHuTiSkill(lv); //��todo:����������
		case BaseSkill.DaHaiWuLiang_SKILL: return null; //��todo:��������
		case BaseSkill.PiCaoRouHou_Skill: return null; //��todo:��Ƥ�����
		case BaseSkill.LingBoWeiBu_Skill: return new LingBoWeiBuSkill(lv);	//�貨΢��
		case BaseSkill.HeiLongBo_Skill: return null;//��todo:��������
		case BaseSkill.LongJuanFeng_Skill : return new LongJuanFengSkill(lv);	//�����
		case BaseSkill.GuanYongZhongWu_Skill: return null; //��todo:����������
		case BaseSkill.BiZhongJiuQing_Skill: return null; //��todo:�����ؾ���
		case BaseSkill.ShenLaiYiJi_Skill: return null; //��todo:������һ��
		case BaseSkill.ZhuangSi_Skill: return new ZhuangSiSkill(lv);	//װ��
		case BaseSkill.JiaoXie_Skill: return null; //��todo:����е
		case BaseSkill.CanYing_Skill: return new CanYingSkill(lv);	//��Ӱ
		case BaseSkill.KuangQuanShui_Skill: return null; //��todo:��Ȫˮ��
		case BaseSkill.JiaoShui_Skill: return null; //��todo:��ˮ��
		case BaseSkill.TianShiZhiYi_Skill: return null; //��todo:��ʹ֮��
		case BaseSkill.FoShanWuYingJiao_Skill: return new FoShanWuYingJiaoSkill(lv);	//��ɽ��Ӱ��
		case BaseSkill.ShiRuBaoYu_Skill: return null; //��todo:���籩�꡿
		case BaseSkill.QiEHou_Skill: return null; //��todo: ����
		case BaseSkill.QiENaoYang_Skill : return new QiENaoYangSkill(lv);	//�������
		
		case BaseSkill.RuLaiShenZhang_Skill: return null; //��todo:�������ơ�
		case BaseSkill.ShiXue_Skill: return null; //��todo:��Ѫ��
		case BaseSkill.YiJinJing_Skill: return null; //��todo:�׽��
		case BaseSkill.AnRanYiJi_Skill: return null; //��todo:��Ȼһ����
		case BaseSkill.ChongFeng_Skill: return null; //��todo:��桿
		default: return null;
		}
	}
}
