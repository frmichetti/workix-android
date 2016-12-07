package br.com.codecode.workix.core.models.compat;

import java.util.Calendar;

/**
 * Candidate Class for Compatibility
 * <br>Without Annotations
 * @author felipe
 * @see Person
 * @since 1.1
 * @version 1.1
 */
public class Candidate extends Person {

    private static final long serialVersionUID = 1L;

    private Calendar birthDate;

    private long id, cpf;

    /**
     * Public Default Constructor
     */
    public Candidate() {
    }

    public Calendar getBirthDate() {
	return birthDate;
    }

    public long getCpf() {
	return cpf;
    }

    public long getId() {
	return this.id;
    }

    /**
     * Initialize Fields
     */
    protected void init() {
	birthDate = Calendar.getInstance();
    }

    public void setBirthDate(Calendar birthDate) {
	this.birthDate = birthDate;
    }

    public void setCpf(long cpf) {
	this.cpf = cpf;
    }

    public void setId(long id) {
	this.id = id;
    }

}