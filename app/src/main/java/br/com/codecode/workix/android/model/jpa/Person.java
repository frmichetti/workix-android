package br.com.codecode.workix.android.model.jpa;

import br.com.codecode.workix.android.model.base.BaseContact;
import br.com.codecode.workix.android.model.base.BaseLocale;
import br.com.codecode.workix.android.model.base.BasePerson;
import br.com.codecode.workix.android.model.base.BaseUser;

/**
 * Person JPA
 * <br>Abstract Class for share common Fields with {@link Company} and {@link Candidate}
 *
 * @author felipe
 * @see MyEntity
 * @see BasePerson
 * <a href= "http://wiki.fasterxml.com/JacksonFAQ#Deserializing_Abstract_types">Deserializing Abstract Types</a>
 */
abstract class Person extends MyEntity implements BasePerson {

    private static final long serialVersionUID = 703693002246144451L;

    private String name;

    private User user;

    private Contact contact;

    private Locale locale;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Person() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Contact getContact() {
        return contact;
    }

    @Override
    public void setContact(BaseContact contact) {
        this.contact = (Contact) contact;

    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(BaseUser user) {
        this.user = (User) user;

    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public void setLocale(BaseLocale locale) {
        this.locale = (Locale) locale;

    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }

}
