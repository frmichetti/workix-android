package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;

import br.com.codecode.workix.core.enums.Estate;

/**
 * Locale Class for Compatibility<br>
 * Without Annotations
 * 
 * @author felipe
 * @see Serializable
 * @since 1.1
 * @version 1.1
 */
public class Locale implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;

    private Estate estate;

    private String neighborhood;

    private String number;

    private String street;

    private long zipCode;

    /**
     * Public Default Constructor
     */
    public Locale(){}    

    public String getCity() {
	return city;
    }

    public Estate getEstate() {
	return estate;
    }

    public String getNeighborhood() {
	return neighborhood;
    }

    public String getNumber() {
	return number;
    }

    public String getStreet() {
	return street;
    }

    public long getZipCode() {
	return zipCode;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public void setEstate(Estate estate) {
	this.estate = estate;
    }

    public void setNeighborhood(String neighborhood) {
	this.neighborhood = neighborhood;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public void setZipCode(long zipCode) {
	this.zipCode = zipCode;
    }    

}
