package br.com.codecode.workix.android.model.base;

/**
 * Markup Interface for Person Implementation
 *
 * @author felipe
 */
public interface BasePerson extends BaseEntity {

    String getName();

    void setName(String name);

    BaseContact getContact();

    void setContact(BaseContact contact);

    BaseUser getUser();

    void setUser(BaseUser user);

    BaseLocale getLocale();

    void setLocale(BaseLocale locale);

}
