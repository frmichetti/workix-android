package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;

/**
 * Contact Class for Compatibility
 * <br>Without Annotations 
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    private long mobilePhone;

    /**
     * Public Default Constructor
     */
    public Contact(){}    

    /**
     * @return the Mobile Phone
     */
    public long getMobilePhone() {
	return mobilePhone;
    }

    /**
     * @param mobilePhone
     *            the Mobile Phone to set
     */
    public final void setMobilePhone(long mobilePhone) {
	this.mobilePhone = mobilePhone;
    }    
}
