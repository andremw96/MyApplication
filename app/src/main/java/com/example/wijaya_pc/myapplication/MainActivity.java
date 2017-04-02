package com.example.wijaya_pc.myapplication;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toSMS(View view) {
        Intent it = new Intent(this, SmsActivity.class);
        startActivity(it);
    }

    public void toWEB(View view) {
        Intent it = new Intent(this, WebActivity.class);
        startActivity(it);
    }

    public void toKAMERA(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    public void toMAP(View view) {
        Intent it = new Intent(this, MapActivity.class);
        startActivity(it);
    }

    public void toEMAIL(View view) {
        Intent it = new Intent(this, EmailActivity.class);
        startActivity(it);
    }
}
