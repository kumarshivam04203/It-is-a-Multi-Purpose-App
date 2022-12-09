package com.codewithabhijeet.netcampproject;

import static java.lang.Compiler.enable;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class WifiBluetooth extends AppCompatActivity {

    ToggleButton b1,b2;
    WifiManager wm;
    BluetoothAdapter ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_bluetooth);

        b1=(ToggleButton) findViewById(R.id.toggleButton);
        b2=(ToggleButton) findViewById(R.id.toggleButton2);
        wm=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        ba=BluetoothAdapter.getDefaultAdapter();

        b1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    wm.setWifiEnabled(true);
                }
                else {
                    wm.setWifiEnabled(false);
                }

            }
        });
        b2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    ba.isEnabled();
                else
                    ba.isEnabled();
            }
        });
    }
}