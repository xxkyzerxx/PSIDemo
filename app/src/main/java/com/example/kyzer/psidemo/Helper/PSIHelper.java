package com.example.kyzer.psidemo.Helper;

import com.example.kyzer.psidemo.Class.PSI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kyzer on 8/7/17.
 */

public class PSIHelper {

    public static PSI getPSI() {

        String url = "https://api.data.gov.sg/v1/environment/psi?date_time=";
        DateFormat dateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormatTime = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        url += dateFormatDate.format(date) + "T" + dateFormatTime.format(date);

        //get the data
        String result = DataGovHttpHelper.getString(url);

        //deserialize into class

        return null;
    }
}
