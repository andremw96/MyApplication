package com.example.wijaya_pc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {
    EditText txtPenerima;
    EditText txtJudul;
    EditText txtIsi;
    String Penerima;
    String Judul;
    String Isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        Button SMSBtn = (Button) findViewById(R.id.btnKirim);

        txtPenerima = (EditText) findViewById(R.id.txtPenerima);
        txtJudul = (EditText) findViewById(R.id.txtJudul);
        txtIsi = (EditText) findViewById(R.id.txtIsi);

        Button emailBtn = (Button) findViewById(R.id.btnKirimEmail);
        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    protected void sendEmail() {
        Penerima = txtPenerima.getText().toString();
        Judul = txtJudul.getText().toString();
        Isi = txtIsi.getText().toString();

       // String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { Penerima });
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, Judul);
        emailIntent.putExtra(Intent.EXTRA_TEXT, Isi);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
           // Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(EmailActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
