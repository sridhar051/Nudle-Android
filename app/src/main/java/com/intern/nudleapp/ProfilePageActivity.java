package com.intern.nudleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilePageActivity extends AppCompatActivity {
    private TextView mgoshop,mcart,mpoints,mgift,maddress,mlogout;
    private ImageView mProfilePic, mBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        mgoshop = (TextView)findViewById(R.id.profile_shopping);
        mcart = (TextView)findViewById(R.id.profile_cart);
        mgift = (TextView)findViewById(R.id.profile_gifts);
        maddress = (TextView)findViewById(R.id.profile_address);
        mpoints = (TextView)findViewById(R.id.profile_points);
        mlogout = (TextView)findViewById(R.id.profile_logout);
        mProfilePic = (ImageView)findViewById(R.id.user_profile_pic);
        mBackButton = (ImageView)findViewById(R.id.back);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mgoshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilePageActivity.this,MainActivity.class));
            }
        });
    }
}
