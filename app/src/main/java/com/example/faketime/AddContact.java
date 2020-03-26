package com.example.faketime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class AddContact extends AppCompatActivity {

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;

    Gson gson = new Gson();
    String json;
    List<String[]> contacts;
    String[] curContact = new String[2];
    String theme;
    private static final String TAG = "asdfgh";

    @Override
    public void onCreate(Bundle savedInstanceState){

        mPrefs = getSharedPreferences("state", 0);
        mEdit = mPrefs.edit();
        json = mPrefs.getString("MyObject", "");
        theme = mPrefs.getString("theme", "light");
        contacts = gson.fromJson(json, List.class);
        if(contacts == null){
            contacts = new ArrayList<String[]>();
        }

        //Sets the theme
        if(theme.equals("dark")){
            setTheme(R.style.Dark);
        }else{
            setTheme(R.style.Light);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        final EditText contactName = (EditText) findViewById(R.id.contactName);
        final EditText contactAddress = (EditText) findViewById(R.id.contactAddress);
        Button submitContact = (Button) findViewById(R.id.submitContact);
        submitContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curContact[0] = contactName.getText().toString();
                curContact[1] = contactAddress.getText().toString();
                contacts.add(curContact);

                Log.v(TAG, "Added name to contacts");
                Log.v(TAG, "contacts[0] is " + curContact[0]);

                json = gson.toJson(curContact);
                Log.v(TAG, "json is " + json);
                mEdit.putString("contacts", json);
                mEdit.apply();

                Intent mainActivity = new Intent(AddContact.this, Main_Updated.class);
                AddContact.this.startActivity(mainActivity);
            }
        });


    }

    @Override
    public void onBackPressed(){
        Intent mainActivity = new Intent(AddContact.this, Main_Updated.class);
        AddContact.this.startActivity(mainActivity);
    }

}
