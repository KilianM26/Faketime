package com.example.faketime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class AddContact extends AppCompatActivity {

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;

    Gson gson = new Gson();
    String json;
    List<String[]> contacts;
    String[] curContact = new String[2];

    @Override
    public void onCreate(Bundle savedInstanceState){

        mPrefs = getSharedPreferences("state", 0);
        mEdit = mPrefs.edit();
        json = mPrefs.getString("MyObject", "");
        contacts = gson.fromJson(json, List.class);

        super.onCreate(savedInstanceState);


        final EditText contactName = (EditText) findViewById(R.id.contactName);
        final EditText contactAddress = (EditText) findViewById(R.id.contactAddress);
        Button submitContact = (Button) findViewById(R.id.submitContact);
        submitContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curContact[0] = contactName.getText().toString();
                curContact[1] = contactAddress.getText().toString();
                contacts.add(curContact);

                json = gson.toJson(curContact);
                mEdit.putString("contacts", json);
                mEdit.apply();
            }
        });


    }

    @Override
    public void onBackPressed(){
        Intent mainActivity = new Intent(AddContact.this, MainActivity.class);
        AddContact.this.startActivity(mainActivity);
    }

}
