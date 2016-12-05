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
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Serializable;

import br.com.codecode.workix.android.R;
import br.com.codecode.workix.android.dao.HTTP;
import br.com.codecode.workix.core.models.compat.Candidate;


public class TaskCreateCandidate extends AsyncTask<Candidate, String, Candidate> {

    private AsyncResponse asyncResponse = null;

    private String url;

    private ProgressDialog dialog;

    private Context context;

    private String response;


    private TaskCreateCandidate() {

        Log.d("DEBUG-TASK", "create TaskCreateCandidate");

    }

    private TaskCreateCandidate(Context context) {
        this();
        this.context = context;
    }

    public TaskCreateCandidate(Context context, AsyncResponse<Candidate> asyncResponse) {
        this(context);
        this.asyncResponse = asyncResponse;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();

        url = context.getResources().getString(R.string.server) + "save/candidate";

        Log.d("DEBUG-TASK", "server config -> " + url);

        dialog = new ProgressDialog(context);

        dialog.setTitle("Processando");

        dialog.setIndeterminate(true);

        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        dialog.setMessage("Iniciando a Tarefa Criar Novo Login");

        dialog.show();

    }

    @Override
    protected Candidate doInBackground(Candidate... params) throws RuntimeException {

        for (int x = 0; x < params.length; x++) {

            if (!(params[x] instanceof Serializable)) {

                throw new RuntimeException("Object of Param [" + x + "] MUST implements Serializable");
            }
        }

        try {

            publishProgress("Enviando Requisição para o Servidor");

            //TODO FIXME Create a JSON

            response = HTTP.sendRequest(url, "POST", new Gson().toJson(params[0]));

        } catch (IOException | RuntimeException e) {

            publishProgress("Falha ao Obter Resposta");

            Log.e("Erro", e.getMessage());
        }

        publishProgress("Item recebido !");

        //TODO FIXME Receive a JSON

        Candidate c = new Gson().fromJson(response, new TypeToken<Candidate>() {
        }.getType());

        return c;

    }

    @Override
    protected void onProgressUpdate(String... values) {

        super.onProgressUpdate(values);

        dialog.setMessage(String.valueOf(values[0]));
    }


    @Override
    protected void onPostExecute(Candidate result) {

        dialog.setMessage("Tarefa Finalizada!");

        dialog.dismiss();

        asyncResponse.processFinish(result);

    }
}
