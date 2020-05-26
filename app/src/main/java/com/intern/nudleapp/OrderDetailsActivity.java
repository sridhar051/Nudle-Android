package com.intern.nudleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class OrderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Toolbar mtool = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mtool);
    }
    public boolean OnCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.search_and_cart,menu);
        return true;
    }
    public boolean OnOptionsItemSlected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
            return true;
        }
        if(id == R.id.main_search_icon){
            //TODO search icon
            return true;
        }
        if(id == R.id.main_cart_icon){
            //TODO cart icon
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

