/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.android.jobs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Serializable;

import br.com.codecode.workix.android.R;
import br.com.codecode.workix.android.dao.HTTP;
import br.com.codecode.workix.android.model.base.BaseUser;
import br.com.codecode.workix.android.model.pojo.User;


public class TaskCreateUser extends AsyncTask<BaseUser, String, BaseUser> {

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

    public TaskCreateUser(Context context, AsyncResponse<BaseUser> delegate) {
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

    @Override
    protected BaseUser doInBackground(@NonNull BaseUser... params) {

        for(int x=0; x < params.length;x++){

            if(!(params[x] instanceof Serializable)){

                throw new RuntimeException("Object Must implement Serializable");

            }else if(!(params[x] instanceof Parcelable)){

                throw new RuntimeException("Object Must implement Parcelable");
            }
        }

        try {

            publishProgress("Enviando Requisição para o Servidor");

            //TODO FIXME Make a Json

            response = HTTP.sendRequest(url, "POST", new Gson().toJson(params[0]));

        } catch (IOException | RuntimeException e) {

            publishProgress("Fail on Get Response");

            Log.e("Erro", e.getMessage());
        }

        publishProgress("Item received !");

        //TODO FIXME Receive a Json

        BaseUser u = new Gson().fromJson(response, new TypeToken<User>(){}.getType());

        return u;

    }

    @Override
    protected void onProgressUpdate(String... values) {

        super.onProgressUpdate(values);

        dialog.setMessage(String.valueOf(values[0]));
    }


    @Override
    protected void onPostExecute(BaseUser result) {

        dialog.setMessage(context.getString(R.string.process_finish));

        dialog.dismiss();

        delegate.processFinish(result);

    }
}
