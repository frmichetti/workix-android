package br.com.codecode.workix.android.model.jpa;

import java.util.Calendar;

import br.com.codecode.workix.android.model.base.BaseCandidate;


/**
 * Candidate JPA
 *
 * @author felipe
 * @see Person
 * @see Person
 * @see BaseCandidate
 */
class Candidate extends Person implements BaseCandidate {

    private static final long serialVersionUID = 531807027259604477L;

    private long cpf;

    private Calendar birthDate;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Candidate() {
    }

    /**
     * Initialize Fields for CDI Injection
     */
    private void init() {
        birthDate = Calendar.getInstance();
    }

    @Override
    public long getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public Calendar getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (getId() ^ (getId() >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Candidate other = (Candidate) obj;
        return getId() == other.getId();
    }


}
