package br.com.codecode.workix.core.models.compat;

/**
 * Subscriber Class for Compatibility
 * <br>Without Annotations
 * 
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see MyEntity
 */
public class Subscriber extends MyEntity {

    private static final long serialVersionUID = 1L;

    private String email;

    private long id;

    /**
     * Public Default Constructor
     */
    public Subscriber(){}    

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    public long getId() {
	return this.id;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    public void setId(long id) {
	this.id = id;
    }    

}
