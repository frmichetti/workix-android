package br.com.codecode.workix.android.model.jpa;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.codecode.workix.android.model.enums.JobCategory;
import br.com.codecode.workix.android.model.enums.JobType;
import br.com.codecode.workix.android.model.pojo.Company;


/**
 * Job JPA
 *
 * @author felipe
 * @version 1.0
 * @see MyEntity
 * @since 1.0
 */
class Job extends MyEntity {

    private static final long serialVersionUID = 2246753300384053586L;

    private String title;

    private BigDecimal minPayment;

    private BigDecimal maxPayment;

    private String description;

    private String requirement;

    private String benefits;

    private Calendar start;

    private Calendar expire;

    private JobType type;

    private JobCategory category;

    private boolean active;

    /**
     * Many {@link Job} To One {@link Company}
     */
    private Company employeer;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Job() {
    }

    /**
     * Initialize Fields for CDI Injection
     */
    private void init() {
        minPayment = BigDecimal.ZERO;
        maxPayment = BigDecimal.ZERO;
        active = true;
        start = Calendar.getInstance();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(BigDecimal minPayment) {
        this.minPayment = minPayment;
    }

    public BigDecimal getMaxPayment() {
        return maxPayment;
    }

    public void setMaxPayment(BigDecimal maxPayment) {
        this.maxPayment = maxPayment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String resume) {
        this.description = resume;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getExpire() {
        return expire;
    }

    public void setExpire(Calendar expire) {
        this.expire = expire;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public JobCategory getCategory() {
        return category;
    }

    public void setCategory(JobCategory category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Company getEmployeer() {
        return employeer;
    }

    public void setEmployeer(Company employeer) {
        this.employeer = employeer;
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
        Job other = (Job) obj;
        return getId() == other.getId();
    }

    @Override
    public String toString() {
        return "Job [title=" + title + ", description=" + description + ", employeer=" + employeer + "]";
    }


}
