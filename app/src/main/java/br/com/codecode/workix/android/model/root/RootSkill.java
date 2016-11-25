package br.com.codecode.workix.android.model.root;

/**
 * Root Abstract Class Skill<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #skillName}</li>
 * </ul>
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
public abstract class RootSkill {

    private String skillName;

    /**
     * Public Empty Default Constructor
     */
    public RootSkill() {
    }

    /**
     * @return the Skill Name
     */
    public String getSkillName() {
        return skillName;
    }

    /**
     * @param skillName the Skill Name to set
     */
    public final void setSkillName(String skillName) {
        this.skillName = skillName;
    }

}
