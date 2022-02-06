package com.example.a5caudisioqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class CameraQR extends AppCompatActivity {

    private Button btnCamera = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_qr);
        btnCamera = findViewById(R.id.btnCamera);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent);
            }
        });
    }

    protected void onActivityResult(int ){

    }
}
