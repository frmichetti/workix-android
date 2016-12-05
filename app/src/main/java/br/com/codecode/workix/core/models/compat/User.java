package br.com.codecode.workix.core.models.compat;

/**
 * User Class for Compatibility
 * <br>Without Annotations 
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see MyEntity
 */
public class User extends MyEntity {

    private static final long serialVersionUID = 1L;

    private boolean active;

    private String email, firebaseUUID, firebaseMessageToken;

    private long id;

    /**
     * Public Default Constructor
     */
    public User(){}   

    public String getEmail() {
	return email;
    }

    public String getFirebaseMessageToken() {
	return firebaseMessageToken;
    }

    public String getFirebaseUUID() {
	return firebaseUUID;
    }

    public long getId() {
	return this.id;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setFirebaseMessageToken(String firebaseMessageToken) {
	this.firebaseMessageToken = firebaseMessageToken;
    }

    public void setFirebaseUUID(String firebaseUUID) {
	this.firebaseUUID = firebaseUUID;
    }

    public void setId(long id) {
	this.id = id;
    }    
}