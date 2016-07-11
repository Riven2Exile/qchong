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
 *   伤害测试
 *   
 *   空手, 武器, 技能 等等
 *    
 */

public class TestDamage {
	
	
	
	
	//
	public static void doTest(){
		// 攻击者
		Player attacker = new Player();
		
		// 防御者
		Player defender = new Player();
		
		// 设置测试玩家数值 , 通过各种 addData来加入多个数据
		TestEx test = new TestEx();
		test.addData("1ji", 4, 4, 4, 
				null, 
				new Pair[]{new Pair(WeaponKind.SHE_YING_GONG, 0)});
		
		
		
		
		test.start();
	}
	
	// 测试空手伤害
	public static void TestEmptyHandDamage(Attr atkAttr, Attr defAttr){
		
		double nMinRange = 1.5;		//空手伤害的范围
		double nMaxRange = 2.0;
		
		int nMinDamage = EmptyHandFormat(atkAttr, nMinRange);  //猜测公式
		int nMaxDamage = EmptyHandFormat(atkAttr, nMaxRange);
		System.out.println("空手伤害值:"+ nMinDamage + "-" + nMaxDamage );
	}
	
	////// 空手伤害公式
	public static int EmptyHandFormat(Attr atkAttr, double factor){
		int nDamage = (int)Math.floor(atkAttr.get_final_power() * factor);  //猜测公式;
		return nDamage;
	}
	
	// 测试武器伤害
	public static void TestWeaponDamage(Player attacker, Player defender){
		WeaponHelper wh = attacker.GetWeaponHelper();
		for( Entry<Integer, BaseWeapon> entry : wh.GetFuckData().entrySet()){
			BaseWeapon w = entry.getValue();
			if (w.getWeaponType() == WeaponType.WEAPON_MIDDLE){
				TestMiddleWeaponDamage(attacker,  defender,  w);
			}
		}
	}
	
	// 测试中型武器伤害
	public static void TestMiddleWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();	//最小伤害
		int nMax = weapon.getMaxDamage();	//最大伤害
		
		int nMinDamage = MiddleWeaponFormat(attacker, nMin); //猜测公式
		int nMaxDamage = MiddleWeaponFormat(attacker, nMax);
		System.out.println("武器"+weapon.getWeaponKind() + " 造成单方伤害" + nMinDamage + "~" + nMaxDamage);
	}
	
	//// 中型武器伤害公式
	public static int MiddleWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 1.75 + weaponBaseDamage);
		return nDamage;
	}
	
	
	
	
	
	///////////// 内部类
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
					p.GetSkillHelper().addSkill(SkillFactory.getInstance(skill[i].first, skill[i].second)); //默认0级技能
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
				
				TestEmptyHandDamage(p.getAttr(), null); //空手伤害
				TestWeaponDamage(p, null);		//武器伤害
			}
		}
		
		ArrayList<Player> _data = new ArrayList<>();
	}
}
