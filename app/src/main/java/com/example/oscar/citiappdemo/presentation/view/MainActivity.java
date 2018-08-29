package com.example.oscar.citiappdemo.presentation.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.oscar.citiappdemo.R;
import com.example.oscar.citiappdemo.presentation.presenter.GetClientNamePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private static ProgressDialog progress;

    @Inject
    GetClientNamePresenter getClientNamePresenter;

    @BindView(R.id.tv_activity_main) TextView textViewClientName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void showProgress() {
        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }

    @Override
    public void hideProgress() {
        if (progress != null) {
            progress.dismiss();
        }
    }

    @Override
    public void setClientName(String clientName) {
        textViewClientName.setText(clientName);
    }

    @OnClick(R.id.button)
    public void onButtonClick() {
        getClientNamePresenter.setView(this);
        getClientNamePresenter.getClientName();
    }
}
