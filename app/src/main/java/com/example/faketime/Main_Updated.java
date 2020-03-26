package com.example.faketime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Main_Updated extends AppCompatActivity {

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;
    private static final String TAG = "asdfgh";

    Gson gson = new Gson();
    String json;
    List<String[]> contacts;
    String theme;

    @Override
    public void onCreate(Bundle savedInstanceState){

        mPrefs = getSharedPreferences("state", 0);
        mEdit = mPrefs.edit();
        json = mPrefs.getString("contacts", "");
        contacts = gson.fromJson(json, ArrayList.class);
        theme = mPrefs.getString("theme", "light");


        //Sets the theme
        if(theme.equals("dark")){
            setTheme(R.style.Dark);
        }else{
            setTheme(R.style.Light);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_updated);

        FloatingActionButton addContactButton = (FloatingActionButton) findViewById(R.id.addContactButton);
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addContact = new Intent(Main_Updated.this, AddContact.class);
                Main_Updated.this.startActivity(addContact);
            }
        });

        LinearLayout insideScroll = findViewById(R.id.scrollViewInternal);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView contactName = new TextView(this);
        contactName.setLayoutParams(params);
        Button callContact = new Button(this);
        Button messageContact = new Button(this);
        params.setMarginEnd(100);
        if(!(contacts == null)) {
            Log.v(TAG, "Contacts aren't null");
            for (String[] cur : contacts) {
                contactName.setText(cur[0]);
                Log.v(TAG, "Contact Name is " + contactName);
                insideScroll.addView(contactName);
                Log.v(TAG, "Added TextView to LinearLayout");
            }
        }else{
            Log.v(TAG, "Contacts ARE null");
        }


    }

}
