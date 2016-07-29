package game;
import java.lang.System;

import game.define.WeaponKind;
import game.factory.SkillFactory;
import game.factory.WeaponFactory;
import game.gametest.TestDamage;
import game.skill.SkillInterface;
import game.weapon.BaseWeapon;

public class test {
	
	// 设置基础三围
	static void setBaseThree(Player p, int pow, int minjie, int speed){
		p.getAttr().set_base_power(pow);
		p.getAttr().set_base_minjie(minjie);
		p.getAttr().set_base_speed(speed);
	}

	
	
	static public void test1(){
		Player p = new Player();
		setBaseThree(p, 5, 5, 7);
		p.getAttr().CalcFinalThree();
		//todo:增加技能  --> push_back
		p.GetSkillHelper().addSkill(SkillFactory.getInstance(SkillInterface.SPEED_SKILL, 0));
		//计算技能加成
		p.GetSkillHelper().ReCaclForeverAttr(p);
		p.getAttr().CalcFinalThree();
		BaseWeapon weapon = WeaponFactory.getInstance(WeaponKind.SHE_YING_GONG, 0);
		System.out.println("增加了武器:"+weapon.getWeaponKind());
		p.GetWeaponHelper().addWeapon(weapon);
		p.getAttr().tell();
	}
	
	void guessEmptyDamage(Player p){
		double nMinRange = 1.5;
		double nMaxRange = 2.0;
		int nMinDamage = (int)(p.getAttr().get_final_power() * nMinRange);  //猜测公式
		int nMaxDamage = (int)(p.getAttr().get_final_power() * nMaxRange);
		System.out.println("空手伤害值:"+ nMinDamage + "-" + nMaxDamage );
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		//test1();
		
//		Player a = new Player();
//		a.setLevel(10);
//		Player an = ClassCopy.Copy(a);
//		a.setLevel(12);
		
		
		TestDamage.doTest();  //【猜测伤害】
		
		//测试随机
		//CalcTool.test();
		
	}

}
