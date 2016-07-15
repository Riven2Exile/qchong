package game.gametest;

import java.util.ArrayList;
import java.util.Map.Entry;

import game.Attr;
import game.Pair;
import game.Player;
import game.WeaponHelper;
import game.define.WeaponKind;
import game.define.WeaponType;
import game.factory.SkillFactory;
import game.factory.WeaponFactory;
import game.weapon.BaseWeapon;

/*
 *   �˺�����
 *   
 *   ����, ����, ���� �ȵ�
 *    
 */

public class TestDamage {
	
	
	
	
	//
	public static void doTest(){
		// ������
		Player attacker = new Player();
		
		// ������
		Player defender = new Player();
		
		// ���ò��������ֵ , ͨ������ addData������������
		TestEx test = new TestEx();
		// ���������ݡ� ���йٱ�(19,23)  ����(21,28) ����(8,10), ����𹿰�(18,93)
		// �Է� ����6,���۵�22
		test.addData("1ji", 5, 5, 7, 
				null, 
				new Pair[]{new Pair(WeaponKind.PAN_GUAN_BI, 0), new Pair(WeaponKind.TIE_CHAN,0), new Pair(WeaponKind.RU_YI_JIN_GU_BANG, 0)});
		
		//q��3 5�����������ݡ�: ��ɽ��(21,25)  �̽�(12)  ������(17,22) ����(7)
		test.addData("��3_5��", 3, 5, 7, null, 
				new Pair[]{new Pair(WeaponKind.KAI_SHAN_FU, 0),new Pair(WeaponKind.JIE_LI_BANG, 0),new Pair(WeaponKind.DUAN_JIAN, 0)});
		
		//q��3 6�����������ݡ�: ��ɽ��(21,23)  �̽�(14)  ������(22,23)  ��������(39)  ����()
		test.addData("��3_6��", 4, 5, 7, null, 
				new Pair[]{new Pair(WeaponKind.KAI_SHAN_FU, 0),new Pair(WeaponKind.JIE_LI_BANG, 0),new Pair(WeaponKind.DUAN_JIAN, 0),
						new Pair(WeaponKind.CHONG_QI_CHUI_ZI, 0)});
		
		test.start();
	}
	
	// ���Կ����˺�
	public static void TestEmptyHandDamage(Attr atkAttr, Attr defAttr){
		
		double nMinRange = 1.5;		//�����˺��ķ�Χ
		double nMaxRange = 2.0;
		
		int nMinDamage = EmptyHandFormat(atkAttr, nMinRange);  //�²⹫ʽ
		int nMaxDamage = EmptyHandFormat(atkAttr, nMaxRange);
		System.out.println("�����˺�ֵ:"+ nMinDamage + "-" + nMaxDamage );
	}
	////// �����˺���ʽ
	public static int EmptyHandFormat(Attr atkAttr, double factor){
		int nDamage = (int)Math.floor(atkAttr.get_final_power() * factor);  //�²⹫ʽ;
		return nDamage;
	}
	
	// ���������˺�
	public static void TestWeaponDamage(Player attacker, Player defender){
		WeaponHelper wh = attacker.GetWeaponHelper();
		for( Entry<Integer, BaseWeapon> entry : wh.GetFuckData().entrySet()){
			BaseWeapon w = entry.getValue();
			if (w.getWeaponType() == WeaponType.WEAPON_MIDDLE){
				TestMiddleWeaponDamage(attacker,  defender,  w);
			}
			else if(w.getWeaponType() == WeaponType.WEAPON_LARGE){
				TestLargeWeaponDamage(attacker, defender, w);
			}
			else if(w.getWeaponType() == WeaponType.WEAPON_TINY){
				TestTinyWeaponDamage(attacker, defender, w);
			}
			else if(w.getWeaponType() == WeaponType.WEAPON_THROW){
				TestThrowWeaponDamage(attacker, defender, w);
			}
		}
	}
	
	////////// ���������������˺���
	public static void TestMiddleWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();	//��С�˺�
		int nMax = weapon.getMaxDamage();	//����˺�
		
		int nMinDamage = MiddleWeaponFormat(attacker, nMin); //�²⹫ʽ
		int nMaxDamage = MiddleWeaponFormat(attacker, nMax);
		System.out.println("��������"+weapon.getWeaponKind() + " ��ɵ����˺�" + nMinDamage + "~" + nMaxDamage);
	}
	//// ���������˺���ʽ
	public static int MiddleWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 1.99 + weaponBaseDamage);
		return nDamage;
	}
	
	////////// �����Դ��������˺���
	public static void TestLargeWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();
		int nMax = weapon.getMaxDamage();
		
		int nMinDamage = LargeWeaponFormat(attacker, nMin);
		int nMaxDamage = LargeWeaponFormat(attacker, nMax);
		System.out.println("��������"+weapon.getWeaponKind() + " ��ɵ����˺�" + nMinDamage + "~" + nMaxDamage);
		
	}
	///// ����������ʽ�²�
	public static int LargeWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 2.2+ weaponBaseDamage);
		return nDamage;
	}
	
	//////////// ������С�������˺���
	public static void TestTinyWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();
		int nMax = weapon.getMaxDamage();
		
		int nMinDamage = TinyWeaponFormat(attacker, nMin);
		int nMaxDamage = TinyWeaponFormat(attacker, nMax);
		System.out.println("С������"+weapon.getWeaponKind() + " ��ɵ����˺�" + nMinDamage + "~" + nMaxDamage);
	}
	///// С�������˺���ʽ�²�
	public static int TinyWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 1.5 + weaponBaseDamage);
		return nDamage;
	}
	
	///////////// ������Ͷ�������˺���
	public static void TestThrowWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();
		int nMax = weapon.getMaxDamage();
		
		int nMinDamage = ThrowWeaponFormat(attacker, nMin);
		int nMaxDamage = ThrowWeaponFormat(attacker, nMax);
		System.out.println("Ͷ������"+weapon.getWeaponKind() + " ��ɵ����˺�" + nMinDamage + "~" + nMaxDamage); 
	}
	////// Ͷ�������˺���ʽ�²�
	public static int ThrowWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 1.5 + weaponBaseDamage);
		return nDamage;
	}
	
	
	
	
	///////////// �ڲ���
	static class TestEx{
		public void addData(String name, int basePower, int baseMinjie, int baseSpeed, 
				Pair[] skill, Pair[] weapon)
		{
			Player p = new Player();
			p.SetName(name);
			p.getAttr().set_base_three(basePower, baseMinjie, baseSpeed);
			p.getAttr().CalcFinalThree();
			if(skill != null){
				for (int i = 0; i < skill.length; ++i){
					p.GetSkillHelper().addSkill(SkillFactory.getInstance(skill[i].first, skill[i].second)); //Ĭ��0������
				}
			}
			
			p.getAttr().CalcFinalThree();
			if( weapon != null){
				for (int i = 0; i < weapon.length; ++i) {
					p.GetWeaponHelper().addWeapon(WeaponFactory.getInstance(weapon[i].first, weapon[i].second));
				}
			}
			
			_data.add(p);
		}
		
		public void start(){
			for ( int i = 0; i < _data.size(); ++i ){
				Player p = _data.get(i);
				
				System.out.println("\n" + p.GetPlayerName());
				p.getAttr().tell();
				
				TestEmptyHandDamage(p.getAttr(), null); //�����˺�
				TestWeaponDamage(p, null);		//�����˺�
			}
		}
		
		ArrayList<Player> _data = new ArrayList<>();
	}
}
