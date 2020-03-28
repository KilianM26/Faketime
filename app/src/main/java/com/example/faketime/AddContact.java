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

import androidx.appcompat.app.AppCompatActivity;

public class AddContact extends AppCompatActivity {

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;

    Gson gson = new Gson();
    String json;
    ArrayList<String> contacts;
    String curContact = "";
    String theme;
    private static final String TAG = "asdfgh";

    @Override
    public void onCreate(Bundle savedInstanceState){

        mPrefs = getSharedPreferences("state", 0);
        mEdit = mPrefs.edit();
        json = mPrefs.getString("contacts", "");
        theme = mPrefs.getString("theme", "light");
        contacts = gson.fromJson(json, ArrayList.class);
        if(contacts == null){
            contacts = new ArrayList<String>();
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
                String contactNameString = contactName.getText().toString();
                String contactAddressString = contactAddress.getText().toString();
                curContact = contactNameString + "/" + contactAddressString;
                contacts.add(curContact);

                Log.v(TAG, "Contacts is" + contacts.toString());

                json = gson.toJson(contacts);
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
