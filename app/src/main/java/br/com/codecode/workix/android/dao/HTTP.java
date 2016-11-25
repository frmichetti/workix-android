/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.android.dao;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;

public final class HTTP {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final Integer TIME_OUT = 30_000;

    // HTTP GET request
    public static String sendGet(String url) throws IOException, RuntimeException {

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add request header
        con.setRequestMethod("GET");

        con.setReadTimeout(TIME_OUT);

        con.setRequestProperty("Accept-Language", "UTF-8");

        con.setRequestProperty("Content-Type", "application/json");

        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        Log.i("Response", "Send 'GET' request for URL : " + url);

        Log.i("Response", "Response Code: " + responseCode);

        String resp;

        if (responseCode == HTTP_OK || responseCode == HTTP_CREATED || responseCode == HTTP_ACCEPTED) {

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            StringBuffer response = new StringBuffer();

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            Log.i("Response", "Response do Servidor");

            Log.i("Response", response.toString());

            resp = response.toString();

        } else {
            throw new RuntimeException("Unexpected Response Code " + responseCode);
        }

        return resp;
    }

    public static String sendRequest(String url, String method, String params) throws IOException, RuntimeException {

        URL obj = new URL(url);

        params = new String(params.getBytes(), "ISO_8859_1");

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add request header
        con.setRequestMethod(method);

        con.setRequestProperty("User-Agent", USER_AGENT);

        con.setRequestProperty("Accept-Language", "UTF-8");

        con.setRequestProperty("Content-Type", "application/json");

        // Send post request
        con.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());

        wr.writeBytes(params);

        wr.flush();

        int responseCode = con.getResponseCode();

        Log.i("Response", "Send Request " + con.getRequestMethod() + " to URL : " + url);

        Log.i("Response", "Parameters : " + params);

        Log.i("Response", "Response Code : " + responseCode);

        String resp;

        if (responseCode == HTTP_OK || responseCode == HTTP_CREATED || responseCode == HTTP_ACCEPTED) {

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuffer response = new StringBuffer();

            String inputLine;

            while ((inputLine = in.readLine()) != null) {

                response.append(inputLine);

            }

            Log.i("Response", "Response of Server");

            Log.i("Response", response.toString());

            resp = response.toString();

        } else {
            throw new RuntimeException("Unexpected Response Code " + responseCode);
        }

        return resp;

    }

}
