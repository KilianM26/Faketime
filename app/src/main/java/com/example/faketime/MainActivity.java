package com.example.faketime;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public BluetoothAdapter bluetoothAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connectBluetooth = (Button) findViewById(R.id.connectBluetoothButton);
        connectBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectBluetooth();
            }
        });

    }

    public void connectBluetooth(){

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 1);
        }

    }
}
