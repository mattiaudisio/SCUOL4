package com.example.qrcode_audisio;

import androidx.appcompat.app.AppCompatActivity;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.zxing.Result;

public class ScanQr extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;
    public SitiWeb sitiweb = null;
    private TextView txtRis =null;
    public MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(scannerView);
        scannerView = new ZXingScannerView(this);
    }

    @Override
    public void handleResult(Result result) {
        mainActivity.txtRisultato.setText(result.getText());
        txtRis = MainActivity.txtRisultato;
        onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
        sitiweb.setUrl(txtRis);
    }
}
