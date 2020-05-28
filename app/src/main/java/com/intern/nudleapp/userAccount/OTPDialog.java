package com.intern.nudleapp.userAccount;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.intern.nudleapp.R;

public class OTPDialog extends AppCompatDialogFragment {

    private EditText user_otp;
    private Button button_verify;
    private CustomDialogListener listener;
    //SMSBroadcastReceiver smsBroadcastReceiver = null;
    private String otp;

    OTPDialog(String otp) {
        this.otp = otp;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.otp_dialog, null);
        builder.setView(view);

        user_otp = view.findViewById(R.id.user_otp);
        user_otp.setText(otp);

        button_verify = view.findViewById(R.id.button_verify);

        //smsBroadcastReceiver = new SMSBroadcastReceiver();
        //smsBroadcastReceiver.setOnOtpListeners(user_otp);



        button_verify.setOnClickListener(v -> listener.onOTPVerification());

        return builder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (CustomDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement the custom dialog listener");
        }

    }

    public interface CustomDialogListener {
        void onOTPVerification();
    }
}
