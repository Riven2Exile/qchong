package game;

import java.util.HashMap;
import java.util.Map.Entry;

import game.skill.BaseSkill;

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
	
	public void ClearSkill() {
		_skillMap.clear();
	}
	
	
	public void ReCaclAttr(Player p) {
		for (Entry<Integer, BaseSkill> entry : _skillMap.entrySet()){
			entry.getValue().CalcAttr(p);
		}
	}
}
