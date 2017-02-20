package br.com.codecode.workix.core.models.compat;

import java.util.HashSet;
import java.util.Set;

/**
 * Resume Class for Compatibility
 * <br>Without Annotations
 * 
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see MyEntity
 */
public class Resume extends MyEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Owner of Resume<br>
     * One {@link Resume} To One {@link Candidate}
     */
    private Candidate candidate;

    /**
     * One {@link Resume} To Many {@link Education}
     */

    private Set<Education> educations;

    /**
     * One {@link Resume} To Many {@link Experience}
     */
    private Set<Experience> experiences;

    private long id;

    private String objective, content;

    /**
     * One {@link Resume} To Many {@link Skill}
     */
    private Set<Skill> skills;

    /**
     * Public Default Constructor
     */
    public Resume(){}

    public void addEducation(Education education) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations.add(education);
    }

    public void addExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.add(experience);
    }

    public void addSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.add(skill);

    }

    public Candidate getCandidate() {
	return candidate;
    }

    public String getContent() {
	return content;
    }

    public Set<Education> getEducations() {
	return educations;
    }

    public Set<Experience> getExperiences() {
	return experiences;
    }

    public long getId() {
	return this.id;
    }

    public String getObjective() {
	return objective;
    }

    public Set<Skill> getSkills() {
	return skills;
    }

    /**
     * Initialize Fields
     */
    protected void init() {
	educations = new HashSet<Education>();
	experiences = new HashSet<Experience>();
	skills = new HashSet<Skill>();
    }

    public void removeEducation(Education education) {
	this.educations.remove(education);
    }

    public void removeExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.remove(experience);
    }

    public void removeSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.remove(skill);
    }

    public void setCandidate(Candidate candidate) {
	this.candidate = candidate;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public void setEducations(Set<Education> educations) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations = educations;
    }

    public void setExperiences(Set<Experience> experiences) {
	this.experiences = experiences;
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setObjective(String objective) {
	this.objective = objective;
    }

    public void setSkills(Set<Skill> skills) {
	this.skills = skills;
    }

}