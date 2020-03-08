package com.example.faketime;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

//ths is the code that gets run when a call is made
public class CallPage extends AppCompatActivity {

    private final String TAG = "asdfghj.java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_preview);

        Log.v(TAG, "Called the onCreate method");
        View view = (View) findViewById(R.id.VideoPreview);
        View parent = (View) view.getParent();
        int parent_width = parent.getWidth();
        int parent_height = parent.getHeight();

        Log.v(TAG, "Created the view");

        //sizes the preview window to be the right size
        VideoView video = (VideoView) findViewById(R.id.VideoView);
        VideoView preview = (VideoView) findViewById(R.id.VideoPreview);
        LayoutParams preview_layout = (LayoutParams) preview.getLayoutParams();
        preview_layout.width = parent_width/4;
        preview_layout.height = parent_height/4;

        Log.v(TAG, "Changed preview dimensions");
//        preview.setBackground(drawable.);

    }

}
