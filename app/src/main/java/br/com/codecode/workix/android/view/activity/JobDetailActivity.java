/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.android.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.codecode.workix.android.R;

public class JobDetailActivity extends BaseActivity {

    private TextView textViewTitle, textViewDescription, textViewEmployeer,
            textViewRequirement, textViewMinPayment;

    private FloatingActionButton floatButtonAddCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_job_detail);

        doCastComponents();

        doCreateListeners();

        setupToolBar();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);

        doFillData();

    }


    @Override
    public void setupToolBar() {

        super.setupToolBar();

        actionBar.setSubtitle(getString(R.string.job_details));
    }

    @Override
    public void doCastComponents() {

        super.doCastComponents();

        textViewTitle = (TextView) findViewById(R.id.textViewTitle);

        textViewDescription = (TextView) findViewById(R.id.textViewDescriptionVar);

        textViewEmployeer = (TextView) findViewById(R.id.textViewEmployeerVar);

        textViewRequirement = (TextView) findViewById(R.id.textViewRequirementVar);

        textViewMinPayment = (TextView) findViewById(R.id.textViewMinPaymentVar);

        floatButtonAddCart = (FloatingActionButton) findViewById(R.id.fab_add_to_cart);


    }

    @Override
    public void doCreateListeners() {

        floatButtonAddCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Candidatar a Vaga", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void doFillData() {

        textViewTitle.setText(selectedJob.getTitle());

        textViewDescription.setText(selectedJob.getDescription());

        textViewRequirement.setText(selectedJob.getRequirement());

        textViewEmployeer.setText(selectedJob.getEmployeer().getName());

        textViewMinPayment.setText(String.valueOf(selectedJob.getMinPayment()));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {

            finish();

            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        super.onKeyUp(keyCode, event);

        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {

            //TODO FIXME Not Implemented Yet

        }

        if (event.getKeyCode() == KeyEvent.KEYCODE_HOME) {
            //TODO FIXME Not Implemented Yet

        }

        if (event.getKeyCode() == KeyEvent.KEYCODE_SEARCH) {

            //TODO FIXME Not Implemented Yet
        }

        return true;
    }

    /**
     * Callback will be triggered when there is change in
     * network connection
     */
    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

        showSnack((CoordinatorLayout) findViewById(R.id.coordLayoutServiceDetail), isConnected);
    }


}