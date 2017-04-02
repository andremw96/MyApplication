package com.example.wijaya_pc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {
    EditText txtphoneNo;
    EditText txtMessage;
    String noHP;
    String isiPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        Button SMSBtn = (Button) findViewById(R.id.btnKirim);

        txtphoneNo = (EditText) findViewById(R.id.TxtHP);
        txtMessage = (EditText) findViewById(R.id.TxtPesan);

        SMSBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMS();
            }
        });
    }

    protected void sendSMS() {
        Log.i("Send SMS", "");
        noHP = txtphoneNo.getText().toString();
        isiPesan = txtMessage.getText().toString();

        //Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.addCategory(Intent.CATEGORY_DEFAULT);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.setData(Uri.parse("sms:" + noHP));
        smsIntent.putExtra("sms_body", isiPesan);

        //smsIntent.setData(Uri.parse("sms:"));
        //smsIntent.setType("vnd.android-dir/mms-sms");
        //smsIntent.putExtra("address", "12125551212");
        //smsIntent.putExtra("sms_body","Body of Message");

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending sms...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SmsActivity.this, "SMS gagal, coba lagi beberapa saat.", Toast.LENGTH_SHORT).show();
        }
    }
}
