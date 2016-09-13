package com.example.nicolasbezerra.apagar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_main);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);


    }
}
