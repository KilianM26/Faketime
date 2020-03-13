package com.example.faketime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mPrefs;
    String theme;
    SharedPreferences.Editor mEdit;
    private static final String TAG = "asdfgh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPrefs = getSharedPreferences("state", 0);
        theme = mPrefs.getString("theme", "light");
        mEdit = mPrefs.edit();
        Log.v(TAG, theme);

        if(theme == "dark"){
            setTheme(R.style.Dark);
        }else{
            setTheme(R.style.Light);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button settingsButton = (Button) findViewById(R.id.settings_button);
        if (theme == "dark"){
            settingsButton.setBackgroundResource(R.drawable.settings_icon_dark);
        }else{
            settingsButton.setBackgroundResource(R.drawable.settings_icon_light);
        }
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent settings = new Intent(MainActivity.this, Settings.class);
                MainActivity.this.startActivity(settings);

            }
        });

        //switches to the Camera Preview page
        Button cameraPreview = (Button) findViewById(R.id.cameraButton);
        cameraPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent camera = new Intent(MainActivity.this, CallPage.class);
                MainActivity.this.startActivity(camera);

            }
        });


    }


}
