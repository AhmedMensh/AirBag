package com.android.airbag.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.airbag.R;
import com.android.airbag.ui.activities.bags_list.BagListActivity;
import com.android.airbag.ui.activities.complaints.ComplaintsActivity;
import com.android.airbag.ui.activities.profile_settings.ProfileSettingsActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "BaseActivity";
    protected NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.navigation_my_bags:
                if (getNavigationMenuItemId() == R.id.navigation_my_bags){
                    Toast.makeText(this, "You are in bag list ", Toast.LENGTH_SHORT).show();
                    return false;
                }
                startActivity(new Intent(this, BagListActivity.class));
                break;

            case R.id.navigation_notifications:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_profile_settings:
                startActivity(new Intent(this, ProfileSettingsActivity.class));
                break;

            case R.id.navigation_received_items:
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_promo_code:
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_complaints:
                startActivity(new Intent(this, ComplaintsActivity.class));
                break;



        }
        return false;
    }

    public abstract int getContentViewId();
    public abstract int getNavigationMenuItemId();
}
