package com.example.NVBookstore.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.NVBookstore.Fragment.CartFragment;
import com.example.NVBookstore.Fragment.CategoryFragment;
import com.example.NVBookstore.Fragment.HomeFragment;
import com.example.NVBookstore.Fragment.ProfileFragment;
import com.example.NVBookstore.Fragment.WishlistFragment;
import com.example.NVBookstore.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    break;
                case R.id.navigation_wishlist:
                    fragment = new WishlistFragment();
                    loadFragment(fragment);

                    break;
                case R.id.navigation_category:
                    fragment = new CategoryFragment();
                    loadFragment(fragment);
                    break;
                case R.id.navigation_cart:
                    fragment = new CartFragment();
                    loadFragment(fragment);
                    break;
                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    break;
            }
            return false;
        }
    };
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);


        navigation =findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (getIntent().getStringExtra("back") != null) {
            if (getIntent().getStringExtra("back").equalsIgnoreCase("data")) {
                fragment = new HomeFragment();
                loadFragment(fragment);
            }

        } else {
            fragment = new HomeFragment();

            loadFragment(fragment);
        }
    }
    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Content_view, fragment);
        transaction.addToBackStack("" + fragment);
        String a = "" + getFragmentManager().getBackStackEntryCount();
        transaction.commit();
    }
}
