package game.factory;

import game.define.WeaponKind;
import game.weapon.BaseWeapon;
import game.weapon.DuanJianWeapon;
import game.weapon.HongYingQiangWeapon;
import game.weapon.HuanKouDaoWeapon;
import game.weapon.HuanYingQiangWeapon;
import game.weapon.JieLiBangWeapon;
import game.weapon.KuanRenJianWeapon;
import game.weapon.KuangMoLianWeapon;
import game.weapon.LaoShuWeapon;
import game.weapon.LiuXingQiuWeapon;
import game.weapon.MuChuiWeapon;
import game.weapon.MuJianWeapon;
import game.weapon.PanGuanBiWeapon;
import game.weapon.QiShuiGuanWeapon;
import game.weapon.SheYingGongWeapon;
import game.weapon.ShouLeiWeapon;
import game.weapon.ShuangJieGunWeapon;
import game.weapon.TieChanWeapon;
import game.weapon.XiaoLiFeiDaoWeapon;

public class WeaponFactory {
		static class minmax{
			public minmax() {}
			public int min = 0;
			public int max = 0;
		}
		
	public static BaseWeapon getInstance(int weaponKind, int enhanceLv){
		minmax m = new minmax();
		getDamageValue(weaponKind, enhanceLv, m);
		switch (weaponKind){
		case WeaponKind.SHE_YING_GONG: return new SheYingGongWeapon(enhanceLv, m.min, m.max);	//ÉßÓ°¹­
		case WeaponKind.KUANG_MO_LIAN: return new KuangMoLianWeapon(enhanceLv, m.min, m.max);	//¿ñÄ§Á­
		case WeaponKind.PAN_GUAN_BI: return new PanGuanBiWeapon(enhanceLv, m.min, m.max);		//ÅÐ¹Ù±Ê
		case WeaponKind.SHUANG_JIE_GUN: return new ShuangJieGunWeapon(enhanceLv, m.min, m.max); //Ë«½Ø¹÷
		case WeaponKind.LIU_XING_QIU: return new LiuXingQiuWeapon(enhanceLv, m.min, m.max);		//Á÷ÐÇÇò
		case WeaponKind.JIE_LI_BANG: return new JieLiBangWeapon(enhanceLv, m.min, m.max);		//½ÓÁ¦°ô
		case WeaponKind.SHOU_LEI: return new ShouLeiWeapon(enhanceLv, m.min, m.max);			//ÊÖÀ×
		case WeaponKind.DUAN_JIAN: return new DuanJianWeapon(enhanceLv, m.min, m.max);			//¶Ì½£
		case WeaponKind.LAO_SHU: return new LaoShuWeapon(enhanceLv, m.min, m.max);				//ÀÏÊó
		case WeaponKind.QI_SHUI_GUAN: return new QiShuiGuanWeapon(enhanceLv, m.min, m.max);		//ÆûË®¹Þ
		case WeaponKind.FEI_DAO: return new XiaoLiFeiDaoWeapon(enhanceLv, m.min, m.max);		//Ð¡Àî·Éµ¶
		case WeaponKind.MU_CHUI: return new MuChuiWeapon(enhanceLv, m.min, m.max);				//Ä¾é³
		case WeaponKind.KUAN_REN_JIAN: return new KuanRenJianWeapon(enhanceLv, m.min, m.max);	//¿íÈÐ½£
		case WeaponKind.HONG_YING_QIANG: return new HongYingQiangWeapon(enhanceLv, m.min, m.max);	//ºìÓ§Ç¹
		case WeaponKind.TIE_CHAN: return new TieChanWeapon(enhanceLv, m.min, m.max);			//Ìú²ù
		case WeaponKind.HUAN_KOU_DAO: return new HuanKouDaoWeapon(enhanceLv, m.min, m.max);		//»·¿Ûµ¶
		case WeaponKind.MU_JIAN: return new MuJianWeapon(enhanceLv, m.min, m.max);				//Ä¾½£
		case WeaponKind.HUAN_YING_QIANG: return new HuanYingQiangWeapon(enhanceLv, m.min, m.max);//»ÃÓ°Ç¹
		}
		return null;
	}
	
	
	///// ÏÈÓÃÕâÖÖºÜ´ìµÄ·½Ê½Ð´
	public static void getDamageValue(int weaponKind, int enhanceLv, minmax m){
		if (WeaponKind.SHE_YING_GONG == weaponKind){ //ÉßÓ°¹­
			if (0 == enhanceLv){
				m.min = 20;
				m.max = 22;
			}
		}
		else if(WeaponKind.KUANG_MO_LIAN == weaponKind){ // ¿ñÄ§Á­
			if (0 == enhanceLv){
				m.min = 15;
				m.max = 25;
			}
		}
		else if(WeaponKind.PAN_GUAN_BI == weaponKind){ //ÅÐ¹Ù±Ê
			if (0 == enhanceLv){
				m.min = 10;
				m.max = 15;
			}
		}
		else if(WeaponKind.SHUANG_JIE_GUN == weaponKind){
			if (0 == enhanceLv){
				m.min = 9;
				m.max = 13;
			}
		}
		else if(WeaponKind.LIU_XING_QIU == weaponKind){
			if (0 == enhanceLv){
				m.min = 15;
				m.max = 24;
			}
		}
		else if(WeaponKind.JIE_LI_BANG == weaponKind){
			if (0 == enhanceLv){
				m.min = 11;
				m.max = 16;
			}
		}
		else if(WeaponKind.SHOU_LEI == weaponKind){ //ÊÖÀ×
			if (0 == enhanceLv){
				m.min = 2;
				m.max = 20;
			}
		}
		else if(WeaponKind.DUAN_JIAN == weaponKind){
			if (0 == enhanceLv){
				m.min = 5;
				m.max = 9;
			}
		}
		else if(WeaponKind.LAO_SHU == weaponKind){ //ÀÏÊó
			if (0 == enhanceLv){
				m.min = 8;
				m.max = 13;
			}
		}
		else if(WeaponKind.QI_SHUI_GUAN == weaponKind){
			if (0 == enhanceLv){
				m.min = 4;
				m.max = 6;
			}
		}
		else if(WeaponKind.FEI_DAO == weaponKind){
			if (0 == enhanceLv){
				m.min = 5;
				m.max = 10;
			}
		}
		else if(WeaponKind.MU_CHUI == weaponKind){
			if (0 == enhanceLv){
				m.min = 14;
				m.max = 18;
			}
		}
		else if(WeaponKind.KUAN_REN_JIAN == weaponKind){ //¿íÈÐ½£
			if (0 == enhanceLv){
				m.min = 6;
				m.max = 10;
			}
		}
	}
}




