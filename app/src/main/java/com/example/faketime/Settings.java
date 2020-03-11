package com.example.faketime;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    View settings, home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        settings = findViewById(R.id.Settings_Screen);
        home = findViewById(R.id.Main_Screen);

        final CheckBox darkMode = (CheckBox) findViewById(R.id.darkMode);
        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(darkMode.isChecked()){
                    setTheme(R.style.Light);
                    setContentView(R.layout.settings);
                }else{
                    setTheme(R.style.Dark);
                    setContentView(R.layout.settings);
                }
            }
        });
    }

}
