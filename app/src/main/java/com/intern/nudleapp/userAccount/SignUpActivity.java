package com.intern.nudleapp.userAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.intern.nudleapp.APIClient;
import com.intern.nudleapp.MainActivity;
import com.intern.nudleapp.NudleServices;
import com.intern.nudleapp.R;
import com.intern.nudleapp.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout user_name, user_email, user_password, user_confirmed_password, user_mobile;
    private String inputName, inputEmail, inputMobile, inputPassword, inputConfirmedPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user_mobile = findViewById(R.id.user_mobile);
        user_email = findViewById(R.id.user_email_SignUp);
        user_name = findViewById(R.id.user_name_SignUp);
        user_password = findViewById(R.id.user_password_SignUp);
        user_confirmed_password = findViewById(R.id.user_confirm_password_SignUp);
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

    private boolean validateName() {
        inputName = user_name.getEditText().getText().toString().trim();
        if(inputName.isEmpty()) {
            user_name.setError("!Please type your Name");
            return false;
        } else {
            user_name.setError(null);
            return true;
        }
    }

    private boolean validateMobile() {
        inputMobile = user_mobile.getEditText().getText().toString().trim();
        if(inputMobile.isEmpty()) {
            user_mobile.setError("!Please type your mobile number");
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
        if(!validateName() | !validateEmail() | !validateMobile() | !validatePassword() | !validateConfirmPassword())
            return;

        startActivity(new Intent(this, MainActivity.class));
        finish();

        // The following code is for registration into the database using retrofit
        // Do not make any changes in it as of now

       /* Retrofit retrofit = APIClient.getRetrofitInstance();
        NudleServices nudleServices = retrofit.create(NudleServices.class);

        Call<UserResponse> call = nudleServices.postUserDetails(inputName, inputEmail, inputMobile, inputPassword);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse mUserResponse = response.body();
                if (mUserResponse.getCode() == 201) {
                    Toast.makeText(SignUpActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Some server issue. Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        }); */

    }

    public void onBackPress(View v) {
        onBackPressed();
    }



}
