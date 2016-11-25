package br.com.codecode.workix.android.model.root;

/**
 * Root Abstract Class Contact<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #mobilePhone}</li>
 * </ul>
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
public abstract class RootContact {

    private long mobilePhone;

    /**
     * Public Empty Default Constructor
     */
    public RootContact() {
    }

    /**
     * @return the Mobile Phone
     */
    public long getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone the Mobile Phone to set
     */
    public final void setMobilePhone(long mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

}
