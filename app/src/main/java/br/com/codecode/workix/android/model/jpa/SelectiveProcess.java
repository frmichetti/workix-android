package br.com.codecode.workix.android.model.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

import br.com.codecode.workix.android.model.interfaces.Persistable;
import br.com.codecode.workix.android.model.interfaces.Traceable;
import br.com.codecode.workix.android.model.pojo.Candidate;
import br.com.codecode.workix.android.model.pojo.Job;


/**
 * Selective Process JPA
 *
 * @author felipe
 * @version 1.0
 * @see Observable
 * @see Observer
 * @see Traceable
 * @see Persistable
 * @see Serializable
 * @since 1.0
 */
class SelectiveProcess extends Observable implements Observer, Traceable, Persistable, Serializable {

    private static final long serialVersionUID = -5336099006523168288L;

    private long id;

    private int version;

    private String uuid;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Job job;

    private Set<Candidate> candidates;

    private boolean active;

    private Timestamp disabledAt;

    private int maxCandidates;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public SelectiveProcess() {
    }

    private void init() {
        this.addObserver(this);
        active = true;
        candidates = new HashSet<>();
    }

    @Override
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    protected int getVersion() {
        return this.version;
    }

    protected void setVersion(final int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        SelectiveProcess other = (SelectiveProcess) obj;
        return id == other.id;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(final Job job) {
        this.job = job;
    }

    public Set<Candidate> getCandidates() {
        return this.candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
        notifyChanges();
    }

    public boolean isActive() {
        return active;
    }

    protected void setActive(boolean active) {

        if (!active) {
            //TODO FIXME
        }

        this.active = active;

        notifyChanges();
    }

    public int getMaxCandidates() {
        return maxCandidates;
    }

    public void setMaxCandidates(int maxCandidates) {
        this.maxCandidates = maxCandidates;
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

    private void countCandidates(Set<Candidate> collection) {
        maxCandidates = collection.size();
    }

    public int countCandidates() {
        return maxCandidates - candidates.size();
    }

    public boolean registerCandidate(Candidate candidate) {

        boolean b = false;

        if ((isActive()) && (isElegible()) && (!isInProcess(candidate))) {

            candidates.add(candidate);

            System.out.println(candidate.getName() + " Registered with Success");

            b = true;

        } else {

            System.out.println(candidate.getName() + " Cannot Registered");

            b = false;
        }

        notifyChanges(candidates);

        return b;

    }

    private void notifyChanges() {
        notifyObservers();
        setChanged();
    }

    private void notifyChanges(Object object) {
        notifyObservers(object);
        setChanged();
    }

    @Override
    public String toString() {
        return "SelectiveProcess [active=" + active + ", maxCandidates=" + maxCandidates + "]";
    }

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

    @Override
    public void prepareToPersist() {
    }

    @Override
    public void generateUUID() {
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public void insertTimeStamp() {
    }

    @Override
    public void updateTimeStamp() {
    }

}
