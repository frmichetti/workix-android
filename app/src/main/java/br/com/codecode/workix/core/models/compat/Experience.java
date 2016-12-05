package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Experience Class for Compatibility
 * <br>Without Annotations
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
public class Experience implements Serializable {

    private static final long serialVersionUID = 1L;

    private String description;

    private String employerName;

    private Calendar endDate;

    private String jobTitle;

    private Calendar startDate;

    /**
     * Public Default Constructor
     */
    public Experience(){}   

    public String getDescription() {
	return description;
    }

    public String getEmployerName() {
	return employerName;
    }

    public Calendar getEndDate() {
	return endDate;
    }

    public String getJobTitle() {
	return jobTitle;
    }

    public Calendar getStartDate() {
	return startDate;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setEmployerName(String employerName) {
	this.employerName = employerName;
    }

    public void setEndDate(Calendar endDate) {
	this.endDate = endDate;
    }

    public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
    }

    public void setStartDate(Calendar startDate) {
	this.startDate = startDate;
    }    

}
