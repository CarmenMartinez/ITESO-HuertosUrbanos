package com.vendedor.sesion22_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        if (msgs != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            String str = "";
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i ++) {
                SmsMessage[] mensajes = Telephony.Sms.Intents.getMessagesFromIntent(intent);
                msgs[i] = mensajes[i];
                str += msgs[i];
                String phoneNumber = msgs[i].getDisplayOriginatingAddress();
            }
            Toast.makeText(context, str, Toast.LENGTH_LONG).show();
        }
    }
}
