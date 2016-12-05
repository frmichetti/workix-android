/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.android.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import br.com.codecode.workix.android.R;
import br.com.codecode.workix.android.dao.HTTP;
import br.com.codecode.workix.android.util.GsonDateDeserializer;
import br.com.codecode.workix.core.models.compat.Job;

public class TaskDownloadJobs extends AsyncTask<Void, String, ArrayList<Job>> {

    public AsyncResponse delegate = null;

    private String url;

    private ArrayList<Job> jobs;

    private Context context;

    private TaskDownloadJobs() {
        Log.d("DEBUG-TASK", "create TaskDownloadJobs");
    }

    private TaskDownloadJobs(Context context) {
        this();
        this.context = context;
    }

    public TaskDownloadJobs(Context context, AsyncResponse<ArrayList<Job>> delegate) {
        this(context);
        this.delegate = delegate;
    }


    @Override
    protected void onPreExecute() {

        super.onPreExecute();

        url = context.getResources().getString(R.string.server) + "jobs";

        Log.d("DEBUG-TASK", "server config -> " + url);


    }


    @Override
    protected ArrayList<Job> doInBackground(Void... params) {

        String response = "";

        try {

            publishProgress("Enviando Requisição para o Servidor");

            //TODO FIXME Receive JSON

            response = HTTP.sendGet(url);

        } catch (IOException e) {

            publishProgress("Falha ao Obter Resposta");

            Log.e("Erro", e.getMessage());
        }

        publishProgress("Itens recebidos !");

        //TODO FIXME Response Json

        jobs = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .registerTypeAdapter(Date.class, new GsonDateDeserializer())
                .create()
                .fromJson(response, new TypeToken<ArrayList<Job>>() {
                }.getType());

        return (jobs != null) ? jobs : new ArrayList<Job>();
    }


    @Override
    protected void onProgressUpdate(String... values) {

        super.onProgressUpdate(values);


    }


    @Override
    protected void onPostExecute(ArrayList<Job> result) {

        delegate.processFinish(result);

    }


}
