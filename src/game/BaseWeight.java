package game;

/*
 *  基础权重类, 可以被继承
 */

public class BaseWeight {
	
	public BaseWeight(int n) {
		// TODO Auto-generated constructor stub
		nWeight = n;
	}
	
	protected int nWeight = 0;
	
	public int getWeight(){
		return nWeight;
	}
}
