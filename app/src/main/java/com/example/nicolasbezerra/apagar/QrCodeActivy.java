package com.example.nicolasbezerra.apagar;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;



public class QrCodeActivy extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    public static String TextOnQrcode;
    private ZXingScannerView mScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        View v = getWindow().getDecorView().getRootView();
        QrScanner(v);
    }

    public void QrScanner(View view){


        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);

        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();         // Start camera

    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here

        Log.e("handler", rawResult.getText()); // Prints scan results  >rawREsult.getText();
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        if(rawResult.getText().equals("https://ia801400.us.archive.org/31/items/taxi-turvy/taxi-turvy_512kb.mp4"))
        {
            onPause();
            TextOnQrcode = rawResult.getText();
            Intent x = new Intent(this,MoviePartyActivity.class);
            x.putExtra("I_need_that", TextOnQrcode);
            startActivity(x);
            finish();
        }
        else if(rawResult.getText().equals("https://ia800209.us.archive.org/20/items/ElephantsDream/ed_hd_512kb.mp4")) {
            onPause();
            TextOnQrcode = rawResult.getText();
            Intent x = new Intent(this,MoviePartyActivity.class);
            x.putExtra("I_need_that", TextOnQrcode);
            startActivity(x);
            finish();
        }



        // If you would like to resume scanning, call this method below:
        // mScannerView.resumeCameraPreview(this);
    }
}
