package br.com.codecode.workix.android.model.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import br.com.codecode.workix.android.model.base.BaseEntity;
import br.com.codecode.workix.android.model.interfaces.Persistable;
import br.com.codecode.workix.android.model.interfaces.Traceable;


/**
 * MyEntity JPA
 * <br>Base abstract Class for Share common Fields
 * <br>All inherited classes MUST contain<br>
 * <table>
 * <caption> Inherited Fields </caption>
 * <tr>
 * <th>{@link #id}</th>
 * <th>{@link #version}</th>
 * <th>{@link #createdAt}</th>
 * <th>{@link #updatedAt}</th>
 * <th>{@link #uuid}</th>
 * </tr>
 * </table>
 *
 * @author felipe
 * @version 1.0
 * @see BaseEntity
 * @see Traceable
 * @see Persistable
 * @see Serializable
 * @since 1.0
 */
abstract class MyEntity implements BaseEntity, Traceable, Persistable, Serializable {

    private static final long serialVersionUID = -5791260209364116790L;

    private long id;

    private int version;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String uuid;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public MyEntity() {
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void prepareToPersist() {
    }

    @Override
    public void generateUUID() {
        this.setUuid(UUID.randomUUID().toString());
    }

    @Override
    public void insertTimeStamp() {
    }

    @Override
    public void updateTimeStamp() {
    }

    protected int getVersion() {
        return version;
    }

    protected void setVersion(int version) {
        this.version = version;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    private void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    private void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUuid() {
        return uuid;
    }

    private void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
