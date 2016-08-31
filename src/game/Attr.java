package game;

import game.attri.AttrAddHandDamageContain;
import game.attri.AttrAddHandDamagePerContain;
import game.attri.AttrDodgeContain;
import game.attri.AttrHitContain;
import game.attri.AttrSubHandDamageContain;
import game.attri.AttrSubHandDamagePerContain;

/*
 * 属性类
 * */
public class Attr 
{
	int _base_hp = 0; 	//基础生命值
	int _addi_hp = 0;	//附加生命值
	int _final_hp = 0;	//最终生命值,战斗使用
	int _max_hp = 0;	//最大生命值
	///// 三围属性
	int _base_power = 0;
	int _base_minjie = 0;
	int _base_speed = 0;
	
	int _base_power_buff = 0;
	int _base_minjie_buff = 0;
	int _base_speed_buff = 0;
	
	int _total_base_power = 0;
	int _total_base_minjie = 0;
	int _total_base_speed = 0;
	
	int _addi_power_skill = 0;
	int _addi_minjie_skill = 0;
	int _addi_speed_skill = 0;
	
	int _addi_power_buff = 0;
	int _addi_minjie_buff = 0;
	int _addi_speed_buff = 0;
	
	
	int _total_addi_power = 0;
	int _total_addi_minjie = 0;
	int _total_addi_speed = 0;
	
	int _final_power = 0;   //可能需要加上属性药而得到final
	int _final_minjie = 0;
	int _final_speed = 0;
	
	
	////// 暴击   / 抗暴
	////// 命中   / 闪避
	public AttrHitContain _attr_hit = new AttrHitContain(AttrHitContain.hitBase.hit_num.ordinal(), AttrHitContain.hitAddi.hit_num.ordinal()); //新版的命中属性
	
	public AttrDodgeContain _attr_dodge = new AttrDodgeContain(AttrDodgeContain.dodgeBase.dodge_num.ordinal(), AttrDodgeContain.dodgeAddi.dodge_num.ordinal());
	
	int _hitBack = 0;// 反击率
	public void set_hitBack(int h){
		_hitBack = h;
	}
	public void add_hitBack(int v) { _hitBack += v;}
	public int get_hitBack() { return _hitBack; }

	int _doubleHit = 0;	//连击率
	
	int _addSkillDamage = 0;	//技能伤害值
	int _subSkillDamage	= 0;	//抗技能伤害值
	int _addSkillDamagePer	= 0;	//技能增伤百分比
	int _subSkillDamagePer	= 0;	//佳能伤害减免百分比
	
	int _addThrowWeaponDamage	= 0;
	int _addThrowWeaponDamagePer= 0;
	int _subThrowWeaponDamage	= 0;
	int _subThrowWeaponDamagePer= 0;
	
	int _addTinyWeaponDamage	= 0;
	int _addTinyWeaponDamagePer	= 0;
	int _subTinyWeaponDamage	= 0;
	int _subTinyWeaponDamagePer	= 0;
	
	int _addMidWeaponDamage		= 0;
	int _addMidWeaponDamagePer	= 0;
	int _subMidWeaponDamage		= 0;
	int _subMidWeaponDamagePer	= 0;
	
	int _addLargeWeaponDamage	= 0;
	int _addLargeWeaponDamagePer= 0;
	int _subLargeWeaponDamage	= 0;
	int _subLargeWeaponDamagePer= 0;
	
	public AttrAddHandDamageContain _addEmptyHandDamage = new AttrAddHandDamageContain(); //空手数值增伤
	public AttrAddHandDamagePerContain _addEmptyHandDamagePer = new AttrAddHandDamagePerContain(); //空手百分比增伤
	public AttrSubHandDamageContain _subEmptyHandDamage		= new AttrSubHandDamageContain(); //空手数值减伤
	public AttrSubHandDamagePerContain _subEmptyHandDamagePer	= new AttrSubHandDamagePerContain(); //空手百分比减伤
	
	
	public void CalcBaseThree(){
		_total_base_power = _base_power + _base_power_buff;
		_total_base_minjie = _base_minjie + _base_minjie_buff;
		_total_base_speed = _base_speed + _base_speed_buff;
	}
	
	public void CalcAddictionThree(){
		_total_addi_power = _addi_power_skill + _addi_power_buff;
		_total_addi_minjie = _addi_minjie_skill + _addi_minjie_buff;
		_total_addi_speed = _addi_speed_skill + _addi_speed_buff;
	}
	
	public void CalcFinalThree(){
		CalcBaseThree();
		CalcAddictionThree();
		
		_final_power = _total_base_power + _total_addi_power;
		_final_minjie = _total_base_minjie + _total_addi_minjie;
		_final_speed = _total_base_speed + _total_addi_speed;
		
		_final_hp = _base_hp + this.get_addi_hp();
		this._max_hp = _final_hp;
		
		_attr_hit.recalAll(); 	//重算命中率
		_attr_dodge.recalAll();	//重算闪避率
		_addEmptyHandDamage.recalAll();
		_addEmptyHandDamagePer.recalAll();
		_subEmptyHandDamage.recalAll();
		_subEmptyHandDamagePer.recalAll();
	}
	
	public void calcFinalOnly(){
		_final_hp = _base_hp + this.get_addi_hp();
		this._max_hp = _final_hp;
		
		_final_power = get_total_base_power() + get_total_addi_power();
		_final_minjie = get_total_base_minjie()  + get_total_addi_minjie();
		_final_speed = get_total_base_speed() + get_total_addi_speed();
		
		_attr_hit.recalAll();//重算命中率
		_attr_dodge.recalAll();//重算闪避率
		_addEmptyHandDamage.recalAll();
		_addEmptyHandDamagePer.recalAll();
		_subEmptyHandDamage.recalAll();
		_subEmptyHandDamagePer.recalAll();
	}
	
	public void clearExceptBaseThree(){
		_base_power_buff = 0;
		_base_minjie_buff = 0;
		_base_speed_buff = 0;
		
		_total_base_power = 0;
		_total_base_minjie = 0;
		_total_base_speed = 0;
		
		_addi_power_skill = 0;
		_addi_minjie_skill = 0;
		_addi_speed_skill = 0;
		
		_addi_power_buff = 0;
		_addi_minjie_buff = 0;
		_addi_speed_buff = 0;
		
		
		_total_addi_power = 0;
		_total_addi_minjie = 0;
		_total_addi_speed = 0;
		
		_final_power = 0;   //可能需要加上属性药而得到final
		_final_minjie = 0;
		_final_speed = 0;
	}
	
	public int get_base_hp() {
		return _base_hp;
	}
	public void set_base_hp(int _base_hp) {
		this._base_hp = _base_hp;
	}
	
	public int get_addi_hp(){
		return this._addi_hp;
	}
	public void set_addi_hp(int n){
		this._addi_hp = n;
	}
	public void add_addi_hp(int n){
		this._addi_hp += n;
	}

	public int get_final_hp(){
		return this._final_hp;
	}
	public void set_final_hp(int _final_hp) {
		this._final_hp = _final_hp;
	}
	public void add_final_hp(int n){
		if(this._final_hp + n <= this._max_hp){
			_final_hp += n;
			if(_final_hp < 0){
				_final_hp = 0;
			}
		}
	}
	
	public void set_max_hp(int n){
		this._max_hp += n;
	}
	public int get_max_hp(){
		return this._max_hp;
	}
	
	
	public int get_base_power() {
		return _base_power;
	}
	public void set_base_power(int _base_power) {
		this._base_power = _base_power;
	}
	public int get_base_minjie() {
		return _base_minjie;
	}
	public void set_base_minjie(int _base_minjie) {
		this._base_minjie = _base_minjie;
	}
	public int get_base_speed() {
		return _base_speed;
	}
	public void set_base_speed(int _base_speed) {
		this._base_speed = _base_speed;
	}
	
	public void set_base_three(int power, int minjie, int speed){
		this.set_base_power(power);
		this.set_base_minjie(minjie);
		this.set_base_speed(speed);
	}
	
	public int get_base_power_buff() {
		return _base_power_buff;
	}
	public void set_base_power_buff(int _base_power_buff) {
		this._base_power_buff = _base_power_buff;
	}
	public int get_base_minjie_buff() {
		return _base_minjie_buff;
	}
	public void set_base_minjie_buff(int _base_minjie_buff) {
		this._base_minjie_buff = _base_minjie_buff;
	}
	public int get_base_speed_buff() {
		return _base_speed_buff;
	}
	public void set_base_speed_buff(int _base_speed_buff) {
		this._base_speed_buff = _base_speed_buff;
	}
	public int get_total_base_power() {
		return _total_base_power;
	}
	public void set_total_base_power(int _total_base_power) {
		this._total_base_power = _total_base_power;
	}
	public int get_total_base_minjie() {
		return _total_base_minjie;
	}
	public void set_total_base_minjie(int _total_base_minjie) {
		this._total_base_minjie = _total_base_minjie;
	}
	public int get_total_base_speed() {
		return _total_base_speed;
	}
	public void set_total_base_speed(int _total_base_speed) {
		this._total_base_speed = _total_base_speed;
	}
	public int get_addi_power_skill() {
		return _addi_power_skill;
	}
	public void set_addi_power_skill(int _addi_power_skill) {
		this._addi_power_skill = _addi_power_skill;
	}
	public void add_addi_power_skill(int addi_power_skill){
		this._addi_power_skill += addi_power_skill;
	}
	public int get_addi_minjie_skill() {
		return _addi_minjie_skill;
	}
	public void set_addi_minjie_skill(int _addi_minjie_skill) {
		this._addi_minjie_skill = _addi_minjie_skill;
	}
	public void add_addi_minjie_skill( int addi_minjie_skill){
		this._addi_minjie_skill += addi_minjie_skill;
	}
	
	public int get_addi_speed_skill() {
		return _addi_speed_skill;
	}
	public void set_addi_speed_skill(int _addi_speed_skill) {
		this._addi_speed_skill = _addi_speed_skill;
	}
	public void add_addi_speed_skill(int nadd){
		set_addi_speed_skill(nadd + get_addi_speed_skill());
	}
	public int get_addi_power_buff() {
		return _addi_power_buff;
	}
	public void set_addi_power_buff(int _addi_power_buff) {
		this._addi_power_buff = _addi_power_buff;
	}
	public int get_addi_minjie_buff() {
		return _addi_minjie_buff;
	}
	public void set_addi_minjie_buff(int _addi_minjie_buff) {
		this._addi_minjie_buff = _addi_minjie_buff;
	}
	public int get_addi_speed_buff() {
		return _addi_speed_buff;
	}
	public void set_addi_speed_buff(int _addi_speed_buff) {
		this._addi_speed_buff = _addi_speed_buff;
	}
	public int get_total_addi_power() {
		return _total_addi_power;
	}
	public void set_total_addi_power(int _total_addi_power) {
		this._total_addi_power = _total_addi_power;
	}
	public int get_total_addi_minjie() {
		return _total_addi_minjie;
	}
	public void set_total_addi_minjie(int _total_addi_minjie) {
		this._total_addi_minjie = _total_addi_minjie;
	}
	public int get_total_addi_speed() {
		return _total_addi_speed;
	}
	public void set_total_addi_speed(int _total_addi_speed) {
		this._total_addi_speed = _total_addi_speed;
	}
	public int get_final_power() {
		return _final_power;
	}
	public void set_final_power(int _final_power) {
		this._final_power = _final_power;
	}
	public int get_final_minjie() {
		return _final_minjie;
	}
	public void set_final_minjie(int _final_minjie) {
		this._final_minjie = _final_minjie;
	}
	public int get_final_speed() {
		return _final_speed;
	}
	public void set_final_speed(int _final_speed) {
		this._final_speed = _final_speed;
	}
	
	
	
	// 计算高级属性

	public int get_addSkillDamage() {
		return _addSkillDamage;
	}

	public void set_addSkillDamage(int _addSkillDamage) {
		this._addSkillDamage = _addSkillDamage;
	}
	public void add_addSkillDamage(int n){
		this._addSkillDamage += n;
	}

	public int get_subSkillDamage() {
		return _subSkillDamage;
	}

	public void set_subSkillDamage(int _subSkillDamage) {
		this._subSkillDamage = _subSkillDamage;
	}
	public void add_subSkillDamage(int n){
		this._subSkillDamage += n;
	}

	public int get_addSkillDamagePer() {
		return _addSkillDamagePer;
	}

	public void set_addSkillDamagePer(int _addSkillDamagePer) {
		this._addSkillDamagePer = _addSkillDamagePer;
	}
	public void add_addSkillDamagePer(int n){
		this._addSkillDamagePer += n;
	}

	public int get_subSkillDamagePer() {
		return _subSkillDamagePer;
	}

	public void set_subSkillDamagePer(int _subSkillDamagePer) {
		this._subSkillDamagePer = _subSkillDamagePer;
	}
	public void add_subSkillDamagePer(int n){
		this._subSkillDamagePer += n;
	}

	public int get_addThrowWeaponDamage() {
		return _addThrowWeaponDamage;
	}

	public void set_addThrowWeaponDamage(int _addThrowWeaponDamage) {
		this._addThrowWeaponDamage = _addThrowWeaponDamage;
	}
	public void add_addThrowWeaponDamage(int n){
		this._addThrowWeaponDamage += n;
	}

	public int get_addThrowWeaponDamagePer() {
		return _addThrowWeaponDamagePer;
	}

	public void set_addThrowWeaponDamagePer(int _addThrowWeaponDamagePer) {
		this._addThrowWeaponDamagePer = _addThrowWeaponDamagePer;
	}
	public void add_addThrowWeaponDamagePer(int n){
		this._addThrowWeaponDamagePer += n;
	}

	public int get_subThrowWeaponDamage() {
		return _subThrowWeaponDamage;
	}

	public void set_subThrowWeaponDamage(int _subThrowWeaponDamage) {
		this._subThrowWeaponDamage = _subThrowWeaponDamage;
	}
	public void add_subThrowWeaponDamage(int n){
		this._subThrowWeaponDamage += n;
	}

	public int get_subThrowWeaponDamagePer() {
		return _subThrowWeaponDamagePer;
	}

	public void set_subThrowWeaponDamagePer(int _subThrowWeaponDamagePer) {
		this._subThrowWeaponDamagePer = _subThrowWeaponDamagePer;
	}
	public void add_subThrowWeaponDamagePer(int n){
		this._subThrowWeaponDamagePer += n;
	}

	public int get_addTinyWeaponDamage() {
		return _addTinyWeaponDamage;
	}

	public void set_addTinyWeaponDamage(int _addTinyWeaponDamage) {
		this._addTinyWeaponDamage = _addTinyWeaponDamage;
	}
	public void add_addTinyWeaponDamage(int n){
		this._addTinyWeaponDamage += n;
	}
	

	public int get_addTinyWeaponDamagePer() {
		return _addTinyWeaponDamagePer;
	}

	public void set_addTinyWeaponDamagePer(int _addTinyWeaponDamagePer) {
		this._addTinyWeaponDamagePer = _addTinyWeaponDamagePer;
	}
	public void add_addTinyWeaponDamagePer(int n){
		this._addTinyWeaponDamagePer += n;
	}

	public int get_subTinyWeaponDamage() {
		return _subTinyWeaponDamage;
	}

	public void set_subTinyWeaponDamage(int _subTinyWeaponDamage) {
		this._subTinyWeaponDamage = _subTinyWeaponDamage;
	}
	public void add_subTinyWeaponDamage(int n){
		this._subTinyWeaponDamage += n;
	}

	public int get_subTinyWeaponDamagePer() {
		return _subTinyWeaponDamagePer;
	}

	public void set_subTinyWeaponDamagePer(int _subTinyWeaponDamagePer) {
		this._subTinyWeaponDamagePer = _subTinyWeaponDamagePer;
	}
	public void add_subTinyWeaponDamagePer(int n){
		this._subTinyWeaponDamagePer += n;
	}

	public int get_addMidWeaponDamage() {
		return _addMidWeaponDamage;
	}

	public void set_addMidWeaponDamage(int _addMidWeaponDamage) {
		this._addMidWeaponDamage = _addMidWeaponDamage;
	}

	public int get_addMidWeaponDamagePer() {
		return _addMidWeaponDamagePer;
	}

	public void set_addMidWeaponDamagePer(int _addMidWeaponDamagePer) {
		this._addMidWeaponDamagePer = _addMidWeaponDamagePer;
	}
	public void add_addMidWeaponDamagePer(int n){
		this._addMidWeaponDamagePer += n;
	}

	public int get_subMidWeaponDamage() {
		return _subMidWeaponDamage;
	}

	public void set_subMidWeaponDamage(int _subMidWeaponDamage) {
		this._subMidWeaponDamage = _subMidWeaponDamage;
	}
	public void add_subMinWeaponDamage(int n){
		this._subMidWeaponDamage += n;
	}

	public int get_subMidWeaponDamagePer() {
		return _subMidWeaponDamagePer;
	}

	public void set_subMidWeaponDamagePer(int _subMidWeaponDamagePer) {
		this._subMidWeaponDamagePer = _subMidWeaponDamagePer;
	}
	public void add_subMidWeaponDamagePer(int n){
		this._subMidWeaponDamagePer += n;
	}

	public int get_addLargeWeaponDamage() {
		return _addLargeWeaponDamage;
	}

	public void set_addLargeWeaponDamage(int _addLargeWeaponDamage) {
		this._addLargeWeaponDamage = _addLargeWeaponDamage;
	}
	public void add_addLargeWeaponDamage(int n){
		this._addLargeWeaponDamage += n;
	}

	public int get_addLargeWeaponDamagePer() {
		return _addLargeWeaponDamagePer;
	}

	public void set_addLargeWeaponDamagePer(int _addLargeWeaponDamagePer) {
		this._addLargeWeaponDamagePer = _addLargeWeaponDamagePer;
	}
	public void add_addLargeWeaponDamagePer(int n){
		this._addLargeWeaponDamagePer += n;
	}

	public int get_subLargeWeaponDamage() {
		return _subLargeWeaponDamage;
	}

	public void set_subLargeWeaponDamage(int _subLargeWeaponDamage) {
		this._subLargeWeaponDamage = _subLargeWeaponDamage;
	}
	public void add_subLargeWeaponDamage(int n){
		this._subLargeWeaponDamage += n;
	}

	public int get_subLargeWeaponDamagePer() {
		return _subLargeWeaponDamagePer;
	}

	public void set_subLargeWeaponDamagePer(int _subLargeWeaponDamagePer) {
		this._subLargeWeaponDamagePer = _subLargeWeaponDamagePer;
	}
	public void add_subLargeWeaponDamagePer(int n){
		this._subLargeWeaponDamagePer += n;
	}


	public int get_doubleHit() {
		return _doubleHit;
	}
	public void set_doubleHit(int _doubleHit) {
		this._doubleHit = _doubleHit;
	}
	public void add_doubleHit(int value){
		this._doubleHit += value;
	}
	

	public void tell(){
		System.out.println("最终三围:" + this.get_final_power() + "," + this.get_final_minjie() + "," + this.get_final_speed());
	}
}
