package com.example.abdullah.assignment03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private TextView wifi , airplane;
    private Switch Swifi , Sairplane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifi = findViewById(R.id.tvwifi);
        airplane = findViewById(R.id.tvairplane);
        Swifi = findViewById(R.id.swifi);
        Sairplane = findViewById(R.id.sairplane);
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventMessage eventMassage){

        if(eventMassage.getWifiStatus() == "on"){
            Swifi.setChecked(true);
        }

        if(eventMassage.getWifiStatus() == "off"){
            Swifi.setChecked(false);
        }

        if(eventMassage.getAirStatus() == "on"){
            Sairplane.setChecked(true);
        }else {
            Sairplane.setChecked(false);
        }

    }
}
