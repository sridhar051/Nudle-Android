package com.intern.nudleapp.userAccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;

public class SMSBroadcastReceiver extends BroadcastReceiver {

    private EditText user_otp;

    public void setOnOtpListeners(EditText user_otp) {
        this.user_otp = user_otp;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

        for(SmsMessage sms : messages) {
            String message = sms.getMessageBody();
            String otp = message.split(": ")[1];
            user_otp.setText(otp);
        }
    }
}
