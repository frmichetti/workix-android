package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.util.Calendar;

import br.com.codecode.workix.core.interfaces.Buildable;

/**
 * Education JPA Embeddable
 * No Anotation for Compatibility Only with Older Versions
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Serializable
 */
public class Education implements Serializable {

    private static final long serialVersionUID = -1514012744160609145L;

    private String description;

    private Calendar endDate;

    private String qualification;

    private String schoolName;

    private Calendar startDate;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Education(){}

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a new Education
     */
    public Education(Builder builder) {
	this.schoolName = builder.getSchoolName();
	this.startDate = builder.getStartDate();
	this.endDate = builder.getEndDate();
	this.qualification = builder.getQualification();
	this.description = builder.getDescription();
    }

    /**
     * Creates builder to build {@link Experience}.
     * @return created builder
     */    
    public static Builder builder() {
	return new Builder();
    }

    public String getDescription() {
	return description;
    }
    
    public Calendar getEndDate() {
	return endDate;
    }

    public String getQualification() {
	return qualification;
    }

    public String getSchoolName() {
	return schoolName;
    }
    
    public Calendar getStartDate() {
	return startDate;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setEndDate(Calendar endDate) {
	this.endDate = endDate;
    }

    public void setQualification(String qualification) {
	this.qualification = qualification;
    }

    public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
    }

    public void setStartDate(Calendar startDate) {
	this.startDate = startDate;
    }

    /**
     * Builder NestedClass for {@link Education}
     * @see Education
     * @see Buildable
     * @author felipe
     * @since 1.0
     * @version 1.0
     */
    public static class Builder extends Education implements Buildable<Education> {

	private static final long serialVersionUID = 3075237483868037001L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}

	/**
	 * @return Return a new Education
	 */
	@Override
	public Education build() {
	    return new Education(this);
	}

	/**
	 * @param description
	 *            the description to set
	 * @return Builder
	 */
	public Builder withDescription(String description) {
	    this.setDescription(description);
	    return this;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 * @return Builder
	 */
	public Builder withEndDate(Calendar endDate) {
	    this.setEndDate(endDate);
	    return this;
	}

	/**
	 * @param qualification
	 *            the qualification to set
	 * @return Builder
	 */
	public Builder withQualification(String qualification) {
	    this.setQualification(qualification);
	    return this;
	}

	/**
	 * @param schoolName
	 *            the schoolName to set
	 * @return Builder
	 */
	public Builder withSchoolName(String schoolName) {
	    this.setSchoolName(schoolName);
	    return this;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 * @return Builder
	 */
	public Builder withStartDate(Calendar startDate) {
	    this.setStartDate(startDate);
	    return this;
	}

    }

}
