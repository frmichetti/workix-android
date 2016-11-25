package br.com.codecode.workix.android.model.base;

import java.util.Calendar;

/**
 * Markup Interface for Experience Implementation
 *
 * @author felipe
 */
public interface BaseExperience {

    String getEmployerName();

    void setEmployerName(String employerName);

    String getJobTitle();

    void setJobTitle(String jobTitle);

    Calendar getStartDate();

    void setStartDate(Calendar startDate);

    Calendar getEndDate();

    void setEndDate(Calendar endDate);

    String getDescription();

    void setDescription(String description);
}
