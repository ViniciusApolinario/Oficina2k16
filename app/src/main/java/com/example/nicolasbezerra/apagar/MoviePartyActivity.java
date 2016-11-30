package com.example.nicolasbezerra.apagar;


import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;


public class MoviePartyActivity extends AppCompatActivity{

    Bundle extra;
    String URL;
    VideoView vidView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_main);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#5c3f69"));
        vidView = (VideoView)findViewById(R.id.myVideo);
        extra = getIntent().getExtras();
        URL = extra.getString("I_need_that");
        String vidAddress = URL;
        Uri vidUri = Uri.parse(vidAddress);
        vidView.setVideoURI(vidUri);
        vidView.start();
        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);
    }




}

