/** 
 * @author Felipe Rodrigues Michetti
 * @see <a href="http://portfolio-frmichetti.rhcloud.com">portfolio-frmichetti.rhcloud.com</a>
 * @see <a href="http://www.codecode.com.br">www.codecode.com.br</a>
 * @see <a href="mailto:frmichetti@gmail.com">frmichetti@gmail.com</a>
 * */
package br.com.codecode.workix.core.interfaces;

/**
 * Markup Interface for Persistable Entities <br>
 * Implements this for works with <br>
 * {@link SimpleEntityConverter} and {@link AnotherEntityConverter} in JSF
 * 
 * @author Felipe Rodrigues Michetti
 * @since 1.0
 * @version 1.0
 */
public interface Persistable {

    /**
     * @return the Id
     */
    long getId();

    /**
     * @param id define the Id
     */
    void setId(long id);

}
