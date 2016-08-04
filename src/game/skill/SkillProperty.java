package game.skill;
/**
 *  技能属性
 */
public class SkillProperty {

	int _id = BaseSkill.UNDEFINE_SKILL;				//技能id
	int _skillType = BaseSkill.SKILLTYPE_UNDEFINE;	//技能类型
	
	boolean _bCertainHit 		= false;			//是否必中
	boolean _bIgnoreDesSubDamage = false;			//忽略对方的减伤属性
	
	public SkillProperty() {
		// TODO Auto-generated constructor stub
	}

}
