/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.android.view.activity.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.io.Serializable;

import br.com.codecode.workix.android.R;
import br.com.codecode.workix.android.jobs.AsyncResponse;
import br.com.codecode.workix.android.jobs.TaskLoginFirebase;
import br.com.codecode.workix.android.model.base.BaseCandidate;
import br.com.codecode.workix.android.util.ConnectivityReceiver;
import br.com.codecode.workix.android.view.activity.CandidateActivity;
import br.com.codecode.workix.android.view.activity.MyPattern;
import br.com.codecode.workix.android.view.activity.NewMain;


public class LoginActivity extends AppCompatActivity implements MyPattern,
        ConnectivityReceiver.ConnectivityReceiverListener {

    private static final int RC_SIGN_IN = 9001;
    private Context context;
    private ActionBar actionBar;
    private EditText editTextEmail, editTextPassword;
    private FirebaseAuth firebaseAuth;
    private GoogleApiClient googleApiClient;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;
    private SignInButton signInButton;
    private String TAG = "Google Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_login);

        doCastComponents();

        doConfigureGoogle();

        doCreateListeners();


    }

    private void doConfigureGoogle() {

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        googleApiClient = new GoogleApiClient.Builder(this)
                // .enableAutoManage(this /* FragmentActivity */ ,1, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        signInButton.setScopes(gso.getScopeArray());


    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);

        doConfigure();

        doCheckConnection();

        editTextEmail.setText("frmichetti@gmail.com");

        editTextPassword.setText("s394asc9");
    }

    @Override
    public void doCastComponents() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        editTextEmail = (EditText) findViewById(R.id.email);

        editTextPassword = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnSignup = (Button) findViewById(R.id.btn_signup);

        btnLogin = (Button) findViewById(R.id.btn_login);

        btnReset = (Button) findViewById(R.id.btn_reset_password);

        signInButton = (SignInButton) findViewById(R.id.google_sign_in_button);

        // Customize sign-in button. The sign-in button can be displayed in
        // multiple sizes and color schemes. It can also be contextually
        // rendered based on the requested scopes. For example. a red button may
        // be displayed when Google+ scopes are requested, but a white button
        // may be displayed when only basic profile is requested. Try adding the
        // Scopes.PLUS_LOGIN scope to the GoogleSignInOptions to see the
        // difference.
        signInButton.setSize(SignInButton.SIZE_WIDE);

    }

    @Override
    public void doCreateListeners() {

        signInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);

                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(context, SignupActivity.class));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(context, ResetPasswordActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString();

                final String password = editTextPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(context, getString(R.string.enter_email_address), Toast.LENGTH_SHORT).show();

                    return;
                }

                if (TextUtils.isEmpty(password)) {

                    Toast.makeText(context, getString(R.string.enter_password), Toast.LENGTH_SHORT).show();

                    return;
                }


                if (doCheckConnection()) {

                    progressBar.setVisibility(View.VISIBLE);

                    firebaseAuthWithEmailPassword(email, password);

                } else {

                    showSnack(doCheckConnection());

                }

            }

        });

    }

    @Override
    public void setupToolBar() {

    }

    @Override
    public void doConfigure() {

        context = this;

        actionBar = getSupportActionBar();

        actionBar.setTitle(R.string.app_name);

        actionBar.setSubtitle(R.string.action_sign_in);

        actionBar.setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public void doChangeActivity(Context context, Class clazz) {

    }

    // Method to manually check connection status
    private boolean doCheckConnection() {

        boolean isConnected = ConnectivityReceiver.isConnected(context);

        return isConnected;
    }

    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) {

        String message;

        int color;

        if (isConnected) {

            message = getString(R.string.connected_on_internet);

            color = Color.GREEN;

        } else {

            message = getString(R.string.not_connected_on_internet);

            color = Color.RED;

        }

        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.coordlayoutLogin), message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();

        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);

        textView.setTextColor(color);

        snackbar.show();

    }

    @Override
    protected void onResume() {

        super.onResume();

        // register connection status listener
        this.setConnectivityListener(this);
    }

    /**
     * Callback will be triggered when there is change in
     * network connection
     */
    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

        showSnack(isConnected);
    }


    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {

        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);


            Log.d(TAG, result.toString());

            if (result.isSuccess()) {

                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();


                Toast.makeText(context, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();


                firebaseAuthWithGoogle(account);

            } else {
                // Google Sign In failed, update UI appropriately
                // ...

                Toast.makeText(context, "Não foi possível realizar login com sua conta Google", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void firebaseAuthWithEmailPassword(String email, final String password) {

        //authenticate firebaseUser
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // If sign in fails, display a message to the firebaseUser. If sign in succeeds
                        // the firebaseAuth state listener will be notified and logic to handle the
                        // signed in firebaseUser can be handled in the listener.
                        progressBar.setVisibility(View.GONE);

                        if (!task.isSuccessful()) {

                            // there was an error
                            if (password.length() < 6) {

                                editTextPassword.setError(getString(R.string.minimum_password));

                            } else {

                                Toast.makeText(context, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();

                                Log.d("DEBUG-LOGIN", String.valueOf(R.string.auth_failed));
                            }

                        } else {

                            TaskLoginFirebase taskLoginFirebase = new TaskLoginFirebase(context, new AsyncResponse<BaseCandidate>() {

                                @Override
                                public void processFinish(BaseCandidate output) {

                                    //TODO Validate Logic HERE

                                    if (output.getUser() != null) {

                                        startActivity(new Intent(context, NewMain.class)
                                                .putExtra("candidate", (Serializable) output)
                                        );

                                        finish();

                                    } else {

                                        startActivity(new Intent(context, CandidateActivity.class)
                                                .putExtra("candidate", (Serializable) output));

                                        finish();
                                    }

                                }
                            });

                            taskLoginFirebase.execute(firebaseAuth.getCurrentUser().getUid());

                        }
                    }
                }).addOnFailureListener(LoginActivity.this, new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(context, getString(R.string.could_not_authorize), Toast.LENGTH_LONG).show();

                Log.e("[Error on Login]", e.getMessage());
            }
        });

    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {

                            Log.w(TAG, "signInWithCredential", task.getException());

                            Toast.makeText(context, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
}
