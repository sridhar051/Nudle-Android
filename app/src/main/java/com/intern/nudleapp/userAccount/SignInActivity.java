package com.intern.nudleapp.userAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.intern.nudleapp.MainActivity;

import com.google.android.material.textfield.TextInputLayout;

import com.intern.nudleapp.R;

public class SignInActivity extends AppCompatActivity {

    TextView text_SignUp;

    Button sign_in;

    private TextInputLayout user_email, user_password;
    private String inputEmail, inputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        user_email = findViewById(R.id.user_email_SignIn);
        user_password = findViewById(R.id.user_password_SignIn);

        text_SignUp = findViewById(R.id.textView_SignUp);
        text_SignUp.setPaintFlags(text_SignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        text_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
        sign_in = findViewById(R.id.button_SignIn);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, MainActivity.class));
            }
        });

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

    public void createSession(View v) {
        if(!validateEmail() | !validatePassword())
            return;

        String input = "Email: " + user_email.getEditText().getText().toString().trim() + "\n";
        input = input + "Password: " + user_password.getEditText().getText().toString().trim();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}
