package com.example.faketime;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class AddContact extends AppCompatActivity {

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;

    Gson gson = new Gson();
    String json;
    List contacts;

    @Override
    public void onCreate(Bundle savedInstanceState){

        mPrefs = getSharedPreferences("state", 0);
        mEdit = mPrefs.edit();
        json = mPrefs.getString("MyObject", "");
        contacts = gson.fromJson(json, List.class);

        super.onCreate(savedInstanceState);



    }

}
