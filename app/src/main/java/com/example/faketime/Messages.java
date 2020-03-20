package com.example.faketime;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Messages extends AppCompatActivity {

    SharedPreferences mPrefs;
    String theme;
    SharedPreferences.Editor mEdit;
    private static final String TAG = "asdfgh";

    @Override
    public void onCreate(Bundle savedInstanceState){

        mPrefs = getSharedPreferences("state", 0);
        theme = mPrefs.getString("theme", "light");
        mEdit = mPrefs.edit();

        if(theme.equals("dark")){
            setTheme(R.style.Dark);
        }else{
            setTheme(R.style.Light);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages);

    }

}
