package game;
/*
 * 属性类
 * */
public class Attr {
	int _base_hp; //基础生命值
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
	
	
	// 计算
	
	public void tell(){
		System.out.println("最终三围:" + this.get_final_power() + "," + this.get_final_minjie() + "," + this.get_final_speed());
	}
}
