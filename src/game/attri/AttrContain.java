package game.attri;

import java.util.ArrayList;

/**
 *  ��������, Ϊ�˽����һ��������ԣ� ���������Լ�ս������
 * @author liupr
 *
 */

public class AttrContain{

	public AttrContain(int baseSize, int addSize) {
		// TODO Auto-generated constructor stub
		mBaseData = new ArrayList<>(baseSize);
		for(int i = 0; i < baseSize; ++i)
			mBaseData.add(0);
		mAddiFightData = new ArrayList<>(addSize);
		for(int i = 0; i < addSize; ++i)
			mAddiFightData.add(0);
	}
	
	public void setBaseData(int index, int v){
		if (index >= 0 && index < mBaseData.size()) { //֮����ȥ�������ж�
			mBaseData.set(index, v);
			mBaseDataDirty = true;
		}
	}
	public void addBaseData(int index, int v){
		if (index >= 0 && index < mBaseData.size()) {
			mBaseData.set(index, v + mBaseData.get(index));
			mBaseDataDirty = true;
		}
	}
	public int getBaseData(int index){
		if (index >= 0 && index < mBaseData.size()) {
			return mBaseData.get(index);
		}
		return 0;
	}
	
	
	public void setAddiData(int index, int v){
		if (index >= 0 && index < mAddiFightData.size()) {
			mAddiFightData.set(index, v);
			mAddiFightDataDirty = true;
		}
	}
	public void addAddiData(int index, int v){
		if (index >= 0 && index < mAddiFightData.size()) {
			mAddiFightData.set(index, v + mAddiFightData.get(index));
			mAddiFightDataDirty = true;
		}
	}
	public int getAddiData(int index){
		if (index >= 0 && index < mAddiFightData.size()) {
			return mAddiFightData.get(index);
		}
		return 0;
	}
	
	/**
	 *  ���¼��� ���е�total��ֵ
	 */
	public void recalAll(){
		getTotalBaseData();
		getTotalAddiData();
	}
	
	public int getTotalBaseData() {
		if (mBaseDataDirty) {
			mTotalBaseData = 0;
			for (Integer i : mBaseData) {
				mTotalBaseData += i;
			}
			mBaseDataDirty = false;
			
			mTotalFinalData = mTotalBaseData + mTotalAddiData;
		}
		return mTotalBaseData;
	}
	
	public int getTotalAddiData(){
		if (mAddiFightDataDirty) {
			mTotalAddiData = 0;
			for (Integer i : mAddiFightData) {
				mTotalAddiData += i;
			}
			mAddiFightDataDirty = false;
			mTotalFinalData = mTotalBaseData + mTotalAddiData;
		}
		return mTotalAddiData;
	}
	
	public int getTotalFinalData(){
		return mTotalFinalData;
	}

	boolean mBaseDataDirty = false;
	ArrayList<Integer> mBaseData;			//��������
	
	boolean mAddiFightDataDirty = false;
	ArrayList<Integer> mAddiFightData;	//ս���ж��ӳɵ�����
	
	int mTotalBaseData = 0;
	int mTotalAddiData = 0;
	int mTotalFinalData = 0;	//ս����ʹ�õ�����ֵ
	
}
