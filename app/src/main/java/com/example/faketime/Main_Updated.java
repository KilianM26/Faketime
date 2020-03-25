package com.example.faketime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Main_Updated extends AppCompatActivity {

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;

    Gson gson = new Gson();
    String json;
    List<String[]> contacts;

    @Override
    public void onCreate(Bundle savedInstanceState){

        mPrefs = getSharedPreferences("state", 0);
        mEdit = mPrefs.edit();
        json = mPrefs.getString("MyObject", "");
        contacts = gson.fromJson(json, List.class);

        super.onCreate(savedInstanceState);

        Button addContactButton = (Button) findViewById(R.id.addContactButton);
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addContact = new Intent(Main_Updated.this, AddContact.class);
                Main_Updated.this.startActivity(addContact);
            }
        });

        ConstraintLayout layout;
        for(Object cur: contacts){
            layout = new ConstraintLayout(this);
        }


    }

}
