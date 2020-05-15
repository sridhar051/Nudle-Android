package com.intern.nudleapp.userAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.intern.nudleapp.MainActivity;
import com.intern.nudleapp.R;

public class SignInActivity extends AppCompatActivity {

    TextView text_SignUp;
//    Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        text_SignUp = findViewById(R.id.textView_SignUp);
        text_SignUp.setPaintFlags(text_SignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        text_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
//        sign_in = findViewById(R.id.button_SignIn);
//        sign_in.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SignInActivity.this, MainActivity.class));
//            }
//        });

    }
}
