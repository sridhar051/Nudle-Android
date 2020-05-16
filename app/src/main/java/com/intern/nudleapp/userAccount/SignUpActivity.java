package com.intern.nudleapp.userAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.intern.nudleapp.R;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout user_email, user_mobile, user_password, user_confirmed_password;
    private String inputEmail, inputMobile, inputPassword, inputConfirmedPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user_email = findViewById(R.id.user_email_SignUp);
        user_mobile = findViewById(R.id.user_mobile_SignUp);
        user_password = findViewById(R.id.user_password_SignUp);
        user_confirmed_password = findViewById(R.id.user_confirm_password_SignUp);

        Button button_sign_up = findViewById(R.id.button_SignUp);
    }

    private boolean validateEmail() {
        inputEmail = user_email.getEditText().getText().toString().trim();
        if(inputEmail.isEmpty()) {
            user_email.setError("!Please type your Email");
            return false;
        } else {
            user_email.setError(null);
            return true;
        }
    }

    private boolean validateMobile() {
        inputMobile = user_mobile.getEditText().getText().toString().trim();
        if(inputMobile.isEmpty()) {
            user_mobile.setError("!Please type your Mobile");
            return false;
        } else {
            user_mobile.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        inputPassword = user_password.getEditText().getText().toString().trim();
        if(inputPassword.isEmpty()) {
            user_password.setError("!Please type your password");
            return false;
        } else {
            user_password.setError(null);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        inputConfirmedPassword = user_confirmed_password.getEditText().getText().toString().trim();
        if(inputConfirmedPassword.isEmpty()) {
            user_confirmed_password.setError("!Please confirm your password");
            return false;
        } else if (!inputConfirmedPassword.equals(inputPassword)) {
            user_confirmed_password.setError("Password doesn't match!");
            return false;
        } else {
            user_confirmed_password.setError(null);
            return true;
        }
    }

    public void registerUser(View v) {
        if(!validateEmail() | !validateMobile() | !validatePassword() | !validateConfirmPassword())
            return;

        String input = "Email: " + user_email.getEditText().getText().toString().trim() + "\n";
        input = input + "Mobile: " + user_mobile.getEditText().getText().toString().trim() + "\n";
        input = input + "Password: " + user_password.getEditText().getText().toString().trim();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }



}
