package com.example.abdullah.assignment03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EventMessage {

    private String wifiStatus ="";
    private String airStatus ="";


    public String getWifiStatus() {
        return wifiStatus;
    }

    public void setWifiStatus(String wifiStatus) {
        this.wifiStatus = wifiStatus;
    }

    public String getAirStatus() {
        return airStatus;
    }

    public void setAirStatus(String airStatus) {
        this.airStatus = airStatus;
    }

}
