package com.intern.nudleapp.ShareCart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.intern.nudleapp.R;

public class SharedCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_cart);

        Intent intent = getIntent();
        if (intent.getDataString().matches(
                "http:\\/\\/((www.)?)nudle.com\\/.*myCart")) {

            Toast.makeText(this,"Shared Cart",Toast.LENGTH_LONG).show();
            // is match - do stuff
        } else {
            // is not match - do other stuff
            CardView cardView = (CardView)findViewById(R.id.card_share);
            cardView.setVisibility(View.GONE);
        }

    }
}
