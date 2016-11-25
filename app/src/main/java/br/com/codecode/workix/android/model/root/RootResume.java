package br.com.codecode.workix.android.model.root;

import java.util.Set;

import br.com.codecode.workix.android.model.base.BaseCandidate;
import br.com.codecode.workix.android.model.base.BaseEducation;
import br.com.codecode.workix.android.model.base.BaseExperience;
import br.com.codecode.workix.android.model.base.BaseSkill;

/**
 * Root Abstract Class Resume<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #candidate}</li>
 * <li>{@link #objective}</li>
 * <li>{@link #content}</li>
 * <li>{@link #experiences}</li>
 * <li>{@link #educations}</li>
 * <li>{@link #skills}</li>
 * </ul>
 *
 * @author felipe
 * @version 1.0
 * @see RootEntity
 * @since 1.0
 */
public abstract class RootResume {

    /**
     * One {Resume} To Many {Experience}
     */
    protected Set<BaseExperience> experiences;
    /**
     * One {Resume} To Many {Education}
     */
    protected Set<BaseEducation> educations;
    /**
     * One {Resume} To Many {Skill}
     */
    protected Set<BaseSkill> skills;
    /**
     * Owner of Resume<br>
     * One {Resume} To One {Candidate}
     */
    private BaseCandidate candidate;
    private String objective;
    private String content;

    /**
     * Default Empty Constructor
     */
    public RootResume() {
    }

    /**
     * @return the candidate
     */
    public final BaseCandidate getCandidate() {
        return candidate;
    }

    /**
     * @param candidate the candidate to set
     */
    public final void setCandidate(BaseCandidate candidate) {
        this.candidate = candidate;
    }

    /**
     * @return the objective
     */
    public final String getObjective() {
        return objective;
    }

    /**
     * @param objective the objective to set
     */
    public final void setObjective(String objective) {
        this.objective = objective;
    }

    /**
     * @return the content
     */
    public final String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public abstract void setContent(String content);

    /**
     * @return the experiences
     */
    public abstract Set<BaseExperience> getExperiences();

    /**
     * @param experiences the experiences to set
     */
    public abstract void setExperiences(Set<BaseExperience> experiences);

    /**
     * @return the educations
     */
    public abstract Set<BaseEducation> getEducations();

    /**
     * @param educations the educations to set
     */
    public abstract void setEducations(Set<BaseEducation> educations);

    /**
     * @return the skills
     */
    public abstract Set<BaseSkill> getSkills();

    /**
     * @param skills the skills to set
     */
    public abstract void setSkills(Set<BaseSkill> skills);


}
