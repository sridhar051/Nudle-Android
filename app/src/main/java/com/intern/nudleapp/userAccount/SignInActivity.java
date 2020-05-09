package com.intern.nudleapp.userAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import com.intern.nudleapp.R;

public class SignInActivity extends AppCompatActivity {

    TextView text_SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        text_SignUp = findViewById(R.id.textView_SignUp);
        text_SignUp.setPaintFlags(text_SignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }
}
