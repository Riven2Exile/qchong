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
	
	// 概率... (输入整型)  测试通过
	public static boolean probabilityInt(int nProbability){
		return nProbability >= random(1, 100);
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
		
		// 3. 测试 probabilityInt 概率
		int[] nArrayPro = {0, 3, 67, 100};
		strOut = "共执行了"+dCount+"次,\n";
		for ( int iPro : nArrayPro ){
			int iCount = 0;  //命中次数
			for ( int i = 0; i < dCount; ++i ){
				if (probabilityInt(iPro) ){
					++iCount;
				}
			}		
			
			strOut = strOut + "设定概率为:" + iPro + "%," + "结果实验执行概率为:" + iCount/(float)dCount * 100 + "%\n";
			System.out.println(strOut);
		}
		
		// 4.测试权重
		BaseWeightContent weightObj = new BaseWeightContent();
		weightObj.putAData(new BaseWeight(1));
		weightObj.putAData(new BaseWeight(2));
		weightObj.putAData(new BaseWeight(1));
		mapData.clear();
		strOut = "共执行了"+dCount+"次,\n";
		mapData.put(0, 0);
		mapData.put(1, 0);
		mapData.put(2, 0);
		for (int i = 0 ; i < dCount; ++i){
			int nKey =  weightObj.getWeightIndex();
			mapData.get( nKey ).intValue();
			mapData.put(nKey, mapData.get( nKey ).intValue() + 1) ;
		}
		
		for ( Entry<Integer, Integer> e : mapData.entrySet() ){
			strOut = strOut + "项目:" + e.getKey() + "的概率:" + e.getValue() / (float)dCount * 100 + "%\n";
		}
		System.out.println(strOut);
	}
}
