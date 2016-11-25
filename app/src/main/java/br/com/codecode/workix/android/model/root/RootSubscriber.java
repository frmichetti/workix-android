package br.com.codecode.workix.android.model.root;

/**
 * Root Abstract Class Subscriber<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #id}</li>
 * <li>{@link #email}</li>
 * </ul>
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
public abstract class RootSubscriber {

    private long id;

    private String email;

    /**
     * Public Empty Default Constructor
     */
    public RootSubscriber() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public final void setId(long id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public final void setEmail(String email) {
        this.email = email;
    }

}
