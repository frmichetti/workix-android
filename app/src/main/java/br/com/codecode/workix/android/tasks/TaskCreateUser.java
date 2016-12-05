/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.android.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Serializable;

import br.com.codecode.workix.android.R;
import br.com.codecode.workix.android.dao.HTTP;
import br.com.codecode.workix.core.models.compat.User;


public class TaskCreateUser extends AsyncTask<User, String, User> {

    private AsyncResponse delegate = null;

    private String url;

    private ProgressDialog dialog;

    private Context context;

    private String response;


    private TaskCreateUser() {

        Log.d("DEBUG-TASK", "create TaskCreateUser");

    }

    private TaskCreateUser(Context context) {
        this();
        this.context = context;
    }

    public TaskCreateUser(Context context, AsyncResponse<User> delegate) {
        this(context);
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();

        url = context.getResources().getString(R.string.server) + "save/user";

        Log.d("DEBUG-TASK", "server config -> " + url);

        dialog = new ProgressDialog(context);

        dialog.setTitle(context.getString(R.string.processing));

        dialog.setIndeterminate(true);

        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        dialog.setMessage("Iniciando a Tarefa Criar Novo Login");

        dialog.show();

    }

    /**
     *
     * @param params User
     * @return A new User
     * @throws RuntimeException if Not Passivate Capable
     */
    @Override
    protected User doInBackground(@NonNull User... params) throws RuntimeException {

        for (int x = 0; x < params.length; x++) {

            if (!(params[x] instanceof Serializable)) {

                throw new RuntimeException("Object of Param [" + x + "] MUST implements Serializable");
            }
        }
            try {

                publishProgress("Enviando Requisição para o Servidor");

                //TODO FIXME Make a Json

                response = HTTP.sendRequest(url, "POST", new Gson().toJson(params[0]));

            } catch (IOException | RuntimeException e) {

                publishProgress("Fail on Get Response");

                Log.e("Error", e.getMessage());
            }

            publishProgress("Item received !");

            //TODO FIXME Receive a Json

            User u = new Gson().fromJson(response, new TypeToken<User>(){}.getType());

            return u;


    }

    @Override
    protected void onProgressUpdate(String... values) {

        super.onProgressUpdate(values);

        dialog.setMessage(String.valueOf(values[0]));
    }


    @Override
    protected void onPostExecute(User result) {

        dialog.setMessage(context.getString(R.string.process_finish));

        dialog.dismiss();

        delegate.processFinish(result);

    }
}
