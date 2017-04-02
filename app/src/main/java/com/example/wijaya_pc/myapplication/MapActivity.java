package com.example.wijaya_pc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapActivity extends AppCompatActivity {
    EditText txtAlamat;
    String alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Button MAPBtn = (Button) findViewById(R.id.btnLihatMap);

        txtAlamat = (EditText) findViewById(R.id.TxtAlamat);

        MAPBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LihatMap();
            }
        });
    }

    protected void LihatMap() {
        alamat = txtAlamat.getText().toString();

        Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(alamat));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
