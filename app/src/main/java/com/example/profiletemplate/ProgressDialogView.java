package com.example.profiletemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.logging.Logger;

public class ProgressDialogView {
    private AlertDialog progressDialog;
    private Context context;
    private String title;
    private TextView titleTV;
    private View progressView;

    public ProgressDialogView(Context context) {
        this.context = context;

        //initializing all common property
        progressView = LayoutInflater.from(context).inflate(R.layout.progress_dialog_view, null);
        progressDialog = new AlertDialog.Builder(context).create();
        progressDialog.setCancelable(false);
        progressDialog.setView(progressView);
    }


    public void showProgress() {
        progressDialog.show();
    }
    public void showProgress(String title) {   //optional, if wants custom title
        titleTV = progressView.findViewById(R.id.titleProgress);

        titleTV.setText(title);
        progressDialog.show();
    }

    public void dismissProgress() {
        progressDialog.dismiss();
    }

}
