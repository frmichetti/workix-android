package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

/**
 * MyEntity Class for Compatibility
 * <br>Without Annotations<br>
 * Base abstract Class for Share common Fields <br>
 * All inherited classes MUST contain<br>
 * <table>
 * <caption> Inherited Fields </caption>
 * <tr>
 * <th>{@link #version}</th>
 * <th>{@link #createdAt}</th>
 * <th>{@link #updatedAt}</th>
 * <th>{@link #uuid}</th>
 * </tr>
 * </table>
 * 
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
abstract class MyEntity implements Serializable {

    private final static long serialVersionUID = 1L;

    private Calendar createdAt, updatedAt;

    private String uuid;

    private int version;

    /**
     * Public Default Constructor
     */
    public MyEntity(){}

    protected void generateUUID() {
	this.uuid = UUID.randomUUID().toString();
    }

    public Calendar getCreatedAt() {
	return createdAt;
    }

    public Calendar getUpdatedAt() {
	return updatedAt;
    }

    public String getUuid() {
	return uuid;
    }

    public int getVersion() {
	return version;
    }

    public void insertTimeStamp() {
	this.createdAt = Calendar.getInstance();
    }

    protected void setCreatedAt(Calendar createdAt) {
	this.createdAt = createdAt;
    }

    protected void setUpdatedAt(Calendar updatedAt) {
	this.updatedAt = updatedAt;
    }

    protected void setUuid(String uuid) {
	this.uuid = uuid;
    }

    protected void setVersion(int version) {
	this.version = version;
    }

    protected void updateTimeStamp() {
	this.updatedAt = Calendar.getInstance();
    }

}
