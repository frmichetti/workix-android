/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.android.jobs;

import android.support.annotation.NonNull;

public interface AsyncResponse<T> {

    void processFinish(@NonNull T output);
}
