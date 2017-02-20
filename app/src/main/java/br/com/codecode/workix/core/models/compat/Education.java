package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Education Class for Compatibility
 * <br>Without Annotations 
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;

    private String description;

    private Calendar endDate;

    private String qualification;

    private String schoolName;

    private Calendar startDate;

    /**
     * Public Default Constructor
     */
    public Education(){}
    
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
}
