package br.com.codecode.workix.android.model.jpa;

import java.io.Serializable;
import java.util.Calendar;

import br.com.codecode.workix.android.model.interfaces.Buildable;
import br.com.codecode.workix.android.model.root.RootExperience;

/**
 * Experience JPA
 *
 * @author felipe
 * @version 1.0
 * @see Serializable
 * @since 1.0
 */
class Experience implements Serializable {

    private static final long serialVersionUID = -6311235469498858665L;

    private String employerName;

    private String jobTitle;

    private Calendar startDate;

    private Calendar endDate;

    private String description;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Experience() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Experience
     * @see Buildable
     */
    public Experience(Builder builder) {

        this.employerName = builder.getEmployerName();

        this.jobTitle = builder.getJobTitle();

        this.startDate = builder.getStartDate();

        this.endDate = builder.getEndDate();

    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Experience [employerName=" + employerName + ", jobTitle=" + jobTitle + ", description=" + description + "]";
    }

    /**
     * Builder NestedClass for {@link Experience}
     *
     * @author felipe
     * @version 1.0
     * @see Buildable
     * @see RootExperience
     * @since 1.0
     */
    public final static class Builder extends RootExperience implements Buildable<Experience> {

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * Constructor with Required Fields
         *
         * @param employerName Employer Name
         * @param jobTitle     Job Title
         */
        public Builder(String employerName, String jobTitle) {
            this();
            this.setEmployerName(employerName);
            this.setJobTitle(jobTitle);
        }

        /**
         * Constructor with All Fields
         *
         * @param employerName Employer Name
         * @param jobTitle     Job Title
         * @param startDate    Start Date
         * @param endDate      End Date
         */
        public Builder(String employerName, String jobTitle, Calendar startDate, Calendar endDate) {
            this(employerName, jobTitle);
            this.setStartDate(startDate);
            this.setEndDate(endDate);
        }

        /**
         * @param employerName the employerName to set
         * @return Builder
         */
        public Builder withEmployerName(String employerName) {
            this.setEmployerName(employerName);
            return this;
        }


        /**
         * @param jobTitle the jobTitle to set
         * @return Builder
         */
        public Builder withJobTitle(String jobTitle) {
            this.setJobTitle(jobTitle);
            return this;
        }

        /**
         * @param startDate the startDate to set
         * @return Builder
         */
        public Builder withStartDate(Calendar startDate) {
            this.setStartDate(startDate);
            return this;
        }


        /**
         * @param endDate the endDate to set
         * @return Builder
         */
        public Builder withEndDate(Calendar endDate) {
            this.setEndDate(endDate);
            return this;
        }

        /**
         * @param description the description to set
         * @return Builder
         */
        public Builder withDescription(String description) {
            this.setDescription(description);
            return this;
        }

        /**
         * @return Return a new Experience
         */
        @Override
        public Experience build() {

            return new Experience(this);
        }

    }

}
