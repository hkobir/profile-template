package com.example.profiletemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    private String USERNAME = "Humayun Kobir";
    private ProgressDialogView progressDialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_ProfileTemplate);  //back to original theme after splash screen style theme from manifest
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());  //initialize logger

        progressDialogView = new ProgressDialogView(this);
        progressDialogView.showProgress("Loading...");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialogView.dismissProgress();
                Logger.d("Progress dismissed");
                initInstancesDrawer();
            }
        }, 2000);
    }

    private void initInstancesDrawer() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle(USERNAME);
    }
}