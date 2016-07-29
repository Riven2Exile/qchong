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
	
	// ����... (��������)  ����ͨ��
	public static boolean probabilityInt(int nProbability){
		return nProbability >= random(1, 100);
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
		
		// 3. ���� probabilityInt ����
		int[] nArrayPro = {0, 3, 67, 100};
		strOut = "��ִ����"+dCount+"��,\n";
		for ( int iPro : nArrayPro ){
			int iCount = 0;  //���д���
			for ( int i = 0; i < dCount; ++i ){
				if (probabilityInt(iPro) ){
					++iCount;
				}
			}		
			
			strOut = strOut + "�趨����Ϊ:" + iPro + "%," + "���ʵ��ִ�и���Ϊ:" + iCount/(float)dCount * 100 + "%\n";
			System.out.println(strOut);
		}
		
		// 4.����Ȩ��
		BaseWeightContent weightObj = new BaseWeightContent();
		weightObj.putAData(new BaseWeight(1));
		weightObj.putAData(new BaseWeight(2));
		weightObj.putAData(new BaseWeight(1));
		mapData.clear();
		strOut = "��ִ����"+dCount+"��,\n";
		mapData.put(0, 0);
		mapData.put(1, 0);
		mapData.put(2, 0);
		for (int i = 0 ; i < dCount; ++i){
			int nKey =  weightObj.getWeightIndex();
			mapData.get( nKey ).intValue();
			mapData.put(nKey, mapData.get( nKey ).intValue() + 1) ;
		}
		
		for ( Entry<Integer, Integer> e : mapData.entrySet() ){
			strOut = strOut + "��Ŀ:" + e.getKey() + "�ĸ���:" + e.getValue() / (float)dCount * 100 + "%\n";
		}
		System.out.println(strOut);
	}
}
