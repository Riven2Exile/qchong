package game;

import java.util.ArrayList;

/*
 *  »®÷ÿ∏∏¿‡
 */

public class BaseWeight<E> {

	ArrayList<E> _mData;
	
	public BaseWeight() {
		// TODO Auto-generated constructor stub
	}

	public void putAData(E data){
		_mData.add(data);
	}
	
	public int getSize(){
		return _mData.size();
	}
	
	public boolean GetData(int nIndex, E outData){
		if (nIndex >= 0 && nIndex < _mData.size()){
			outData = _mData.get(nIndex);
			return true;
		}
		else
			return false;
	}
}
