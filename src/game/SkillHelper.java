package game;

import java.util.HashMap;
import java.util.Map.Entry;

import game.skill.BaseSkill;
import game.weapon.BaseWeapon;

public class SkillHelper {
	HashMap<Integer, BaseSkill> _skillMap = new HashMap<>();
	
	public boolean hasSkill(int skillID) {
		return _skillMap.get(skillID) != null;
	}
	
	public BaseSkill getSkill(int skillID) {
		return _skillMap.get(skillID);
	}
	
	public void addSkill(BaseSkill skill) {
		_skillMap.put(skill.getSkillID(), skill);
	}
	
	public void addAllSkill(HashMap<Integer, BaseSkill> data){
		_skillMap.putAll(data);
	}
	
	public void ClearSkill() {
		_skillMap.clear();
	}
	
	public <T extends ForeachInterface> void ForEach(T o)
	{
		for (Entry<Integer, BaseSkill> entry: _skillMap.entrySet() )
		{
			o.doFun(entry.getValue());
		}
	}
	
	
	public void ReCaclForeverAttr(Player p) {
		for (Entry<Integer, BaseSkill> entry : _skillMap.entrySet()){
			if(entry.getValue().getSkillType() == BaseSkill.SKILLTYPE_FOREVER){
				entry.getValue().CalcAttr(p);
			}
		}
		
		p.getAttr().CalcAddictionThree();
	}
}
