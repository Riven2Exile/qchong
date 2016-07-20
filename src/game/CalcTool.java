package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 *  ���㹤��
 */

public class CalcTool {
	
	// (min , max ) ����ͨ��      ��ע�⣺ Math.random() �ķ�Χ�� (0,1), ���������ĵ���˵��[0,1)��
	public static double random(double min, double max){
		return min + Math.random() * (max-min);
	}
	
	// [min, max] ����ͨ��
	public static int random(int min, int max) {
		double r = Math.random();
		double b = r * (max-min + 1);
		//System.out.println("r:"+r+" b:"+b + " (int)b:"+(int)b);
		return min + (int)b;
	}
	
	// Ȩ��.... �ù�����һ��Ԥ�ȶ����Ȩ�ر��õ�һ��Ȩ���±�����
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
		
		// �ڲ���
		class SecDouble{
			public double min;
			public double max;
			public int nCount = 0;
		}
		// �ڲ���end
		
		
		System.out.println("CalcTool ���Կ�ʼ");
		// 1.  ����  random(int min, int max)
		int nCount = 5000000;
		int nMin = 1;
		int nMax = 5;
		HashMap<Integer,Integer> mapData = new HashMap<Integer,Integer>(); //����д�� HashMap<int,int>, ��Ϊ�������Ͳ�����Ϊ��������
		for (int i = nMin; i <= nMax; ++i){
			mapData.put(i, 0);
		}
		
		for (int i = 0; i < nCount; ++i){
			Integer nKey = random(nMin, nMax);    
			mapData.put(nKey, mapData.get(nKey).intValue() + 1) ;
		}
		
		String strOut = "��ִ����"+nCount+"��,\n";
		for(Entry<Integer, Integer> entry : mapData.entrySet()){
			int nVal = entry.getValue();
			strOut = strOut + entry.getKey() + ":" + nVal + "��," + nVal/(double)nCount * 100 + "%\n";
		}
		
		System.out.println(strOut);
		
		// 2. ����  random(double min, double max)
		double dMin = 1.9;
		double dMax = 2;
		int nSec = 5; //������ͳ�ƻ��һ��
		int dCount = 5000000;
		double per = (dMax - dMin) / nSec; //һ�������Ŀ��
		HashMap<Integer, SecDouble> mapDouble = new HashMap<>();
		for (int i = 0; i < nSec; ++i) { //����ͳ����
			SecDouble f = new SecDouble();
			f.min = per * i + dMin;
			f.max = f.min + per;
			mapDouble.put(i, f);
			System.out.println("���:"+ per + " �ֶ�:"+i+"(min~max):"+f.min + "~" + f.max);
		}
		
		for (int i = 0; i < dCount; ++i){
			double r = random(dMin, dMax);
			int index = (int)((r - dMin) / per);
			SecDouble b = mapDouble.get(index);
			b.nCount += 1;
			//System.out.println("index:"+index+" r:"+r);
		}
		
		strOut = "��ִ����"+dCount+"��,\n";
		for (Entry<Integer, SecDouble> entry : mapDouble.entrySet()){ //���
			SecDouble nVal = entry.getValue();
			strOut = strOut + entry.getKey() + ":" + nVal.nCount + "��," + nVal.nCount/(double)dCount * 100 + "%\n";
		}
		System.out.println(strOut);
	}
}
