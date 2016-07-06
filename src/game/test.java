package game;
import java.lang.System;

import game.define.WeaponKind;
import game.factory.SkillFactory;
import game.factory.WeaponFactory;
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
		setBaseThree(p, 3, 4, 3);
		p.getAttr().CalFinalThree();
		//todo:增加技能  --> push_back
		p.GetSkillHelper().addSkill(SkillFactory.getInstance(SkillInterface.SPEED_SKILL, 0));
		//计算技能加成
		p.GetSkillHelper().ReCaclAttr(p);
		p.getAttr().CalFinalThree();
		BaseWeapon weapon = WeaponFactory.getInstance(WeaponKind.SHE_YING_GONG, 0);
		System.out.println("增加了武器:"+weapon.getWeaponKind());
		p.GetWeaponHelper().addWeapon(weapon);
		p.getAttr().tell();
	}
	
	void guessEmptyDamage(Player p){
		System.out.println("空手伤害:"+ (p.getAttr().get_final_power() * CalcTool.random(1.5, 2.0)) );
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		test1();
		
		//测试随机
		//CalcTool.test();
	}

}
