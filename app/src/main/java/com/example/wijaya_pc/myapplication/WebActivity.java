package com.example.wijaya_pc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity {
    EditText txtURL;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Button WebBtn = (Button) findViewById(R.id.btnBuka);

        txtURL = (EditText) findViewById(R.id.TxtLink);

        WebBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bukaURL();
            }
        });
    }

    protected void bukaURL() {
        URL = txtURL.getText().toString();
        if (!URL.startsWith("https://") && !URL.startsWith("http://")){
            URL = "http://" + URL;
        }

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
        startActivity(browserIntent);
    }


}
