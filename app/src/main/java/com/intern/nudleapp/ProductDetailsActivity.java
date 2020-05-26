package com.intern.nudleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImagesViewPager;
    private TabLayout viewpagerIndicator;
    private ViewPager productDetailsViewpager;
    private TabLayout productDetailsTablayout;



    //////rating layout
    private LinearLayout rateNowContainer;
    //////rating layout
    private static boolean ALREADY_ADDED_TO_WISHLIST = false;
    private FloatingActionButton addToWishListBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar mtool = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtool);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImagesViewPager = findViewById(R.id.viewPager);
        viewpagerIndicator = findViewById(R.id.viewpager_indicator);
        addToWishListBtn = findViewById(R.id.add_to_wish_list_button);
        productDetailsViewpager = findViewById(R.id.product_details_viewpager);
        productDetailsTablayout = findViewById(R.id.product_details_tablayout);


        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.shop1);
        productImages.add(R.drawable.shop2);
        productImages.add(R.drawable.shop3);
        productImages.add(R.drawable.happy_shopping);
        //TODO add images into the list for the product details activity

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);
         viewpagerIndicator.setupWithViewPager(productImagesViewPager,true);
         addToWishListBtn.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View view) {

                 if(ALREADY_ADDED_TO_WISHLIST){
                     ALREADY_ADDED_TO_WISHLIST = false;
                     addToWishListBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                 }
                 else{
                     ALREADY_ADDED_TO_WISHLIST = true;
                     addToWishListBtn.setSupportImageTintList(getResources().getColorStateList(R.color.colorPrimary));
                 }

             }

         });

        productDetailsViewpager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(),productDetailsTablayout.getTabCount()));

        productDetailsViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));
        productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ////////rating layout
        rateNowContainer = findViewById(R.id.rate_now_container);
        for ( int x=0;x < rateNowContainer.getChildCount();x++){
            final int starPosition = x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    setRating(starPosition);
                }
            });
        }
        ////////rating layput
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_and_cart, menu);
        return true;
    }
    public boolean OnOptionsItemSlected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){

            return true;
        }
        if(id == R.id.main_search_icon){
            //TODO search icon
            return true;
        }
        if(id == R.id.main_cart_icon){
            startActivity(new Intent(this, MyOrderFragment.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setRating(int starPosition) {
        for(int x = 0; x < rateNowContainer.getChildCount(); x++){
            ImageView starBtn = (ImageView)rateNowContainer.getChildAt(x);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if(x <= starPosition){
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }
}
