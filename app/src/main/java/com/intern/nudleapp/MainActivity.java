package com.intern.nudleapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.intern.nudleapp.rewards.RewardsFragment;
import com.intern.nudleapp.userAccount.SignInFragment;


public class MainActivity extends AppCompatActivity implements ProductAdapter.OnProductListener, BottomNavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView) findViewById(R.id.main_navbar);
        Toolbar mtool = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mtool);
        getSupportActionBar().setTitle("Nudle App");
        mtool.setLogo(R.drawable.applogo);


        loadFragment(new HomeFragment());

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);


        // The code for carousel view etc. is shifted to the class HomeFragment


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.menu_home);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menu_id = item.getItemId();
                switch (menu_id) {
                    case R.id.menu_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new HomeFragment()).commit();
                        break;
                    case R.id.menu_profile:
                        item.setChecked(true);
//                        Toast.makeText(MainActivity.this,"checked",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, ProfilePageActivity.class));
                        break;
                    case R.id.menu_share:
                        final String appPackageName = "NudleApp";
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT,
                                "** Playstore link ** " + appPackageName);
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);
                        break;
                    case R.id.menu_wishlist:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new MyWishlistFragment()).commit();
                        break;

                    case R.id.menu_rewards:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new RewardsFragment()).commit();
                        break;

                    case R.id.menu_share_cart:
//                        final String newlink = "NudleApp";
                        Intent sendShareIntent = new Intent();
                        sendShareIntent.setAction(Intent.ACTION_SEND);
                        sendShareIntent.putExtra(Intent.EXTRA_TEXT,
                                "" + "http://www.nudle.com/myCart");
                        sendShareIntent.setType("text/plain");
                        startActivity(sendShareIntent);
                        break;
                    /*case R.id.menu_cart:
                        FragmentManager fm = getSupportFragmentManager();
                        MyCartFragment myCartFragment = new MyCartFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_container, myCartFragment, "my-cart");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;*/
                    //case R.id.menu_shop_by_cat:
                    //    item.setChecked(true);
//                  //      Toast.makeText(MainActivity.this,"checked",Toast.LENGTH_LONG).show();
                    //    startActivity(new Intent(MainActivity.this, ProductDetailsActivity.class));
                    //    break;
                    //Commenting login from navigation menu as this is viewd only after user logs in
                    /*
                    case R.id.menu_login:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new SignInFragment()).commit();
                        break;

                     */
                    case R.id.menu_orders:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new MyOrderFragment()).commit();
                        break;
                    case R.id.menu_account:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new MyAccountFragment()).commit();

                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_and_cart,menu);
        return true;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_dashboard:
                fragment = new CategoryFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new NotificationFragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    // this for the appBar actions
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.main_cart_icon) {
            item.setChecked(true);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
            new MyCartFragment()).commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProductClick() {
        Log.i("checkstuff", "Clicked");
    }


}
