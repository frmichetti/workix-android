package br.com.codecode.workix.android.model.interfaces;

/**
 * Markup Interface for Traceable Entities
 *
 * @author felipe
 */
public interface Traceable {

    /**
     * Must Be Called on JPA Event
     */
    void prepareToPersist();

    /**
     * Insert TIme Stamp
     */
    void insertTimeStamp();

    /**
     * Generate UUID
     */
    void generateUUID();

    /**
     * Must be Called on JPA Event
     */
    void updateTimeStamp();

}
