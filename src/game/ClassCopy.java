package game;

import java.lang.reflect.Field;

/*
 *  ÀàµÄ¿½±´
 */

public class ClassCopy {
	public static <T> T Copy(T obj){
		T newObj = null;
		try {
			newObj = (T)obj.getClass().newInstance();
			Field[] field =  obj.getClass().getDeclaredFields();
			Field[] newObjField = newObj.getClass().getDeclaredFields();
			for (int i = 0 ; i < field.length; ++i){
				newObjField[i].setAccessible(true);
				Object data = field[i].get(obj);
				if(data instanceof Number || data instanceof Boolean){
					newObjField[i].set(newObj, obj);
				}
				else{
					newObjField[i].set(newObj, copy(field[i].get(obj)));
				}
				
			}
			
			return newObj;
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally{
//			return newObj;
//		}
		return newObj;
	}
	
	private static Object copy(Object obj){
		try {
			Object newobj = obj.getClass().newInstance();
			newobj = obj;
			return newobj;
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
