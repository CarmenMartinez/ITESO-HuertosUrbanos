package com.vendedor.sesion22_sms;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    protected EditText phone;
    protected EditText msg;
    protected Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (EditText) findViewById(R.id.activity_main_phone);
        msg = (EditText) findViewById(R.id.activity_main_message);
    }

    public void sendMessage() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.RECEIVE_SMS
                    }, 1999);
        } else {
            sendMessageNow();
        }
    }

    public void sendMessageNow() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(
                phone.getText().toString(),
                null,
                msg.getText().toString(),
                null,
                null
        );
        Toast.makeText(this, "SMS sent", Toast.LENGTH_LONG).show();
        phone.setText("");
        msg.setText("");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1999:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    sendMessageNow();
                }
        }
    }

    public void onClick(View v) {
        sendMessage();
    }
}

