package com.intern.nudleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import android.widget.ImageView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{
    NavigationView navigationView;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private int[] mimages=new int[]{
            R.drawable.sale1,R.drawable.sale2,R.drawable.sale3
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = (NavigationView)findViewById(R.id.main_navbar);
        Toolbar mtool = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(mtool);
        mtool.setTitle("Nudle App");

        mdrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mdrawerLayout,R.string.open,R.string.close);
        mdrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int menu_id = item.getItemId();
                switch (menu_id){
                    case R.id.menu_account:
                        item.setChecked(true);
//                        Toast.makeText(MainActivity.this,"checked",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this,ProfilePageActivity.class));
                }
                return true;
            }
        });
        CarouselView carouselView=findViewById(R.id.carousel);
        carouselView.setPageCount(mimages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mimages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
