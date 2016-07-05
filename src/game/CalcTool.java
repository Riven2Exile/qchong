package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 *  计算工具
 */

public class CalcTool {
	
	// [min , max )
	public static double random(double min, double max){
		return min + Math.random() * (max/(max-min));
	}
	
	// [min, max] 测试通过
	public static int random(int min, int max) {
		double r = Math.random();
		double b = r * (max-min + 1);
		//System.out.println("r:"+r+" b:"+b + " (int)b:"+(int)b);
		return min + (int)b;
	}
	
	
	
	public static void test() {
		System.out.println("CalcTool 测试开始");
		int nCount = 5000000;
		int nMin = 1;
		int nMax = 5;
		HashMap<Integer,Integer> mapData = new HashMap<Integer,Integer>(); //不能写成 HashMap<int,int>, 因为基本类型不能做为泛化参数
		for (int i = nMin; i <= nMax; ++i){
			mapData.put(i, 0);
		}
		
		for (int i = 0; i < nCount; ++i){
			Integer nKey = random(nMin, nMax);
			mapData.put(nKey, mapData.get(nKey).intValue() + 1) ;
		}
		
		String strOut = "共执行了"+nCount+"次,\n";
		for(Entry<Integer, Integer> entry : mapData.entrySet()){
			int nVal = entry.getValue();
			strOut = strOut + entry.getKey() + ":" + nVal + "次," + nVal/(double)nCount * 100 + "%\n";
		}
		
		System.out.println(strOut);
	}
}
