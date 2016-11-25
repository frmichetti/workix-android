/**
 * @author Felipe Rodrigues Michetti
 * @see <a href="http://portfolio-frmichetti.rhcloud.com">portfolio-frmichetti.rhcloud.com</a>
 * @see <a href="http://www.codecode.com.br">www.codecode.com.br</a>
 * @see <a href="mailto:frmichetti@gmail.com">frmichetti@gmail.com</a>
 */
package br.com.codecode.workix.android.model.interfaces;

/**
 * Markup Interface for Persistable Entities <br>
 * Implements this for works with <br> {SimpleEntityConverter}
 * and {AnotherEntityConverter} in JSF
 *
 * @author Felipe Rodrigues Michetti
 */
public interface Persistable {

    long getId();

    void setId(long id);

}  
