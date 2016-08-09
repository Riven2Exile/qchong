package game.factory;

import buff.BaseFightBuff;
import buff.QiENaoYangBuff;

/**
 *  战斗buff工厂类
 * @author lpr
 *
 */
public class FightBuffFactory {

	public static BaseFightBuff getInstance(int id){
		switch (id) {
		case BaseFightBuff.Buff_QErNaoYang: return new QiENaoYangBuff();

		default: return null;
		}
	}

}
