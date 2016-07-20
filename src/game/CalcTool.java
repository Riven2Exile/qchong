package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 *  计算工具
 */

public class CalcTool {
	
	// (min , max ) 测试通过      【注意： Math.random() 的范围是 (0,1), 而不是像文档中说的[0,1)】
	public static double random(double min, double max){
		return min + Math.random() * (max-min);
	}
	
	// [min, max] 测试通过
	public static int random(int min, int max) {
		double r = Math.random();
		double b = r * (max-min + 1);
		//System.out.println("r:"+r+" b:"+b + " (int)b:"+(int)b);
		return min + (int)b;
	}
	
	// 权重.... 用过传入一个预先定义的权重表，得到一个权重下标索引
	public static <E> int getWeightIndex(BaseWeight<E> weight){
		int nSize = weight.getSize();
		if (nSize <= 0){
			return 0;
		}
		else{
			return random(1, nSize);
		}
	}
	
	public static void test() {
		
		// 内部类
		class SecDouble{
			public double min;
			public double max;
			public int nCount = 0;
		}
		// 内部类end
		
		
		System.out.println("CalcTool 测试开始");
		// 1.  测试  random(int min, int max)
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
		
		// 2. 测试  random(double min, double max)
		double dMin = 1.9;
		double dMax = 2;
		int nSec = 5; //分区间统计会好一点
		int dCount = 5000000;
		double per = (dMax - dMin) / nSec; //一个分区的跨度
		HashMap<Integer, SecDouble> mapDouble = new HashMap<>();
		for (int i = 0; i < nSec; ++i) { //创建统计项
			SecDouble f = new SecDouble();
			f.min = per * i + dMin;
			f.max = f.min + per;
			mapDouble.put(i, f);
			System.out.println("跨幅:"+ per + " 分段:"+i+"(min~max):"+f.min + "~" + f.max);
		}
		
		for (int i = 0; i < dCount; ++i){
			double r = random(dMin, dMax);
			int index = (int)((r - dMin) / per);
			SecDouble b = mapDouble.get(index);
			b.nCount += 1;
			//System.out.println("index:"+index+" r:"+r);
		}
		
		strOut = "共执行了"+dCount+"次,\n";
		for (Entry<Integer, SecDouble> entry : mapDouble.entrySet()){ //输出
			SecDouble nVal = entry.getValue();
			strOut = strOut + entry.getKey() + ":" + nVal.nCount + "次," + nVal.nCount/(double)dCount * 100 + "%\n";
		}
		System.out.println(strOut);
	}
}
