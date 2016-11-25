package br.com.codecode.workix.android.model.jpa;

import java.util.HashSet;
import java.util.Set;

/**
 * Resume JPA
 *
 * @author felipe
 * @see MyEntity
 */
class Resume extends MyEntity {

    private static final long serialVersionUID = 7569771700044121495L;

    /**
     * Owner of Resume<br>
     * One {@link Resume} To One {@link Candidate}
     */
    private Candidate candidate;

    private String objective;

    private String content;

    /**
     * One {@link Resume} To Many {@link Experience}
     */
    private Set<Experience> experiences;

    /**
     * One {@link Resume} To Many {@link Education}
     */
    private Set<Education> educations;

    /**
     * One {@link Resume} To Many {@link Skill}
     */
    private Set<Skill> skills;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Resume() {
    }

    private void init() {
        educations = new HashSet<Education>();
        experiences = new HashSet<Experience>();
        skills = new HashSet<Skill>();
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public void addExperience(Experience experience) {
        if (experiences == null)
            experiences = new HashSet<>();
        else
            this.experiences.add(experience);
    }

    public void removeExperience(Experience experience) {
        if (experiences == null)
            experiences = new HashSet<>();
        else
            this.experiences.remove(experience);
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        if (educations == null)
            educations = new HashSet<>();
        else
            this.educations = educations;
    }

    public void addEducation(Education education) {
        if (educations == null)
            educations = new HashSet<>();
        else
            this.educations.add(education);
    }

    public void removeEducation(Education education) {
        this.educations.remove(education);
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill) {
        if (skills == null)
            skills = new HashSet<>();
        else
            this.skills.add(skill);

    }

    public void removeSkill(Skill skill) {
        if (skills == null)
            skills = new HashSet<>();
        else
            this.skills.remove(skill);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (getId() ^ (getId() >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resume other = (Resume) obj;
        return getId() == other.getId();
    }

}
