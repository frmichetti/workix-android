package br.com.codecode.workix.android.model.jpa;

import java.io.Serializable;

import br.com.codecode.workix.android.model.base.BaseContact;
import br.com.codecode.workix.android.model.interfaces.Buildable;
import br.com.codecode.workix.android.model.root.RootContact;


/**
 * Contact JPA
 *
 * @author felipe
 * @version 1.0
 * @see BaseContact
 * @see Serializable
 * @since 1.0
 */
class Contact implements BaseContact, Serializable {

    private static final long serialVersionUID = -2482737185460142872L;

    private long mobilePhone;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Contact() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Contact
     * @see Buildable
     */
    public Contact(Builder builder) {
        this.mobilePhone = builder.getMobilePhone();
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

    /**
     * Builder NestedClass for {@link Contact}
     *
     * @author felipe
     * @version 1.0
     * @see Buildable
     * @see RootContact
     * @since 1.0
     */
    public final static class Builder extends RootContact implements Buildable<Contact> {

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * Constructor with Required Fields
         *
         * @param mobilePhone Mobile Phone
         */
        public Builder(long mobilePhone) {
            this();
            this.setMobilePhone(mobilePhone);
        }

        /**
         * @param mobilePhone the Mobile Phone to set
         * @return Builder
         */
        public Builder withMobilePhone(long mobilePhone) {
            this.setMobilePhone(mobilePhone);
            return this;
        }

        /**
         * @return A new Contact
         */
        @Override
        public Contact build() {
            return new Contact(this);
        }

    }


}
