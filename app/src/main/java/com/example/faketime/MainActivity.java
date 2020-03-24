package com.example.faketime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;
    String theme;
    boolean firstLaunch = true;
    private static final String TAG = "asdfgh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPrefs = getSharedPreferences("state", 0);
        mEdit = mPrefs.edit();
        theme = mPrefs.getString("theme", "light");
        firstLaunch = mPrefs.getBoolean("firstLaunch", true);

        //Sets the theme
        if(theme.equals("dark")){
            setTheme(R.style.Dark);
        }else{
            setTheme(R.style.Light);
        }

        super.onCreate(savedInstanceState);

        //Checks if it's the user's first time launching the app
        if(firstLaunch){
            Intent intro = new Intent(MainActivity.this, Intro.class);
            MainActivity.this.startActivity(intro);
;        }
        setContentView(R.layout.activity_main);

        //Settings button
        Button settingsButton = (Button) findViewById(R.id.settings_button);
        if (theme.equals("dark")){
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

        //Video call page button
        Button cameraPage = (Button) findViewById(R.id.cameraPageButton);
        cameraPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent camera = new Intent(MainActivity.this, CallPage.class);
                MainActivity.this.startActivity(camera);

            }
        });

        //Message page button
        Button messagePage = (Button) findViewById(R.id.messagePageButton);
        messagePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent messages = new Intent(MainActivity.this, Messages.class);
                MainActivity.this.startActivity(messages);

            }
        });


    }


}
