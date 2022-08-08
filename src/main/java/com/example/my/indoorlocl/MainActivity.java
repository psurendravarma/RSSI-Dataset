package com.example.my.indoorlocl;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.net.wifi.WifiManager;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gotoGet(View view)
    {
        Intent i = new Intent(this,GetLocRssi.class
        );
        startActivity(i);
    }
    public void getble(View view)
    {
        Intent i = new Intent(this,GetRSSIs.class
        );
        startActivity(i);
    }


    /*
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
        }, 0, 500);
    }

    private void updateHTML(){
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        int rssi = wifiManager.getConnectionInfo().getRssi();
        TextView textView = (TextView) findViewById(R.id.text2);
        textView.setText("text you want display" + rssi);
    }

    @Override
    public void onPause() {
        autoUpdate.cancel();
        super.onPause();
    }
    */
}
