package com.example.nrv.myiot;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by NRV on 2/18/2015.
 */



 public class NetLink2 extends AsyncTask<String, Void, String>{

    public static boolean success=false;
    @Override
    protected String doInBackground(String... urls) {

        return GET(urls[0]);
    }
    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
//        delegate.updateChanger("hgjhjhjgjhj");
       Log.d("Hi",result);
        if (result.contains("#")) {

            result=result.replace("#","");
            Log.d("Hi Re",result);
            try {
                JSONObject jsonObj = new JSONObject(result);
                //JSONObject ipobj = jsonObj.getJSONObject("pin");
                String pin = jsonObj.getString("pin_out");
                String status = jsonObj.getString("status");
                String executed = jsonObj.getString("executed");
                Log.d("exec",executed);
                if (executed == "0") {
                    success = true;
                } else {
                    success = false;
                }

                //delegate.updateChanger("hgjhjhjgjhj");


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(result.startsWith("All")){
            result.replaceFirst("All","");
                try {
                    JSONObject jsonObj = new JSONObject(result);
                    JSONObject pin0  = jsonObj.getJSONObject("pin0");
                    JSONObject pin1  = jsonObj.getJSONObject("pin1");
                    JSONObject pin2  = jsonObj.getJSONObject("pin2");
                    JSONObject pin3  = jsonObj.getJSONObject("pin3");
                    JSONObject pin4  = jsonObj.getJSONObject("pin4");
                    JSONObject pin5  = jsonObj.getJSONObject("pin5");
                    JSONObject pin6  = jsonObj.getJSONObject("pin6");

                    JSONObject jsonObject[]={pin0,pin1,pin2,pin3,pin4,pin5,pin6};

                    //delegate.updateChanger(jsonObject);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


     public static String GET(String url){
         InputStream inputStream = null;
         String result = "";
         try {

             // create HttpClient
             HttpClient httpclient = new DefaultHttpClient();

             // make GET request to the given URL
             HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

             // receive response as inputStream
             inputStream = httpResponse.getEntity().getContent();

             // convert inputstream to string
             if(inputStream != null)
                 result = convertInputStreamToString(inputStream);
             else
                 result = "Did not work!";

         } catch (Exception e) {
             Log.d("InputStream", e.getLocalizedMessage());
         }

         return result;
     }

     private static String convertInputStreamToString(InputStream inputStream) throws IOException {
         BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
         String line = "";
         String result = "";
         while((line = bufferedReader.readLine()) != null)
             result += line;

         inputStream.close();
         return result;

     }


}



