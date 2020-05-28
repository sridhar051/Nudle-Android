package com.intern.nudleapp.userAccount;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.intern.nudleapp.APIClient;
import com.intern.nudleapp.NudleServices;
import com.intern.nudleapp.R;
import com.intern.nudleapp.models.UserResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUpActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        OTPReceive, GoogleApiClient.OnConnectionFailedListener, OTPDialog.CustomDialogListener {

    private TextInputLayout user_name, user_email, user_password, user_confirmed_password, user_mobile;
    private String inputName, inputEmail, inputMobile, inputPassword, inputConfirmedPassword;
    private GoogleApiClient mGoogleApiClient;
    private int RESOLVE_HINT = 2;
    OTPDialog mOTPDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user_mobile = findViewById(R.id.user_mobile);
        user_email = findViewById(R.id.user_email_SignUp);
        user_name = findViewById(R.id.user_name_SignUp);
        user_password = findViewById(R.id.user_password_SignUp);
        user_confirmed_password = findViewById(R.id.user_confirm_password_SignUp);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .enableAutoManage(this, this)
                .addApi(Auth.CREDENTIALS_API)
                .build();

        getMobileNumber();

    }

    private boolean validateEmail() {
        inputEmail = user_email.getEditText().getText().toString().trim();
        if(inputEmail.isEmpty()) {
            user_email.setError("*  PLEASE TYPE IN YOUR EMAIL!!");
            return false;
        } else {
            user_email.setError(null);
            return true;
        }
    }

    private boolean validateName() {
        inputName = user_name.getEditText().getText().toString().trim();
        if(inputName.isEmpty()) {
            user_name.setError("*  PLEASE TYPE IN YOUR NAME!!");
            return false;
        } else {
            user_name.setError(null);
            return true;
        }
    }

    private boolean validateMobile() {
        inputMobile = user_mobile.getEditText().getText().toString().trim();
        if(inputMobile.isEmpty()) {
            user_mobile.setError("*  PLEASE TYPE IN YOUR MOBILE NUMBER!!");
            return false;
        } else {
            user_mobile.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        inputPassword = user_password.getEditText().getText().toString().trim();
        if(inputPassword.isEmpty()) {
            user_password.setError("*  PLEASE TYPE IN YOUR MOBILE NUMBER!!");
            return false;
        } else {
            user_password.setError(null);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        inputConfirmedPassword = user_confirmed_password.getEditText().getText().toString().trim();
        if(inputConfirmedPassword.isEmpty()) {
            user_confirmed_password.setError("*  PLEASE CONFIRM YOUR PASSWORD!!");
            return false;
        } else if (!inputConfirmedPassword.equals(inputPassword)) {
            user_confirmed_password.setError("*  PASSWORD DOES NOT MATCH!!");
            return false;
        } else {
            user_confirmed_password.setError(null);
            return true;
        }
    }

    public void verifyUser(View v) {
        if(!validateName() | !validateEmail() | !validateMobile() | !validatePassword() | !validateConfirmPassword())
            return;

      /*  int randomNumber = new Random().nextInt(999999);
        Retrofit retrofit = APIClient.getRetrofitInstance();
        NudleServices nudleServices = retrofit.create(NudleServices.class);
        Call call = nudleServices.getOTP("T7pzDxlc2Oc-Sc4lHgnfkJca9KReGfcDgTCnfpjYdo", inputMobile, "Your otp : " + randomNumber,
                "TXTLCL");

        new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

                for (SmsMessage sms : messages) {
                    String message = sms.getMessageBody();
                    String otp = message.split(": ")[1];
                    mOTPDialog = new OTPDialog(otp);
                    mOTPDialog.show(getSupportFragmentManager(), "Dialog");

                }

            }
        };

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        }); */

        //startSMSListener();

        //startActivity(new Intent(this, MainActivity.class));

        // The following code is for registration into the database using retrofit
        // Do not make any changes in it as of now

        /*Retrofit retrofit = APIClient.getRetrofitInstance();
        NudleServices nudleServices = retrofit.create(NudleServices.class);

        Call<UserResponse> call = nudleServices.postUserDetails(inputName, inputEmail, inputMobile, inputPassword);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse mUserResponse = response.body();
                if (mUserResponse.getCode() == 201) {
                    Toast.makeText(SignUpActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(SignUpActivity.this, "Some server issue. Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        }); */

    }

    public void getMobileNumber() {
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

        if(requestCode == RESOLVE_HINT) {
            if(resultCode == Activity.RESULT_OK) {
                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                user_mobile.getEditText().setText(credential.getId());
            }
        }
    }

    public void startSMSListener() {
        SmsRetrieverClient smsRetrieverClient = SmsRetriever.getClient(this);
        Task<Void> mTask = smsRetrieverClient.startSmsRetriever();
        mTask.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
        mTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
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

    @Override
    public void onOTPVerification() {
        Toast.makeText(this, "Verified", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOtpReceived(String otp) {

    }

    @Override
    public void onOtpTimeout() {
        Toast.makeText(this, "Time out, please resend", Toast.LENGTH_LONG).show();
    }

    public void onBackPress(View v) {
        onBackPressed();
    }

}
