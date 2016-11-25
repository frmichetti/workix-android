package br.com.codecode.workix.android.model.jpa;

import java.io.Serializable;

import br.com.codecode.workix.android.model.base.BaseLocale;
import br.com.codecode.workix.android.model.enums.Estate;
import br.com.codecode.workix.android.model.interfaces.Buildable;
import br.com.codecode.workix.android.model.root.RootLocale;

/**
 * Locale JPA {Embeddable}
 *
 * @author felipe
 * @see BaseLocale
 * @see Serializable
 */
class Locale implements BaseLocale, Serializable {

    private static final long serialVersionUID = -607806075186010186L;

    private long zipCode;

    private String city;

    private String neighborhood;

    private String street;

    private String number;

    private Estate estate;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Locale() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Locale
     * @see Buildable
     */
    public Locale(Builder builder) {

        this.zipCode = builder.getZipCode();

        this.city = builder.getCity();

        this.neighborhood = builder.getNeighborhood();

        this.street = builder.getStreet();

        this.number = builder.getNumber();

        this.estate = builder.getEstate();
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    @Override
    public String toString() {
        return "Locale [zipCode=" + zipCode + ", street=" + street + ", number=" + number + "]";
    }

    /**
     * Builder NestedClass for {@link Locale}
     *
     * @author felipe
     * @see Buildable
     * @see RootLocale
     */
    public static class Builder extends RootLocale implements Buildable<Locale> {

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * Constructor with Required Fields
         *
         * @param zipCode Zip Code
         * @param number  Number of House
         */
        public Builder(long zipCode, String number) {
            this();
            this.setZipCode(zipCode);
            this.setNumber(number);
        }

        /**
         * Constructor with All Fields
         *
         * @param zipCode      Zip Code
         * @param estate       estate
         * @param city         City
         * @param neighborhood Neighborhood
         * @param street       Street
         * @param number       Number of House
         */
        public Builder(long zipCode, Estate estate, String city, String neighborhood, String street, String number) {
            this(zipCode, number);
            this.setEstate(estate);
            this.setStreet(street);
            this.setNeighborhood(neighborhood);
            this.setCity(city);
        }

        public Builder withEstate(Estate estate) {
            this.setEstate(estate);
            return this;
        }

        public Builder withNumber(String number) {
            this.setNumber(number);
            return this;
        }

        public Builder withStreet(String street) {
            this.setStreet(street);
            return this;
        }

        public Builder withNeighborhood(String neighborhood) {
            this.setNeighborhood(neighborhood);
            return this;
        }

        public Builder withCity(String city) {
            this.setCity(city);
            return this;
        }

        public Builder withZipCode(long zipCode) {
            this.setZipCode(zipCode);
            return this;
        }

        /**
         * @return Return a New Locale
         */
        @Override
        public Locale build() {
            return new Locale(this);
        }

    }

}
