package game.factory;

import buff.BaseFightBuff;
import buff.QiENaoYangBuff;

/**
 *  ս��buff������
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
