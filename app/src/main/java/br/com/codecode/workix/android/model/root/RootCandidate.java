package br.com.codecode.workix.android.model.root;

import java.util.Calendar;

/**
 * Root Abstract Class Candidate<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cpf}</li>
 * <li>{@link #birthDate}</li>
 * </ul>
 *
 * @author felipe
 * @version 1.0
 * @see RootPerson
 * @since 1.0
 */
public abstract class RootCandidate extends RootPerson {

    private long cpf;

    private Calendar birthDate;

    /**
     * Empty Default Construtor
     */
    public RootCandidate() {
    }

    /**
     * @return the cpf
     */
    public final long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public final void setCpf(long cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the birthDate
     */
    public final Calendar getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public final void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }


}
