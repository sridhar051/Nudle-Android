package com.intern.nudleapp.userAccount;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.intern.nudleapp.MainActivity;
import com.intern.nudleapp.R;

public class SignInFragment extends Fragment {

    TextView text_SignUp;

    private TextInputLayout user_email, user_password;
    private String inputEmail, inputPassword;
    private Button button_signIn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        user_email = view.findViewById(R.id.user_email_SignIn);
        user_password = view.findViewById(R.id.user_password_SignIn);


        text_SignUp = view.findViewById(R.id.textView_SignUp);

        text_SignUp.setPaintFlags(text_SignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        text_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SignUpActivity.class));
            }
        });

        button_signIn = view.findViewById(R.id.button_SignIn);
        button_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSession();
            }
        });

        return view;
    }

    private void createSession() {
        if(!validateEmail() | !validatePassword())
            return;

        startActivity(new Intent(getContext(), MainActivity.class));


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
                        if(mUserResponse.getResult().getSession() == 1)
                            startActivity(new Intent(SignInActivity.this, MainActivity.class));
                        else {
                            if(mUserResponse.getResult().getPassword().equals(inputPassword))
                                startActivity(new Intent(SignInActivity.this, MainActivity.class));
                            else
                                user_password.setError("Incorrect password!");
                        }

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

    private boolean validateEmail() {
        inputEmail = user_email.getEditText().getText().toString().trim();
        if(inputEmail.isEmpty()) {
            user_email.setError("*  PLEASE TYPE YOUR EMAIL!!");
            return false;
        } else {
            user_email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        inputPassword = user_password.getEditText().getText().toString().trim();
        if(inputPassword.isEmpty()) {
            user_password.setError("*  PLEASE TYPE YOUR PASSWORD!!");
            return false;
        } else {
            user_password.setError(null);
            return true;
        }
    }
}
