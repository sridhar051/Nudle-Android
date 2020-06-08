package com.intern.nudleapp.userAccount;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.intern.nudleapp.R;

public class OTPActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{

    private CountryCodePicker countryCodePicker;
    private TextInputLayout user_mobile, user_otp;
    private TextView otp_resend;
    private String inputMobile, inputOTP;
    private Button button_getOTP;
    private int RESOLVE_HINT = 7;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);

        init();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .enableAutoManage(this, this)
                .addApi(Auth.CREDENTIALS_API)
                .build();

        getMobileNumber();

    }

    private void init() {
        countryCodePicker = findViewById(R.id.ccp);
        user_mobile = findViewById(R.id.user_mobile_SignUp);
        user_otp = findViewById(R.id.user_otp);
        otp_resend = findViewById(R.id.resend_otp);
        button_getOTP = findViewById(R.id.button_getOTP);
    }


    private void getMobileNumber() {
        HintRequest hintRequest = new HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build();

        PendingIntent pendingIntent = Auth.CredentialsApi.getHintPickerIntent(mGoogleApiClient,
                hintRequest);

        try {
            startIntentSenderForResult(pendingIntent.getIntentSender(), RESOLVE_HINT, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESOLVE_HINT) {
            if (resultCode == Activity.RESULT_OK) {
                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                String mobile_number = credential.getId().replace("+" + countryCodePicker.getFullNumber(), "");
                user_mobile.getEditText().setText(mobile_number);
            }
        }
    }


    private boolean validateMobile() {
        inputMobile = user_mobile.getEditText().getText().toString().trim();
        if (inputMobile.isEmpty()) {
            user_mobile.setError("*  PLEASE TYPE IN YOUR MOBILE NUMBER!!");
            return false;
        } else {
            if(inputMobile.length() != 10) {
                user_mobile.setError("*  MOBILE NUMBER SHOULD BE 10 DIGITS!!");
                return false;
            } else {
                user_mobile.setError(null);
                return true;
            }
        }
    }

    public void getOTP(View view) {
        if (!validateMobile())
            return;

        user_otp.setVisibility(View.VISIBLE);
        otp_resend.setVisibility(View.VISIBLE);
        button_getOTP.setText("VERIFY");
        Toast.makeText(this, countryCodePicker.getFullNumber(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}