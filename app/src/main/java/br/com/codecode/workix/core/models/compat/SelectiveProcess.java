package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

/**
 * Selective Process Class for Compatibility
 * <br>Without Annotations
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Observable
 * @see Observer
 * @see Serializable
 */
public class SelectiveProcess extends Observable implements Observer, Serializable {

    private static final long serialVersionUID = 1L;

    private boolean active;

    private Set<Candidate> candidates;

    private Calendar createdAt;

    private Calendar disabledAt;

    private long id;

    private Job job;

    private int maxCandidates;

    private Calendar updatedAt;

    private String uuid;

    private int version;

    /**
     * Public Default Constructor
     */
    public SelectiveProcess(){}

    public int countCandidates() {
	return maxCandidates - candidates.size();
    }

    private void countCandidates(Set<Candidate> collection) {
	maxCandidates = collection.size();
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) {
	    return false;
	}
	if (!(obj instanceof SelectiveProcess)) {
	    return false;
	}
	SelectiveProcess other = (SelectiveProcess) obj;
	if (id != other.id) {
	    return false;
	}
	return true;
    }

    protected void generateUUID() {
	this.uuid = UUID.randomUUID().toString();
    }

    public Set<Candidate> getCandidates() {
	return this.candidates;
    }

    public Calendar getCreatedAt() {
	return createdAt;
    }

    public Calendar getDisabledAt() {
	return disabledAt;
    }

    public long getId() {
	return this.id;
    }

    public Job getJob() {
	return this.job;
    }

    public int getMaxCandidates() {
	return maxCandidates;
    }

    public Calendar getUpdatedAt() {
	return updatedAt;
    }

    public String getUuid() {
	return uuid;
    }

    public int getVersion() {
	return this.version;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
    }

    /**
     * Initialize Fields
     */    
    protected void init() {
	this.addObserver(this);
	this.active = true;
	this.candidates = new HashSet<>();
    }

    protected void insertTimeStamp() {
	this.createdAt = Calendar.getInstance();
    }

    public boolean isActive() {
	return active;
    }

    private boolean isElegible() {
	System.out.println("Process is Elegible " + (candidates.size() < maxCandidates));
	System.out.println("Candidates --> [" + candidates.size() + "/" + maxCandidates + "]");
	return (candidates.size() < maxCandidates);
    }

    public boolean isInProcess(Candidate candidate) {
	System.out.println(candidate.getName() + " are in this process ? " + (candidates.contains(candidate)));
	return (candidates.contains(candidate));
    }

    private void notifyChanges() {
	notifyObservers();
	setChanged();
    }

    private void notifyChanges(Object object) {
	notifyObservers(object);
	setChanged();
    }

    public boolean registerCandidate(Candidate candidate) {

	boolean b = false;

	if ((isActive()) && (isElegible()) && (!isInProcess(candidate))) {

	    this.candidates.add(candidate);

	    System.out.println(candidate.getName() + " Registered with Success");

	    b = true;

	} else {

	    System.out.println(candidate.getName() + " Cannot Registered");

	    b = false;
	}

	notifyChanges(candidates);

	return b;

    }

    protected void setActive(boolean active) {

	if (!active) {
	    this.disabledAt = Calendar.getInstance();
	}

	this.active = active;

	notifyChanges();
    }

    public void setCandidates(Set<Candidate> candidates) {
	this.candidates = candidates;
	notifyChanges();
    }

    protected void setCreatedAt(Calendar createdAt) {
	this.createdAt = createdAt;
    }

    protected void setDisabledAt(Calendar disabledAt) {
	this.disabledAt = disabledAt;
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setJob(final Job job) {
	this.job = job;
    }

    public void setMaxCandidates(int maxCandidates) {
	this.maxCandidates = maxCandidates;
    }

    protected void setUpdatedAt(Calendar updatedAt) {
	this.updatedAt = updatedAt;
    }

    protected void setUuid(String uuid) {
	this.uuid = uuid;
    }

    protected void setVersion(final int version) {
	this.version = version;
    }
    
    protected void updateTimeStamp() {
	this.updatedAt = Calendar.getInstance();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void update(Observable observable, Object object) {

	if (observable instanceof SelectiveProcess) {

	    if (active = isElegible()) {

		if (object instanceof Collection<?>) {

		    countCandidates((Set<Candidate>) object);

		}

	    } else {
		if (disabledAt != null)
		    System.out.println("Max candidates Reached - Disabled Process at " + disabledAt);
	    }

	}
    }

    

}