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
		case WeaponKind.SHE_YING_GONG: return new SheYingGongWeapon(enhanceLv, m.min, m.max);	//��Ӱ��
		case WeaponKind.KUANG_MO_LIAN: return new KuangMoLianWeapon(enhanceLv, m.min, m.max);	//��ħ��
		case WeaponKind.PAN_GUAN_BI: return new PanGuanBiWeapon(enhanceLv, m.min, m.max);		//�йٱ�
		case WeaponKind.SHUANG_JIE_GUN: return new ShuangJieGunWeapon(enhanceLv, m.min, m.max); //˫�ع�
		case WeaponKind.LIU_XING_QIU: return new LiuXingQiuWeapon(enhanceLv, m.min, m.max);		//������
		case WeaponKind.JIE_LI_BANG: return new JieLiBangWeapon(enhanceLv, m.min, m.max);		//������
		case WeaponKind.SHOU_LEI: return new ShouLeiWeapon(enhanceLv, m.min, m.max);			//����
		case WeaponKind.DUAN_JIAN: return new DuanJianWeapon(enhanceLv, m.min, m.max);			//�̽�
		case WeaponKind.LAO_SHU: return new LaoShuWeapon(enhanceLv, m.min, m.max);				//����
		case WeaponKind.QI_SHUI_GUAN: return new QiShuiGuanWeapon(enhanceLv, m.min, m.max);		//��ˮ��
		case WeaponKind.FEI_DAO: return new XiaoLiFeiDaoWeapon(enhanceLv, m.min, m.max);		//С��ɵ�
		case WeaponKind.MU_CHUI: return new MuChuiWeapon(enhanceLv, m.min, m.max);				//ľ�
		case WeaponKind.KUAN_REN_JIAN: return new KuanRenJianWeapon(enhanceLv, m.min, m.max);	//���н�
		case WeaponKind.HONG_YING_QIANG: return new HongYingQiangWeapon(enhanceLv, m.min, m.max);	//��ӧǹ
		case WeaponKind.TIE_CHAN: return new TieChanWeapon(enhanceLv, m.min, m.max);			//����
		case WeaponKind.HUAN_KOU_DAO: return new HuanKouDaoWeapon(enhanceLv, m.min, m.max);		//���۵�
		case WeaponKind.MU_JIAN: return new MuJianWeapon(enhanceLv, m.min, m.max);				//ľ��
		case WeaponKind.HUAN_YING_QIANG: return new HuanYingQiangWeapon(enhanceLv, m.min, m.max);//��Ӱǹ
		}
		return null;
	}
	
	
	///// �������ֺܴ�ķ�ʽд
	public static void getDamageValue(int weaponKind, int enhanceLv, minmax m){
		if (WeaponKind.SHE_YING_GONG == weaponKind){ //��Ӱ��
			if (0 == enhanceLv){
				m.min = 20;
				m.max = 22;
			}
		}
		else if(WeaponKind.KUANG_MO_LIAN == weaponKind){ // ��ħ��
			if (0 == enhanceLv){
				m.min = 15;
				m.max = 25;
			}
		}
		else if(WeaponKind.PAN_GUAN_BI == weaponKind){ //�йٱ�
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
		else if(WeaponKind.SHOU_LEI == weaponKind){ //����
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
		else if(WeaponKind.LAO_SHU == weaponKind){ //����
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
		else if(WeaponKind.KUAN_REN_JIAN == weaponKind){ //���н�
			if (0 == enhanceLv){
				m.min = 6;
				m.max = 10;
			}
		}
	}
}




