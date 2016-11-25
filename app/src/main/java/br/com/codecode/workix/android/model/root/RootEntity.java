package br.com.codecode.workix.android.model.root;

import java.sql.Timestamp;

/**
 * Root Abstract Class MyEntity<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #id}</li>
 * <li>{@link #version}</li>
 * <li>{@link #createdAt}</li>
 * <li>{@link #updatedAt}</li>
 * <li>{@link #uuid}</li>
 * </ul>
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
public abstract class RootEntity {

    protected long id;

    protected int version;

    protected String uuid;

    protected Timestamp createdAt;

    protected Timestamp updatedAt;

    /**
     * Public Empty Default Constructor
     */
    public RootEntity() {
    }
}
