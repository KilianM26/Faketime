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

import androidx.appcompat.app.AppCompatActivity;

public class Main_Updated extends AppCompatActivity {

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;
    private static final String TAG = "asdfgh";

    Gson gson = new Gson();
    String json;
    ArrayList<String> contacts;
    String theme;

    @Override
    public void onCreate(Bundle savedInstanceState){

        mPrefs = getSharedPreferences("state", 0);
        mEdit = mPrefs.edit();
        json = mPrefs.getString("contacts", "");
        Log.v(TAG, json);
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

        LinearLayout mainScroll = findViewById(R.id.scrollViewInternal);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.setMarginEnd(100);

        if(!(contacts == null)) {
            for (final String cur: contacts) {

                LinearLayout insideScroll = new LinearLayout(this);
                final TextView contactName = new TextView(this);
                String[] split = cur.split("/");
                final String name = split[0];
                final String address = split[1];

                Button callContact = new Button(this);
                Button messageContact = new Button(this);
                callContact.setLayoutParams(buttonParams);
                messageContact.setLayoutParams(buttonParams);
                callContact.setBackground(getResources().getDrawable(R.drawable.video_call_black));
                messageContact.setBackground(getResources().getDrawable(R.drawable.message_black));
                callContact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callContact = new Intent(Main_Updated.this, CallPage.class);
                        callContact.putExtra("contact", cur);
                        Main_Updated.this.startActivity(callContact);
                    }
                });
                messageContact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent messageContact = new Intent(Main_Updated.this, Messages.class);
                        messageContact.putExtra("contact", cur);
                        Main_Updated.this.startActivity(messageContact);
                    }
                });

                insideScroll.setOrientation(LinearLayout.HORIZONTAL);
                contactName.setLayoutParams(textParams);
                contactName.setTextAppearance(R.style.contactTextView);
                contactName.setText(cur);
                insideScroll.addView(contactName);
                insideScroll.addView(callContact);
                insideScroll.addView(messageContact);
                mainScroll.addView(insideScroll);
            }
        }else{
            Log.v(TAG, "Contacts ARE null");
        }


    }

}
