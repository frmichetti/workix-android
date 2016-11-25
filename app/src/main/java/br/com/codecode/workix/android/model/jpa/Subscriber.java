package br.com.codecode.workix.android.model.jpa;

import java.io.Serializable;

import br.com.codecode.workix.android.model.interfaces.Buildable;
import br.com.codecode.workix.android.model.interfaces.Persistable;
import br.com.codecode.workix.android.model.root.RootSubscriber;

/**
 * Subscriber JPA
 *
 * @author felipe
 * @version 1.0
 * @see RootSubscriber
 * @see Persistable
 * @see Serializable
 * @since 1.0
 */
class Subscriber extends RootSubscriber implements Persistable, Serializable {

    private static final long serialVersionUID = 6675137603968146834L;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Subscriber() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate New Subscriber
     * @see Buildable
     */
    public Subscriber(Builder builder) {

        this.setId(builder.getId());

        this.setEmail(builder.getEmail());
    }

    /**
     * @return the id
     */
    @Override
    public long getId() {
        return super.getId();
    }

    public String getEmail() {
        return super.getEmail();
    }

    /**
     * Builder NestedClass for Subscriber
     *
     * @author felipe
     * @version 1.0
     * @see Buildable
     * @see RootSubscriber
     * @since 1.0
     */
    public final static class Builder extends RootSubscriber implements Buildable<Subscriber> {

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * Constructor with Required Fields
         *
         * @param email Email
         */
        public Builder(String email) {
            this();
            this.setEmail(email);
        }

        /**
         * Constructor with All Fields
         *
         * @param id    Id
         * @param email Email
         */
        public Builder(long id, String email) {
            super();
            this.setId(id);
            this.setEmail(email);
        }

        /**
         * @param email the email to set
         * @return Builder
         */
        public Builder withEmail(String email) {
            this.setEmail(email);
            return this;
        }

        /**
         * @param id the id to set
         * @return Builder
         */
        public Builder withId(long id) {
            this.setId(id);
            return this;
        }

        /**
         * @return A new Subscriber
         */
        @Override
        public Subscriber build() {

            return new Subscriber(this);
        }

    }

}
