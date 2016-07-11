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
		test.addData("1ji", 4, 4, 4, 
				null, 
				new Pair[]{new Pair(WeaponKind.SHE_YING_GONG, 0)});
		
		
		
		
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
		}
	}
	
	// �������������˺�
	public static void TestMiddleWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();	//��С�˺�
		int nMax = weapon.getMaxDamage();	//����˺�
		
		int nMinDamage = MiddleWeaponFormat(attacker, nMin); //�²⹫ʽ
		int nMaxDamage = MiddleWeaponFormat(attacker, nMax);
		System.out.println("����"+weapon.getWeaponKind() + " ��ɵ����˺�" + nMinDamage + "~" + nMaxDamage);
	}
	
	//// ���������˺���ʽ
	public static int MiddleWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 1.75 + weaponBaseDamage);
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
				
				System.out.println(p.GetPlayerName());
				p.getAttr().tell();
				
				TestEmptyHandDamage(p.getAttr(), null); //�����˺�
				TestWeaponDamage(p, null);		//�����˺�
			}
		}
		
		ArrayList<Player> _data = new ArrayList<>();
	}
}
