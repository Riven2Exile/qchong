package game.gametest;

import java.util.ArrayList;
import java.util.Map.Entry;

import game.Attr;
import game.CalcTool;
import game.Pair;
import game.Player;
import game.WeaponHelper;
import game.define.WeaponKind;
import game.define.WeaponType;
import game.factory.SkillFactory;
import game.factory.WeaponFactory;
import game.skill.BaseSkill;
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
		
		//q宠3 6级【测试数据】: 开山斧(21,25)  短剑(12,14)  接力棒(21,23)  充气锤子(31,39)  空手()
		test.addData("宠3_6级", 4, 5, 7, null, 
				new Pair[]{new Pair(WeaponKind.KAI_SHAN_FU, 0),new Pair(WeaponKind.JIE_LI_BANG, 0),new Pair(WeaponKind.DUAN_JIAN, 0),
						new Pair(WeaponKind.CHONG_QI_CHUI_ZI, 0)});
		
		// 环扣刀(2,17) （力量3，伤19）(4,19/20),(5,20),(6,21/22/23),(12,27)
		//q宠3 7级【测试数据】: 开山斧(19,25)  短剑(12,17)  接力棒(20,23)  充气锤子(27,43)  空手(7,9)
		test.addData("宠3_7级", 4, 6, 7, null, 
				new Pair[]{new Pair(WeaponKind.KAI_SHAN_FU, 0),new Pair(WeaponKind.JIE_LI_BANG, 0),new Pair(WeaponKind.DUAN_JIAN, 0),
						new Pair(WeaponKind.CHONG_QI_CHUI_ZI, 0)});
		
		//q宠3 8级【测试数据】: 开山斧(24,26)  短剑(13,14)  接力棒()  充气锤子(33,34)  空手(8,10)
		test.addData("宠3_7级", 5, 6, 7, new Pair[]{new Pair(BaseSkill.SPEED_SKILL, 0)}, 
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
	////// 获得空手伤害
	public static int genEmptyHandDamage(Attr atkAttr){
		double nMinRange = 1.5;		//空手伤害的范围
		double nMaxRange = 2.0;
		
		int nMinDamage = EmptyHandFormat(atkAttr, nMinRange);  //猜测公式
		int nMaxDamage = EmptyHandFormat(atkAttr, nMaxRange);
		return CalcTool.random(nMinDamage, nMaxDamage);
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
	//// 生成中型武器伤害
	public static int genMiddleWeaponDamage(Player attacker, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();	//最小伤害
		int nMax = weapon.getMaxDamage();	//最大伤害
		
		int nMinDamage = MiddleWeaponFormat(attacker, nMin); //猜测公式
		int nMaxDamage = MiddleWeaponFormat(attacker, nMax);
		return CalcTool.random(nMinDamage, nMaxDamage);
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
	//// 生成大型武器伤害
	public static int genLargeWeaponDamage(Player attacker, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();
		int nMax = weapon.getMaxDamage();
		
		int nMinDamage = LargeWeaponFormat(attacker, nMin);
		int nMaxDamage = LargeWeaponFormat(attacker, nMax);
		return CalcTool.random(nMinDamage, nMaxDamage);
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
	//// 生成小型武器伤害
	public static int genTinyWeaponDamage(Player attacker, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();
		int nMax = weapon.getMaxDamage();
		
		int nMinDamage = TinyWeaponFormat(attacker, nMin);
		int nMaxDamage = TinyWeaponFormat(attacker, nMax);
		return CalcTool.random(nMinDamage, nMaxDamage);
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
	//// 生成投掷武器伤害
	public static int genThrowWeaponDamage(Player attacker, BaseWeapon weapon){
		int nMin = weapon.getMinDamage();
		int nMax = weapon.getMaxDamage();
		
		int nMinDamage = ThrowWeaponFormat(attacker, nMin);
		int nMaxDamage = ThrowWeaponFormat(attacker, nMax);
		return CalcTool.random(nMinDamage, nMaxDamage);
	}
	
	
	////// 生成武器伤害
	public static int genWeaponDamage(Player attacker, BaseWeapon weapon){
		int type = weapon.getWeaponType();
		if(WeaponType.WEAPON_LARGE == type){
			return genLargeWeaponDamage(attacker, weapon);
		}else if (WeaponType.WEAPON_MIDDLE == type){
			return genMiddleWeaponDamage(attacker, weapon);
		}
		else if(WeaponType.WEAPON_TINY == type){
			return genTinyWeaponDamage(attacker, weapon);
		}
		else if(WeaponType.WEAPON_THROW == type){
			return genThrowWeaponDamage(attacker, weapon);
		}
		else
			return 0;
	}
	
	
	
	/////// 模拟战斗流程
	public static void SimulationFight(){
		/* 暂不考虑速度，命中，闪避
		 		1.需要复制一份自己的实例
		 		2.随机出攻击模式 a.空手 b.技能   c.武器(直接攻击，还是丢弃)
		 		3.如果是a和c, 则先计算自己即将产生的伤害，  再计算对方的减免
		 		4.如果是b单独的加血技能，    如果是攻击技能
		
		*/
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
			
			//// 计算永久型技能带来的加成
			p.GetSkillHelper().reCaclForeverAttr(p);
			p.getAttr().CalcFinalThree(); //计算总属性
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
