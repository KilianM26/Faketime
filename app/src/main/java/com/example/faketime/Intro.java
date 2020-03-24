package com.example.faketime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Intro extends AppCompatActivity {

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;

    @Override
    public void onCreate(Bundle savedInstanceState){

        mPrefs = getSharedPreferences("state", 0);
        mEdit = mPrefs.edit();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        Button finished = (Button) findViewById(R.id.introFinishedButton);
        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent understood = new Intent(Intro.this, MainActivity.class);
                Intro.this.startActivity(understood);
                mEdit.putBoolean("firstLaunch", false);
                mEdit.apply();

            }
        });

    }

}
