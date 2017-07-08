package com.example.kyzer.psidemo.Helper;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kyzer on 8/7/17.
 */

public class DataGovHttpHelper {
    private final static String apiKey = "";

    public static String getString(String urlString) throws NoAPIKeyException {
        if (TextUtils.isEmpty(apiKey)){
            throw new NoAPIKeyException();
        }
        String Content = "";
        BufferedReader reader = null;

        try {
            // Defined URL  where to send data
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("api-key",apiKey);
            conn.setRequestProperty("User-Agent", System.getProperty("http.agent"));
            conn.setDoOutput(false);

            // Get the server response
            //int responseCode = conn.getResponseCode();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + " ");
            }

            // Append Server Response To Content String
            Content = sb.toString();
        } catch (Exception ex) {

        } finally {
            try {
                reader.close();
            } catch (Exception ex) {
            }
        }
        return Content;
    }
    public static class NoAPIKeyException extends Exception {
        public NoAPIKeyException() { super(); }

    }
}
