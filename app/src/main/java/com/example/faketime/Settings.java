package com.example.faketime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    SharedPreferences mPrefs;
    String theme;
    SharedPreferences.Editor mEdit;
    Boolean checkTheme;

    View settings, home;
    private static final String TAG = "asdfgh";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPrefs = getSharedPreferences("state", 0);
        theme = mPrefs.getString("theme", "light");
        mEdit = mPrefs.edit();
        checkTheme = mPrefs.getBoolean("checkTheme", false);


        super.onCreate(savedInstanceState);
        if(theme == "dark"){
            setTheme(R.style.Dark);
        }else{
            setTheme(R.style.Light);
        }
        setContentView(R.layout.settings);

        settings = findViewById(R.id.Settings_Screen);
        home = findViewById(R.id.Main_Screen);

        final CheckBox darkMode = (CheckBox) findViewById(R.id.darkMode);
        darkMode.setChecked(checkTheme);
        mEdit.apply();

        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(darkMode.isChecked()){
                    mEdit.putString("theme", "dark");
                    mEdit.putBoolean("checkTheme", true);
                    mEdit.apply();

                    Intent settings = new Intent(Settings.this, Settings.class);
                    Settings.this.startActivity(settings);
                }else{
                    mEdit.putString("theme", "light");
                    mEdit.putBoolean("checkTheme", false);
                    mEdit.apply();
                    Intent settings = new Intent(Settings.this, Settings.class);
                    Settings.this.startActivity(settings);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent mainActivity = new Intent(Settings.this, MainActivity.class);
        Settings.this.startActivity(mainActivity);
    }
}
