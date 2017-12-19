package com.example.abdullah.assignment03;

import android.content.*;
import android.net.ConnectivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by abdullah on 12/19/2017.
 */

public class BroadcasrReceiver extends BroadcastReceiver {

    String wifiStatus ="off";
    private String airStatus ="off";


    @Override
    public void onReceive(Context context, Intent intent) {
        // WifiManager wifi = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);

        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (wifi.isConnected()){

            wifiStatus = "on";
            EventMessage eventMassage = new EventMessage();

            eventMassage.setWifiStatus(wifiStatus);

            EventBus.getDefault().postSticky(eventMassage);
            Toast.makeText(context, "wifi on", Toast.LENGTH_SHORT).show();

        }else{

            wifiStatus="off";
            Toast.makeText(context, "Wifi off", Toast.LENGTH_SHORT).show();
            EventMessage eventMassage = new EventMessage();
            eventMassage.setWifiStatus(wifiStatus);
            EventBus.getDefault().postSticky(eventMassage);

        }

        if(Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0)== 0){


            EventMessage eventMassage = new EventMessage();
            eventMassage.setAirStatus(airStatus);
            EventBus.getDefault().postSticky(eventMassage);

        }else{
            airStatus = "on";
            EventMessage eventMassage = new EventMessage();
            eventMassage.setAirStatus(airStatus);
            EventBus.getDefault().postSticky(eventMassage);

        }
    }
}
