package game;

import java.util.ArrayList;

/*
 *  权重收集类
 */

public class BaseWeightContent {

	ArrayList<BaseWeight> _mData = new ArrayList<>();
	
	int _nTotalWeigth = 0;
	
	public BaseWeightContent() {
		// TODO Auto-generated constructor stub
	}

	public void putAData(BaseWeight data){
		_mData.add(data);
	}
	
	public int getSize(){
		return _mData.size();
	}
	
	public boolean GetData(int nIndex, BaseWeight outData){
		if (nIndex >= 0 && nIndex < _mData.size()){
			outData = _mData.get(nIndex);
			return true;
		}
		else
			return false;
	}
	
	public void ReCalTotalWeight(){
		int nSize = _mData.size();
		_nTotalWeigth = 0;
		for (int i = 0; i < nSize; ++i){
			_nTotalWeigth += _mData.get(i).getWeight();
		}
	}
	
	public void clear(){
		_mData.clear();
		_nTotalWeigth = 0;
	}
	
	public int getTotalWeight(){
		return _nTotalWeigth;
	}
	
	//// 计算出执行权重计算   (测试通过)
	public int getWeightIndex()
	{
		if(_mData.size() == 0){
			return -1;
		}
		else{
			if(getTotalWeight() == 0){
				ReCalTotalWeight();
			}
			
			int nSize = _mData.size();
			int nHit = CalcTool.random(1, getTotalWeight());
			int nTempW = 0;
			for (int i = 0; i < nSize; ++i){
				if (nTempW < nHit && nHit <= nTempW + _mData.get(i).getWeight() ){
					return i; //命中
				}
				
				nTempW += _mData.get(i).getWeight();
			}
			
			return -1;
		}
	}
	
	public BaseWeight getWeightData(){
		int nIndex = getWeightIndex();
		if (nIndex == -1){
			return null;
		}
		
		return _mData.get(nIndex);
	}
}
