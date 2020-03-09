package com.example.faketime;

import android.os.Bundle;

import android.widget.CheckBox;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    CheckBox darkMode = (CheckBox) findViewById(R.id.darkMode);
    darkMode.OnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

        }
    });

}
