package com.intern.nudleapp.userAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.intern.nudleapp.R;

public class OTPActivity extends AppCompatActivity {

    private CountryCodePicker countryCodePicker;
    private TextInputLayout user_mobile, user_otp;
    private String inputMobile, inputOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);

        init();

    }

    private void init() {
        countryCodePicker = findViewById(R.id.ccp);
        user_mobile = findViewById(R.id.user_mobile_SignUp);
        user_otp = findViewById(R.id.user_otp);
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
        Toast.makeText(this, countryCodePicker.getFullNumber() + inputMobile, Toast.LENGTH_SHORT).show();
    }
}