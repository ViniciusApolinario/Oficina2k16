package com.example.nicolasbezerra.apagar;


import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.content.Intent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;


public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        host.setBackgroundColor(Color.parseColor("#5c3f69"));

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("",getResources().getDrawable(R.drawable.setaesquerda));
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Pervasivo");
        spec.setContent(R.id.tab2);
        spec.setIndicator("",getResources().getDrawable(R.drawable.pervasivoimage)); //<<--
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("",getResources().getDrawable(R.drawable.setadireita));
        host.addTab(spec);

        host.setCurrentTab(1);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void Moviescene(View v)
    {
        Intent i = new Intent(this,QrCodeActivy.class);
        startActivity(i);
    }


}

