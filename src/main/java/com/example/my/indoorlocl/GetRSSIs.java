package com.example.my.indoorlocl;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GetRSSIs extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_rssis);
    }
    public void gotoGet(View view)
    {
        Intent i = new Intent(this, GetRSSIs.class);
        startActivity(i);
    }
    private Timer autoUpdate;
    @Override
    public void onResume() {
        super.onResume();
        autoUpdate = new Timer();
        autoUpdate.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        updateHTML();
                    }
                });
            }
        }, 0, 1000);
    }

    private void updateHTML(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Context context = this;
        WifiManager wifi = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> results = wifi.getScanResults();
        int s = results.size();
        String names="";
        String rs1="";
        String rs2="";
        for (ScanResult scanResult : results) {
            if(scanResult.SSID.equals("sri"))
                rs1 = ""+scanResult.level;
            else if(scanResult.SSID.equals("cse_java"))
                rs2 = ""+scanResult.level;

        }
        textView = (TextView) findViewById(R.id.text1);
        textView.setText("scan result is "+rs1+" and "+rs2);

        try {
           URL link = new URL("IPV4:777?rs1="+rs1+"&rs2="+rs2);

            URLConnection conn = link.openConnection();
            conn.setDoOutput(true);

            BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream()));
           /* //Toast.makeText(getApplicationContext(),"Hello12",Toast.LENGTH_SHORT).show();
            String inputLine;
            String total = "";
            while ((inputLine = in.readLine()) != null)
                total += inputLine;
            textView.setText(" " + total);
            in.close();
            */
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onPause() {
        autoUpdate.cancel();
        super.onPause();
    }
    public void gotoStop(View view)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
