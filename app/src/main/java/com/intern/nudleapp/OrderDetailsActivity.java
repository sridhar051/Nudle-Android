package com.intern.nudleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.intern.nudleapp.Cart_Fragment.MyCartFragment;

public class OrderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("OrderDetails");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_and_cart, menu);
        return true;
    }

    public boolean OnOptionsItemSlected(MenuItem item){

        if(item.getItemId() == android.R.id.home){
            finish();
            // todo have a doubt on this its not giving action
            return true;
        }
        if(item.getItemId() == R.id.main_search_icon){
            //TODO search icon
            return true;
        }
        if(item.getItemId() == R.id.main_cart_icon){
           //TODO cart Action
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

