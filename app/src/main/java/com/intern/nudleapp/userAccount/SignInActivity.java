package com.intern.nudleapp.userAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.intern.nudleapp.APIClient;
import com.intern.nudleapp.MainActivity;

import com.google.android.material.textfield.TextInputLayout;

import com.intern.nudleapp.NudleServices;
import com.intern.nudleapp.R;
import com.intern.nudleapp.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignInActivity extends AppCompatActivity {

    TextView text_SignUp;

    private TextInputLayout user_email, user_password;
    private String inputEmail, inputPassword;
    private Button button_signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        user_email = findViewById(R.id.user_email_SignIn);
        user_password = findViewById(R.id.user_password_SignIn);
        button_signIn = findViewById(R.id.button_SignIn);

        button_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSession();
            }
        });

        text_SignUp = findViewById(R.id.textView_SignUp);
        text_SignUp.setPaintFlags(text_SignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        text_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
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

    public void createSession() {
        if(!validateEmail() | !validatePassword())
            return;

        startActivity(new Intent(SignInActivity.this, MainActivity.class));

        // The following code is for registration into the database using retrofit
        // Do not make any changes in it as of now

       /* Retrofit retrofit = APIClient.getRetrofitInstance();
        NudleServices nudleServices = retrofit.create(NudleServices.class);

        Call<UserResponse> call = nudleServices.getUserDetails(inputEmail);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                try {
                    UserResponse mUserResponse = response.body();
                    if(mUserResponse.getCode() == 200) {
                        if(mUserResponse.getResult().getPassword().equals(inputPassword))
                            startActivity(new Intent(SignInActivity.this, MainActivity.class));
                        else
                            user_password.setError("Incorrect password!");
                    } else {
                        Toast.makeText(SignInActivity.this, "Register yourself", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(SignInActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }); */

    }
}
