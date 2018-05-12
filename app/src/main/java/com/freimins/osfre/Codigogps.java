package com.freimins.osfre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class Codigogps extends AppCompatActivity implements ZBarScannerView.ResultHandler {
    private final static String TAG="Scannerlog";
    private ZBarScannerView mScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZBarScannerView(this);
        setContentView(mScannerView);
    }
    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }
    @Override
    public void handleResult(Result result) {
        Log.v(TAG,result.getContents());//imprime el valor del codigo - para verlo en el logcat se filtra con V/Scannerlog:
        Log.v(TAG, result.getBarcodeFormat().getName());// imprime el tipo de codigo
        Intent intent= new Intent(Codigogps.this, MainActivity.class);
        startActivity(intent);

    }
}
