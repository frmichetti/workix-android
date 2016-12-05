/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.android.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import br.com.codecode.workix.android.R;
import br.com.codecode.workix.android.dao.HTTP;
import br.com.codecode.workix.core.models.compat.Candidate;
import br.com.codecode.workix.core.models.compat.Token;


public class TaskLoginFirebase extends AsyncTask<String, String, Candidate> {

    private AsyncResponse asyncResponse = null;

    private Candidate candidate;

    private ProgressDialog dialog;

    private String url;

    private Context context;

    private TaskLoginFirebase() {
        Log.d("DEBUG-TASK", "create TaskLoginFirebase");
    }

    private TaskLoginFirebase(Context context) {
        this.context = context;
    }

    public TaskLoginFirebase(Context context, AsyncResponse<Candidate> asyncResponse) {
        this(context);
        this.asyncResponse = asyncResponse;
    }


    @Override
    protected void onPreExecute() {

        super.onPreExecute();

        url = context.getResources().getString(R.string.server) + "login/firebaselogin";

        Log.d("DEBUG-TASK", "server config -> " + url);

        dialog = new ProgressDialog(context);

        dialog.setTitle(context.getString(R.string.processing));

        dialog.setIndeterminate(true);

        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        dialog.setMessage("Starting Task Login on Firebase");

        dialog.show();


    }

    @Override
    protected Candidate doInBackground(String... params) {

        for(int x = 0 ; x < params.length; x++){
            if(params[x].isEmpty()) throw new RuntimeException("Unexpected String at Param[" + x+"]");
        }

        String response = "";

        try {

            publishProgress("Send Token to Server");

            Token t = Token.builder().withKey(params[0]).build();

            response = HTTP.sendRequest(url, "POST", new GsonBuilder().
                    setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create().toJson(t));

            publishProgress("Objeto recebido");

            if ((response.isEmpty() || (response.equals(""))|| response == null)) {

                publishProgress("Server Response is Null or Empty");


            } else if (response.equals("{----}")) {

                Log.d("DEBUG", "Existent ID on Firebase");

                Log.d("DEBUG", "Empty Object");

                FirebaseAuth.getInstance().getCurrentUser().delete().addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(context, context.getString(R.string.delete_account_success), Toast.LENGTH_LONG).show();

                        Toast.makeText(context, context.getString(R.string.repeat_register_operation), Toast.LENGTH_LONG).show();


                    }
                }).addOnFailureListener(new OnFailureListener() {

                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(context, context.getString(R.string.delete_account_failed), Toast.LENGTH_LONG).show();

                        Toast.makeText(context, context.getString(R.string.could_not_authorize), Toast.LENGTH_LONG).show();
                    }
                });


            } else {

                publishProgress("Creating Object");

                candidate = new Gson().fromJson(response,
                        new TypeToken<Candidate>(){}.getType());
            }


        } catch (IOException e) {

            publishProgress("Fail on Receive Object");

            Log.e("Erro", e.getMessage());

        }catch (RuntimeException e){

            publishProgress("Fail on Receive Object");

            Log.e("Error" ,"Unexpected Response : " + e.getMessage());

        }

        publishProgress("Login Validated!");

        publishProgress("Enter...");

        return (candidate != null) ? (candidate) : (new Candidate());
    }


    @Override
    protected void onProgressUpdate(String... values) {

        super.onProgressUpdate(values);

        dialog.setMessage(String.valueOf(values[0]));
    }


    @Override
    protected void onPostExecute(Candidate result) {

        dialog.setMessage(context.getString(R.string.process_finish));

        dialog.dismiss();

        asyncResponse.processFinish(result);

    }


}
