package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;

/**
 * Skill Class for Compatibility
 * <br>Without Annotations
 * 
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skillName;

    /**
     * Public Default Constructor
     */
    public Skill(){}    

    /**
     * @return the Skill Name
     */
    public final String getSkillName() {
	return this.skillName;
    }

    /**
     * @param skillName
     *            the Skill Name to set
     */
    public final void setSkillName(String skillName) {
	this.skillName = skillName;
    }   

}
