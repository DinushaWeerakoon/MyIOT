package com.example.nrv.myiot;



import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.app.Activity;
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

public class MyActivity extends Activity {
    NetLink Link = new NetLink();
    Switch sw0, sw1, sw2, sw3, sw4, sw5, sw6;
    Switch sw_ar[] = {sw0, sw1, sw2, sw3, sw4, sw5, sw6};
    EditText etResponse;
    TextView tvIsConnected, txtv0, txtv1, txtv2, txtv3, txtv4, txtv5, txtv6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //Link.delegate = this;
        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);

        if (isConnected()) {
            tvIsConnected.setBackgroundColor(0xFF00CC00);
            tvIsConnected.setText("You are conncted");
        } else {
            tvIsConnected.setText("You are NOT conncted");
        }
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //
                new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/getAll");
            }
        });
        txtv0 = (TextView) findViewById(R.id.txt0);
        sw0 = (Switch) findViewById(R.id.switch0);
        sw0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw0.isChecked()) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/0/set/100");

                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/0/set/0");
                }



            }
        });
        txtv1 = (TextView) findViewById(R.id.txt1);
        sw1 = (Switch) findViewById(R.id.switch1);
        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/1/set/100");

                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/1/set/0");
                }

            }
        });
        txtv2 = (TextView) findViewById(R.id.txt2);
        sw2 = (Switch) findViewById(R.id.switch2);
        sw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/2/set/100");

                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/2/set/0");
                }

            }
        });

        txtv3 = (TextView) findViewById(R.id.txt3);
        sw3 = (Switch) findViewById(R.id.switch3);
        sw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw3.isChecked()) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/3/set/100");

                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/3/set/0");
                }

            }
        });

        txtv4 = (TextView) findViewById(R.id.txt4);
        sw4 = (Switch) findViewById(R.id.switch4);
        sw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw4.isChecked()) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/4/set/100");

                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/4/set/0");
                }

            }
        });

        txtv5 = (TextView) findViewById(R.id.txt5);
        sw5 = (Switch) findViewById(R.id.switch5);
        sw5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw5.isChecked()) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/5/set/100");


                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/5/set/0");
                }

            }
        });
        txtv6 = (TextView) findViewById(R.id.txt6);
        sw6 = (Switch) findViewById(R.id.switch6);
        sw6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw6.isChecked()) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/6/set/100");

                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
                    new NetLink().execute("http://www.mobileiot.16mb.com/index.php/Mobile/mobilecommand/6/set/0");
                }

            }
        });


    }
    TextView tv_ar[] = {txtv0, txtv1, txtv2, txtv3, txtv4, txtv5, txtv6};


    public void ableall(boolean enable) {
        sw0.setEnabled(enable);
        sw1.setEnabled(enable);
        sw2.setEnabled(enable);
        sw3.setEnabled(enable);
        sw4.setEnabled(enable);
        sw5.setEnabled(enable);
        sw6.setEnabled(enable);

    }


    public void updateChanger(JSONObject obj[]) {
        txtv0.setText(decider(obj[0],txtv0));
        txtv1.setText(decider(obj[1],txtv1));
        txtv2.setText(decider(obj[2],txtv2));
        txtv3.setText(decider(obj[3],txtv3));
        txtv4.setText(decider(obj[4],txtv4));
        txtv5.setText(decider(obj[5],txtv5));
        txtv6.setText(decider(obj[6],txtv6));


    }

    public String decider(JSONObject j,TextView tv){
        try {
            String st=j.getString("status");
            String nv=j.getString("new_value");
            String ex=j.getString("executed");
            Log.d("PIN  ",st +" "+nv+" "+ex );
            if (st.equals("100") && nv.equals("100") && ex.equals("1")){
                tv.setBackgroundColor(Color.GREEN);
                return "Updated ON";
            }
            else if (st.equals("0") && nv.equals("0") && ex.equals("1")){
                tv.setBackgroundColor(Color.GREEN);
                return "Updated OFF";
            }
            else if (st.equals("0") && nv.equals("100") && ex.equals("0")){
                tv.setBackgroundColor(Color.YELLOW);
                return "Pending ON";
            }
            else if (st.equals("100") && nv.equals("0") && ex.equals("0")){
                tv.setBackgroundColor(Color.YELLOW);
                return "Pending OFF";
            }
            else{
                tv.setBackgroundColor(Color.CYAN);
                return "Error";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }


    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }


    class NetLink extends AsyncTask<String, Void, String> {
        //   public AsyncListener delegate=null;
        public boolean success = false;

        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            //Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
//        delegate.updateChanger("hgjhjhjgjhj");
            Log.d("Hi", result);
            if (result.contains("#")) {

                result = result.replace("#", "");
                Log.d("Hi Re", result);
                try {
                    JSONObject jsonObj = new JSONObject(result);
                    //JSONObject ipobj = jsonObj.getJSONObject("pin");
                    String pin = jsonObj.getString("pin_out");
                    String status = jsonObj.getString("status");
                    String executed = jsonObj.getString("executed");
                    Log.d("exec", executed);
                    if (executed == "0") {
                        success = true;
                    } else {
                        success = false;
                    }
                    txtv1.setText(pin +" "+status);
                    //delegate.updateChanger("hgjhjhjgjhj");


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (result.startsWith("All")) {
                result=result.replaceFirst("All", "");



                try {
                    JSONObject jsonObj = new JSONObject(result);
                    JSONObject pin0 = jsonObj.getJSONObject("pin0");
                    JSONObject pin1 = jsonObj.getJSONObject("pin1");
                    JSONObject pin2 = jsonObj.getJSONObject("pin2");
                    JSONObject pin3 = jsonObj.getJSONObject("pin3");
                    JSONObject pin4 = jsonObj.getJSONObject("pin4");
                    JSONObject pin5 = jsonObj.getJSONObject("pin5");
                    JSONObject pin6 = jsonObj.getJSONObject("pin6");

                    JSONObject jsonObject[] = {pin0, pin1, pin2, pin3, pin4, pin5, pin6};
                    updateChanger(jsonObject);
                    Log.d("Good","JSON");
                    //delegate.updateChanger(jsonObject);


                } catch (JSONException e) {
                    Log.d("Error","JSON");
                    e.printStackTrace();

                }
            }
        }


        public  String GET(String url) {
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
                if (inputStream != null)
                    result = convertInputStreamToString(inputStream);
                else
                    result = "Did not work!";

            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }

            return result;
        }

        private String convertInputStreamToString(InputStream inputStream) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String result = "";
            while ((line = bufferedReader.readLine()) != null)
                result += line;

            inputStream.close();
            return result;

        }


    }

}
