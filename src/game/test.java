package game;
import java.lang.System;

import game.factory.SkillFactory;
import game.skill.SkillInterface;

public class test {
	
	// ���û�����Χ
	static void setBaseThree(Player p, int pow, int minjie, int speed){
		p.getAttr().set_base_power(pow);
		p.getAttr().set_base_minjie(minjie);
		p.getAttr().set_base_speed(speed);
	}

	
	
	static public void test1(){
		Player p = new Player();
		setBaseThree(p, 3, 4, 3);
		p.getAttr().CalFinalThree();
		//todo:���Ӽ���  --> push_back
		p.GetSkillHelper().addSkill(SkillFactory.getInstance(SkillInterface.SPEED_SKILL, 0));
		//���㼼�ܼӳ�
		p.GetSkillHelper().ReCaclAttr(p);
		p.getAttr().CalFinalThree();
		p.getAttr().tell();
	}
	
	void guessEmptyDamage(Player p){
		System.out.println("�����˺�:"+ (p.getAttr().get_final_power() * CalcTool.random(1.5, 2.0)) );
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		test1();
		
		//�������
		//CalcTool.test();
	}

}
