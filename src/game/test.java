package game;

public class test {
	
	// ���û�����Χ
	void setBaseThree(Player p, int pow, int minjie, int speed){
		p.getAttr().set_base_power(pow);
		p.getAttr().set_base_minjie(minjie);
		p.getAttr().set_base_speed(speed);
	}

	
	
	void test1(){
		Player p = new Player();
		setBaseThree(p, 5, 5, 5);
		//todo:���Ӽ���  --> push_back
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		
	}

}
