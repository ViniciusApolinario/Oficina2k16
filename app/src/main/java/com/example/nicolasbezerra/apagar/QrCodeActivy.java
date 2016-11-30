package com.example.nicolasbezerra.apagar;


import android.app.AlertDialog;
import android.content.DialogInterface;
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
    private String LinkV1;
    private String LinkV2;
    private String LinkV3;

    private String QCFeedback1;
    private String QCFeedback2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        LinkV2 = "https://ia801502.us.archive.org/24/items/nroipd0002/Doc-V3-CorParcial.mp4";
        LinkV1 = "https://ia601503.us.archive.org/7/items/nroipd0001/CurtaBanheiro-Corte00-1.mp4";
        LinkV3 = "";

        QCFeedback1 = "Baixe o Descubra no NAVE #grumete";
        QCFeedback2 = "Baixe o App no NAVE #grumete";

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

        if(rawResult.getText().equals(QCFeedback1))
        {
            onPause();
            TextOnQrcode = LinkV1;
            Intent x = new Intent(this,MoviePartyActivity.class);
            x.putExtra("I_need_that", TextOnQrcode);
            startActivity(x);
            finish();
        }
        if(rawResult.getText().equals(QCFeedback2)) {
            onPause();
            TextOnQrcode = LinkV2;
            Intent x = new Intent(this,MoviePartyActivity.class);
            x.putExtra("I_need_that", TextOnQrcode);
            startActivity(x);
            finish();
        }
        else if(rawResult.getText() != QCFeedback1 || rawResult.getText() != QCFeedback2 )
        {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Erro");
            alertDialog.setMessage("QrCode não pertencente ao projeto");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialog.show();
        }



        // If you would like to resume scanning, call this method below:
        // mScannerView.resumeCameraPreview(this);
    }
}
