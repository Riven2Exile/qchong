package game.factory;

import game.skill.AttackDoubleSkill;
import game.skill.BalanceSkill;
import game.skill.BaseSkill;
import game.skill.FoShanWuYingJiaoSkill;
import game.skill.HandGoodSkill;
import game.skill.HpSkill;
import game.skill.LongJuanFengSkill;
import game.skill.LossLoveSkill;
import game.skill.MinJieSkill;
import game.skill.PowerSkill;
import game.skill.RehitSkill;
import game.skill.SpeedSkill;
import game.skill.WeaponGoodSkill;

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
		
		
		
		case BaseSkill.LongJuanFeng_Skill : return new LongJuanFengSkill(lv);	//�����
		
		case BaseSkill.FoShanWuYingJiao_Skill: return new FoShanWuYingJiaoSkill(lv);	//��ɽ��Ӱ��
		default: return null;
		}
	}
}
