package game.fight;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import game.Attr;
import game.BaseWeight;
import game.CalcTool;
import game.Player;
import game.SkillHelper;
import game.WeaponHelper;
import game.define.WeaponKind;
import game.define.WeaponType;
import game.factory.SkillFactory;
import game.factory.WeaponFactory;
import game.gametest.TestDamage;
import game.skill.BaseSkill;
import game.skill.SkillInterface;
import game.weapon.BaseWeapon;
import game.weapon.WeaponInterface;

/*
 *  ս������
 */

public class FightFlow {

	public FightFlow() {
		// TODO Auto-generated constructor stub
	}

	public String fightWay2String(int way){
		if(FightWayInterface.AW_Undefine == way){
			return "δ����";
		}else if(FightWayInterface.AW_EmptyHand == way){
			return "���ֹ���";
		}else if(FightWayInterface.AW_Weapon == way){
			return "��������";
		}
		else if(FightWayInterface.AW_ActiveMainSkill == way){
			return "��������";
		}
		else{
			return "δ֪!?";
		}
	}
	
	
	/*
	 *  ��ʼս�������������Ѿ���ʼ����Player
	 */
	public int StartFight(Player p1, Player p2){
		
		FightCon attackerCon = new FightCon();
		
		attackerCon._nFightWay = FightWayInterface.AW_Weapon;
		p1.GetWeaponHelper().ForEach(attackerCon); 	//����Ȩ����
		attackerCon._nFightWay = FightWayInterface.AW_ActiveMainSkill;
		p1.GetSkillHelper().ForEach(attackerCon);	//��������Ȩ����
		
		FightCon moodCon = new FightCon();
		moodCon._nFightWay = FightWayInterface.AW_Weapon;
		p2.GetWeaponHelper().ForEach(attackerCon);
		moodCon._nFightWay = FightWayInterface.AW_ActiveMainSkill;
		p2.GetSkillHelper().ForEach(moodCon);
		
		// todo: ������Ȩ�����֮ǰ�����͡�
		
		// todo: ��Ҫ�Ĺ����ֶ�
		
		int nHuihe = 20;
		for (int i = 1; i <= nHuihe; ++i){
			// ȷ����ĳ�˵�����,
			execARound(p1, p2, attackerCon, i);
			
			if(p1.getAttr().get_final_hp() <= 0){
				out.println(p1.GetPlayerName() + "������!"); 
				break;
			}
			if(p2.getAttr().get_final_hp() <= 0){
				out.println(p2.GetPlayerName() + "������!"); 
				break;
			}
			
			execARound(p2, p1, moodCon, i);
			if(p1.getAttr().get_final_hp() <= 0){
				out.println(p1.GetPlayerName() + "������!"); 
				break;
			}
			if(p2.getAttr().get_final_hp() <= 0){
				out.println(p2.GetPlayerName() + "������!"); 
				break;
			}
			
			
			//
		}
		
		// ��������˴��� ���ֹ������������������Ǽ��ܣ�Ȼ���ٷֱ�������Ե�����.... (�������ȣ���Ҫȡ���Ͽ�������Ķ���ȥ��������û����������ô�������)
		
		// �˺�����
		
		return 0;
	}
	
	/**
	 * ����һ��
	 */
	public void attackOnce(Player atk, Player def, FightCon attackerCon, int i, int nFightWay, int id, BaseWeapon weapon, BaseSkill skill, 
			boolean bDoubleHit){
		String strOut;
		////// todo: ���м��� [���Գ�ȡ]
		int hit_rate = atk.getAttr()._attr_hit.getTotalFinalData();
		int dodge_rate = def.getAttr()._attr_dodge.getTotalFinalData();
		boolean bHit = true; //�Ƿ�����, ��������Ҫ���ǡ����С�Ч��������������
		if (dodge_rate > hit_rate){
			bHit = !CalcTool.probabilityInt(dodge_rate - hit_rate);
		}
		
		
		
		////// �˺�����
		int nSelfDamage = 0;
		
		if (bHit) {

			int nWeaponType = WeaponType.WEAPON_UNDEFINE; // ��������
			if (FightWayInterface.AW_Weapon == nFightWay) {
				nSelfDamage = TestDamage.genWeaponDamage(atk, weapon); // ��������������Ļ����˺�
			} else if (FightWayInterface.AW_EmptyHand == nFightWay) {
				nSelfDamage = TestDamage.genEmptyHandDamage(atk.getAttr()); // ����˵Ļ����˺�
			} else if (FightWayInterface.AW_ActiveMainSkill == nFightWay) {
				if (skill != null) {
					nSelfDamage = skill.getDamage(atk, def); // ���㼼�ܻ����˺�
				}
			}

			///////////// �������� �Լ��˺����� (���Գ�ȡ����)
			nSelfDamage = execAddAndSubDamage(atk.getAttr(), def.getAttr(), nSelfDamage, nFightWay, nWeaponType);

			// todo: �������ط��ı�������, ����Ƿ��˼��ܣ� ����Ҫ����һ�� attackOnce����
			// todo: ---->��������

			// Ѫ���仯
			def.getAttr().add_final_hp(-nSelfDamage);

			// todo: �ж�����, ������������, ��˳��ģ�һ������װ������
			if (def.getAttr().get_final_hp() <= 0) {
				// todo
				BaseSkill sk = def.GetSkillHelper().getSkill(SkillInterface.ZhuangSi_Skill);
				if (sk != null && sk.getUseCount() < 1) {
					sk.takeEffect(def, null);
					sk.addUseCount(1);
					bDoubleHit = false; // [ȡ����������]
					out.println(def.GetPlayerName() + "������װ������!");// print
				}
			}

			// todo: ----> ����, ���ߴ�����
		}
		
		///// �˺����� end
		if(bHit)
		{
			strOut = "��" + i + "�غ�, [" + atk.GetPlayerName() + "]ʹ�ó�" + fightWay2String(nFightWay) + " " + id + ", ���"
					+ nSelfDamage + "�������˺�, [" + def.GetPlayerName() + "]ʣ��Ѫ��" + def.getAttr().get_final_hp() + "/"
					+ def.getAttr().get_max_hp();
		}
		else{
			strOut = "��" + i + "�غ�, [" + atk.GetPlayerName() + "]ʹ�ó�" + fightWay2String(nFightWay) + " " + id + ", "
					+ def.GetPlayerName() + "�����ܡ��ˣ���";
		}
		out.println(strOut);
		
		
		
		if (bDoubleHit) { ///// ִ�й���������
			out.println(atk.GetPlayerName() + "��������!");
			attackOnce(atk, def, attackerCon, i, nFightWay, id, weapon, skill, false);
		}
	}
	
	
	/**
	 *  ������һ���غ�
	 */
	public void execARound(Player attacker, Player defender, FightCon attackerCon, int i){
		/*******/ ///�����Ҫһ�����Ե����¼���
		attacker.getAttr().set_doubleHit(0); //����������
		
		attacker.GetFightBuffHelper().onARoundStart();
		if (attacker.isDie()) {
			out.println(attacker.GetPlayerName() + "�����ˣ�");
			return ;
		}
		
		/* ������� */
		int nFightWay = 0 ;
		int id = 0 ;
		nFightWay = attackerCon.getRandomFightWay();
		id = attackerCon.getRandomID(nFightWay);
		
		/* �����������߼��ܵ�Ч�� */
		BaseWeapon weapon = null;
		BaseSkill skill = null;
		if (FightWayInterface.AW_Weapon == nFightWay){
			weapon = attacker.GetWeaponHelper().getWeapon(id);
			if(weapon != null){
				// todo: �������Ͷ������ ���Ҳ��ǽ��ֳ�����Ͷ����ȥ��,�����¼Ϊ��ǰ����
				if (weapon.getWeaponType() != WeaponType.WEAPON_THROW) {
					attackerCon._curWeaponInHand = weapon;
				}
				
				weapon.HandleEffect(attacker, defender); //��������Ч��
			}
		}
		else if(FightWayInterface.AW_EmptyHand == nFightWay){
			attackerCon.removeCurrentWeapon();// �ȶ�����ǰ������
		}
		else if(FightWayInterface.AW_ActiveMainSkill == nFightWay){
			skill = attacker.GetSkillHelper().getSkill(id);
			if(skill != null){
				skill.takeEffect(attacker, defender); 				//��������Ч��
			}
		}
		
		boolean bDoubleHit = CalcTool.probabilityInt(attacker.getAttr().get_doubleHit());// �Ƿ�����
		
		attackOnce(attacker, defender, attackerCon, i, nFightWay, id, weapon, skill, bDoubleHit);	// ������һ�Ρ�
		
		// ��������ļ���, ������1������ʹ�ô���+1
		if (FightWayInterface.AW_Weapon == nFightWay) {
			attackerCon.remove(nFightWay, id);
		} else if (FightWayInterface.AW_ActiveMainSkill == nFightWay) {
			///// ��Щ����һ��ս������ʹ�ô������Ƶ�
			if (id == BaseSkill.QiENaoYang_Skill) {
				attackerCon.remove(nFightWay, id);
			}
		}
		
		attacker.GetFightBuffHelper().onARoundEnd();
		attacker.getAttr().set_doubleHit(0);//����������
	}
	
	/**
	 *  ִ�����˺ͼ���
	 */
	public int execAddAndSubDamage(Attr atk, Attr def, int nSelfDamage, int nFightWay, int nWeaponType){
		// ---->>>>>>>  ��ֵ������
		int nAddDamageChangeNum = calcAddDamageNumber(atk, nFightWay, nWeaponType);
		if (nAddDamageChangeNum > 0) {
			nSelfDamage += nAddDamageChangeNum;
		}
		// ---->>>>>>> �ٷֱ�����
		int nAddDamageChangePer = calcAddDamagePer(atk, nFightWay, nWeaponType);
		if (nAddDamageChangePer > 0) {
			nSelfDamage = (int) Math.floor(nSelfDamage * ((100 + nAddDamageChangePer) / (double) 100));
		}

		// ---->>>>>>> ��ֵ�ͼ���
		int nSubDamageChangeNum = calcSubDamageNumber(def, nFightWay, nWeaponType);
		if (nSubDamageChangeNum > 0) {
			nSelfDamage -= nSubDamageChangeNum;
			if (nSelfDamage < 0) {
				nSelfDamage = 0;
			}
		}
		// ---->>>>>>> �ٷֱȼ���
		int nSubDamageChangePer = calcSubDamagePer(def, nFightWay, nWeaponType); // ����Ӧ�����ֻ�ܼ�
																							// 100%��
		if (nSelfDamage > 0 && nSubDamageChangePer > 0) {
			nSelfDamage = nSelfDamage - (int) Math.floor(nSelfDamage * ((100 - nSubDamageChangePer) / (double) 100)); //
			if (nSelfDamage < 0) {
				nSelfDamage = 0;
			}
		}
		return nSelfDamage;
	}
	
	/**
	 *  ������ֵ������
	 * @return
	 */
	public int calcAddDamageNumber(Attr atk, int fightway, int weaponType){
		int n = 0;
		if (FightWayInterface.AW_EmptyHand == fightway){
			n = atk.get_addEmptyHandDamage();
		}
		else if(FightWayInterface.AW_Weapon == fightway){
			if(WeaponType.WEAPON_LARGE == weaponType){
				n = atk.get_addLargeWeaponDamage();
			}else if(WeaponType.WEAPON_MIDDLE == weaponType){
				n = atk.get_addMidWeaponDamage();
			}else if(WeaponType.WEAPON_TINY == weaponType){
				n = atk.get_addTinyWeaponDamage();
			}else if(WeaponType.WEAPON_THROW == weaponType){
				n = atk.get_addThrowWeaponDamage();
			}
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			n = atk.get_addSkillDamage();
		}
		
		return n;
	}
	
	/**
	 *  ����ٷֱ�����
	 */
	public int calcAddDamagePer(Attr atk, int fightway, int weaponType){
		int n = 0;
		if (FightWayInterface.AW_EmptyHand == fightway){
			n = atk.get_addEmptyHandDamagePer();
		}
		else if(FightWayInterface.AW_Weapon == fightway){
			if(WeaponType.WEAPON_LARGE == weaponType){
				n = atk.get_addLargeWeaponDamagePer();
			}else if(WeaponType.WEAPON_MIDDLE == weaponType){
				n = atk.get_addMidWeaponDamagePer();
			}else if(WeaponType.WEAPON_TINY == weaponType){
				n = atk.get_addTinyWeaponDamagePer();
			}else if(WeaponType.WEAPON_THROW == weaponType){
				n = atk.get_addThrowWeaponDamagePer();
			}
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			n = atk.get_addSkillDamagePer();
		}
		
		return n;
	}
	
	/**
	 *  ������ֵ�ͼ���
	 */
	public int calcSubDamageNumber(Attr def, int fightway, int weaponType){
		int n = 0;
		if (FightWayInterface.AW_EmptyHand == fightway){
			n = def.get_subEmptyHandDamage();
		}
		else if(FightWayInterface.AW_Weapon == fightway){
			if(WeaponType.WEAPON_LARGE == weaponType){
				n = def.get_subLargeWeaponDamage();
			}else if(WeaponType.WEAPON_MIDDLE == weaponType){
				n = def.get_subMidWeaponDamage();
			}else if(WeaponType.WEAPON_TINY == weaponType){
				n = def.get_subTinyWeaponDamage();
			}else if(WeaponType.WEAPON_THROW == weaponType){
				n = def.get_subThrowWeaponDamage();
			}
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			n = def.get_subSkillDamage();
		}
		
		return n;
	}
	
	/**
	 * ����ٷֱȼ���
	 */
	public int calcSubDamagePer(Attr def, int fightway, int weaponType){
		int n = 0;
		if (FightWayInterface.AW_EmptyHand == fightway){
			n = def.get_subEmptyHandDamagePer();
		}
		else if(FightWayInterface.AW_Weapon == fightway){
			if(WeaponType.WEAPON_LARGE == weaponType){
				n = def.get_subLargeWeaponDamagePer();
			}else if(WeaponType.WEAPON_MIDDLE == weaponType){
				n = def.get_subMidWeaponDamagePer();
			}else if(WeaponType.WEAPON_TINY == weaponType){
				n = def.get_subTinyWeaponDamagePer();
			}else if(WeaponType.WEAPON_THROW == weaponType){
				n = def.get_subThrowWeaponDamagePer();
			}
		}
		else if(FightWayInterface.AW_ActiveMainSkill == fightway){
			n = def.get_subSkillDamagePer();
		}
		return n;
	}
	
	/**
	 * test ����
	 */
	public void test(){
		Player p1 = new Player();
		p1.SetName("������1");
		p1.getAttr().set_base_three(13, 5, 6);
		p1.getAttr().set_base_hp(200);
		// todo, ������ܻ�ӻ������Ե�buff
		p1.getAttr().CalcBaseThree();
		
		Player wood = new Player();	//ľ׮
		wood.SetName("ľ׮");
		wood.getAttr().set_base_hp(500);
		wood.getAttr().CalcFinalThree();
		wood.GetSkillHelper().addSkill(SkillFactory.getInstance(SkillInterface.ZhuangSi_Skill, 0));	//װ��
		wood.GetSkillHelper().addSkill(SkillFactory.getInstance(SkillInterface.LingBoWeiBu_Skill, 0)); //�貨΢��
		
		wood.GetSkillHelper().reCaclForeverAttr(wood);
		wood.getAttr().CalcAddictionThree();
		wood.getAttr().CalcFinalThree();
		
		
		WeaponHelper wh =  p1.GetWeaponHelper();
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.SHE_YING_GONG, 0)); //����Ӱ��
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.KUANG_MO_LIAN, 0)); //�ӿ�ħ��
		wh.addWeapon(WeaponFactory.getInstance(WeaponKind.DUAN_JIAN, 0));	//�̽�
		
		SkillHelper sh = p1.GetSkillHelper();
		sh.addSkill(SkillFactory.getInstance(SkillInterface.SPEED_SKILL, 0));
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.FoShanWuYingJiao_Skill, 0)); 	//��ɽ��Ӱ��
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.LongJuanFeng_Skill, 0));		//�����
		sh.addSkill(SkillFactory.getInstance(SkillInterface.HAND_GOOD_SKILL, 0));	//�ⲫ����
		sh.addSkill(SkillFactory.getInstance(SkillInterface.WEAPON_GOOD_SKILL, 0));	//��������
		sh.addSkill(SkillFactory.getInstance(SkillInterface.QiENaoYang_Skill, 0));	//�������
		//sh.addSkill(SkillFactory.getInstance(SkillInterface.HP_SKILL, 0));
		
		/// ����ļ��������Գ�ȡ�ɺ���
		p1.GetSkillHelper().reCaclForeverAttr(p1); //���� �����ͼ��ܶ����Եļӳ�
		p1.getAttr().CalcAddictionThree();
		p1.getAttr().CalcFinalThree();
		
		
		
		StartFight(p1, wood);
	}
	
}



class FightWight extends BaseWeight{
	private int _id = 0;	//�����Ǽ���id, ����id
	
	public FightWight(int nWeight) {
		super(nWeight);
		// TODO Auto-generated constructor stub
	}
	
	public FightWight(int nWeight, int id){
		super(nWeight);
		_id = id;
	}
	
	public int getID(){
		return _id;
	}
}







