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
		// 【测试数据】 ：判官笔(19,23)  铁铲(21,28) 空手(8,10), 如意金箍棒(18,93)
		// 对方 力量6,环扣刀22
		test.addData("1ji", 5, 5, 7, 
				null, 
				new Pair[]{new Pair(WeaponKind.PAN_GUAN_BI, 0), new Pair(WeaponKind.TIE_CHAN,0), new Pair(WeaponKind.RU_YI_JIN_GU_BANG, 0)});
		
		//q宠3 5级【测试数据】: 开山斧(21,25)  短剑(12)  接力棒(17,22) 空手(7)
		test.addData("宠3_5级", 3, 5, 7, null, 
				new Pair[]{new Pair(WeaponKind.KAI_SHAN_FU, 0),new Pair(WeaponKind.JIE_LI_BANG, 0),new Pair(WeaponKind.DUAN_JIAN, 0)});
		
		//q宠3 6级【测试数据】: 开山斧(21,23)  短剑(14)  接力棒(22,23)  充气锤子(39)  空手()
		test.addData("宠3_6级", 4, 5, 7, null, 
				new Pair[]{new Pair(WeaponKind.KAI_SHAN_FU, 0),new Pair(WeaponKind.JIE_LI_BANG, 0),new Pair(WeaponKind.DUAN_JIAN, 0),
						new Pair(WeaponKind.CHONG_QI_CHUI_ZI, 0)});
		
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
	
	////////// 【测试中型武器伤害】
	public static void TestMiddleWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();	//最小伤害
		int nMax = weapon.getMaxDamage();	//最大伤害
		
		int nMinDamage = MiddleWeaponFormat(attacker, nMin); //猜测公式
		int nMaxDamage = MiddleWeaponFormat(attacker, nMax);
		System.out.println("中型武器"+weapon.getWeaponKind() + " 造成单方伤害" + nMinDamage + "~" + nMaxDamage);
	}
	//// 中型武器伤害公式
	public static int MiddleWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 1.99 + weaponBaseDamage);
		return nDamage;
	}
	
	////////// 【测试大型武器伤害】
	public static void TestLargeWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();
		int nMax = weapon.getMaxDamage();
		
		int nMinDamage = LargeWeaponFormat(attacker, nMin);
		int nMaxDamage = LargeWeaponFormat(attacker, nMax);
		System.out.println("大型武器"+weapon.getWeaponKind() + " 造成单方伤害" + nMinDamage + "~" + nMaxDamage);
		
	}
	///// 大型武器公式猜测
	public static int LargeWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 2.2+ weaponBaseDamage);
		return nDamage;
	}
	
	//////////// 【测试小型武器伤害】
	public static void TestTinyWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();
		int nMax = weapon.getMaxDamage();
		
		int nMinDamage = TinyWeaponFormat(attacker, nMin);
		int nMaxDamage = TinyWeaponFormat(attacker, nMax);
		System.out.println("小型武器"+weapon.getWeaponKind() + " 造成单方伤害" + nMinDamage + "~" + nMaxDamage);
	}
	///// 小型武器伤害公式猜测
	public static int TinyWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 1.5 + weaponBaseDamage);
		return nDamage;
	}
	
	///////////// 【测试投掷武器伤害】
	public static void TestThrowWeaponDamage(Player attacker, Player defender, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();
		int nMax = weapon.getMaxDamage();
		
		int nMinDamage = ThrowWeaponFormat(attacker, nMin);
		int nMaxDamage = ThrowWeaponFormat(attacker, nMax);
		System.out.println("投掷武器"+weapon.getWeaponKind() + " 造成单方伤害" + nMinDamage + "~" + nMaxDamage); 
	}
	////// 投掷武器伤害公式猜测
	public static int ThrowWeaponFormat(Player attacker, int weaponBaseDamage){
		int nDamage = (int)Math.floor(attacker.getAttr().get_final_power() * 1.5 + weaponBaseDamage);
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
				
				System.out.println("\n" + p.GetPlayerName());
				p.getAttr().tell();
				
				TestEmptyHandDamage(p.getAttr(), null); //空手伤害
				TestWeaponDamage(p, null);		//武器伤害
			}
		}
		
		ArrayList<Player> _data = new ArrayList<>();
	}
}
