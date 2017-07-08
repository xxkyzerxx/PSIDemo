package com.example.kyzer.psidemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.kyzer.psidemo.Class.PSI;
import com.example.kyzer.psidemo.Helper.PSIHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //force it to be portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //set title
        setTitle("24hr PSI readings");

        //loading bar
        ProgressDialog dialog = ProgressDialog.show(this, "", "Loading...", true);

        //do actual loading of data
        new MainAsyncLoad().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,dialog, this);
    }

    private class MainAsyncLoad extends AsyncTask<Object, Void, String> {
        Context context;
        ProgressDialog dialog;
        PSI psiData;
        @Override
        protected String doInBackground(Object... params) {
            dialog = (ProgressDialog) params[0];
            context = (Context) params[1];
            psiData = PSIHelper.getPSI();
            return "";
        }

        @Override
        protected void onPostExecute(String s) {

            dialog.dismiss();
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}
