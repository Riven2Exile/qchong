package game.skill;

import buff.BaseFightBuff;
import game.Player;
import game.factory.FightBuffFactory;

/**
 * ���ܣ��������
 */

public class QiENaoYangSkill extends BaseSkill {

	public QiENaoYangSkill(int lv) {
		super(lv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSkillID() {
		// TODO Auto-generated method stub
		return QiENaoYang_Skill;
	}

	@Override
	public int getSkillType() {
		// TODO Auto-generated method stub
		return SKILLTYPE_ACTIVE_MAIN;
	}

	@Override
	public void takeEffect(Player attacker, Player defender){
		int lv = getSkillLv();
		BaseFightBuff buff = FightBuffFactory.getInstance(BaseFightBuff.Buff_QErNaoYang);
		buff.set_leftRound(6);//6���غ�
		switch (lv) {
		case 0:
			// todo: �������߼�һ����Ѫ��buff
			buff.setData((int)Math.floor(5 + attacker.getAttr().get_final_minjie() * 0.2));
			defender.GetFightBuffHelper().addBuff(buff);
			break;

		default:
			break;
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "�������";
	}
}
