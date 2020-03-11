package com.example.faketime;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    SharedPreferences mPrefs = getSharedPreferences("state", 0);
    String theme = mPrefs.getString("theme", "light");
    SharedPreferences.Editor mEdit = mPrefs.edit();
    Boolean checkTheme = mPrefs.getBoolean("checkTheme", false);

    View settings, home;
    private static final String TAG = "asdfgh";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if(theme == "light"){
            setTheme(R.style.Light);
        }else{
            setTheme(R.style.Dark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        settings = findViewById(R.id.Settings_Screen);
        home = findViewById(R.id.Main_Screen);

        final CheckBox darkMode = (CheckBox) findViewById(R.id.darkMode);
        darkMode.setChecked(checkTheme);

        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(darkMode.isChecked()){
                    mEdit.putString("theme", "dark");
                    mEdit.putBoolean("checkTheme", true);
                    Log.v(TAG, "changed theme to dark");
                    setContentView(R.layout.settings);
                    Log.v(TAG, "set the content view thingamajig");
                }else{
                    mEdit.putString("theme", "light");
                    mEdit.putBoolean("checkTheme", true);
                    Log.v(TAG, "changed theme to light");
                    setContentView(R.layout.settings);
                }
            }
        });
    }

}
