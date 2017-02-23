package br.com.codecode.workix.core.interfaces;

/**
 * Markup Interface for Buildable Objects <br>
 * Builders Must Have:<br>
 * <ul>
 * <li>Empty Default Constructor with Private Accessor</li>
 * <li>Contains Same Fields of Implementation Class</li>
 * <li>All With Fields Must Return {this} or Current Builder</li>
 * </ul>
 * 
 * @author felipe
 * @param <T>
 *            The Class for Construct
 * @since 1.0
 * @version 1.0
 */
public interface Buildable<T> {
      

    /**
     * Return a Finished Object
     * 
     * @return a new Entity ready for Use
     */
    T build();
}
