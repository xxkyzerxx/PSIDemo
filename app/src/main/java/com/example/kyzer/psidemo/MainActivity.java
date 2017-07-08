package com.example.kyzer.psidemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

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
            if (TextUtils.isEmpty(s)){
                //success
                TextView textview = (TextView) findViewById(R.id.lblCentral);
                int temp = (int)psiData.getPSIItems().get(0).getReadings().getPsi_twenty_four_hourly().getCentral();
                textview.setText(Integer.toString(temp));

                textview = (TextView) findViewById(R.id.lblNorth);
                temp = (int)psiData.getPSIItems().get(0).getReadings().getPsi_twenty_four_hourly().getNorth();
                textview.setText(Integer.toString(temp));

                textview = (TextView) findViewById(R.id.lblSouth);
                temp = (int)psiData.getPSIItems().get(0).getReadings().getPsi_twenty_four_hourly().getSouth();
                textview.setText(Integer.toString(temp));

                textview = (TextView) findViewById(R.id.lblEast);
                temp = (int)psiData.getPSIItems().get(0).getReadings().getPsi_twenty_four_hourly().getEast();
                textview.setText(Integer.toString(temp));

                textview = (TextView) findViewById(R.id.lblWest);
                temp = (int)psiData.getPSIItems().get(0).getReadings().getPsi_twenty_four_hourly().getWest();
                textview.setText(Integer.toString(temp));
            }
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
