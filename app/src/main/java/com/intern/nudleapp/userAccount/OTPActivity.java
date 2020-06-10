package com.intern.nudleapp.userAccount;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.IdentityProviders;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.intern.nudleapp.R;

public class OTPActivity extends AppCompatActivity {

    private CountryCodePicker countryCodePicker;
    private TextInputLayout user_mobile;
    private ConstraintLayout layout_otp;
    private EditText[] digits = new EditText[6];
    private TextView otp_resend;
    private String inputMobile, inputOTP;
    private Button button_getOTP;
    private int RESOLVE_HINT = 7;
    private CredentialsClient mCredentialsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);

        init();

        getMobileNumber();

    }

    private void init() {
        countryCodePicker = findViewById(R.id.ccp);
        user_mobile = findViewById(R.id.user_mobile_SignUp);
        otp_resend = findViewById(R.id.resend_otp);
        button_getOTP = findViewById(R.id.button_getOTP);

        mCredentialsClient = Credentials.getClient(this);

        layout_otp = findViewById(R.id.layout_otp);

        for (int digit = 0; digit < 6; digit++) {
            String id = "digit_" + (digit + 1);
            int resId = getResources().getIdentifier(id, "id", getPackageName());
            digits[digit] = findViewById(resId);
        }
    }


    private void getMobileNumber() {
        HintRequest hintRequest = new HintRequest.Builder()
                .setHintPickerConfig(new CredentialPickerConfig.Builder()
                        .setShowCancelButton(true)
                        .build())
                .setPhoneNumberIdentifierSupported(true)
                .build();

        PendingIntent pendingIntent = mCredentialsClient.getHintPickerIntent(hintRequest);

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

        layout_otp.setVisibility(View.VISIBLE);
        otp_resend.setVisibility(View.VISIBLE);
        button_getOTP.setText("VERIFY");
        Toast.makeText(this, countryCodePicker.getFullNumber(), Toast.LENGTH_SHORT).show();
    }

}