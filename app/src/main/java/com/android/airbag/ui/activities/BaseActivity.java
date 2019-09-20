package com.android.airbag.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.airbag.R;
import com.android.airbag.ui.activities.bags_list.BagListActivity;
import com.android.airbag.ui.activities.complaints.ComplaintsActivity;
import com.android.airbag.ui.activities.login.LoginActivity;
import com.android.airbag.ui.activities.notifications.NotificationsActivity;
import com.android.airbag.ui.activities.profile_settings.ProfileSettingsActivity;
import com.android.airbag.ui.activities.promo_code.PromoCodeActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "BaseActivity";
    protected NavigationView navigationView;
    AlertDialog logoutDialog;

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
                if (getNavigationMenuItemId() == R.id.navigation_notifications){
                    Toast.makeText(this, "You are in notifications activity", Toast.LENGTH_SHORT).show();
                    return false;
                }
                startActivity(new Intent(this, NotificationsActivity.class));
                break;

            case R.id.navigation_profile_settings:
                startActivity(new Intent(this, ProfileSettingsActivity.class));
                break;

            case R.id.navigation_received_items:
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_promo_code:

                if (getNavigationMenuItemId() == R.id.navigation_promo_code){
                    Toast.makeText(this, "You in Promo Code", Toast.LENGTH_SHORT).show();
                    return false;
                }
                startActivity(new Intent(this, PromoCodeActivity.class));
                break;

            case R.id.navigation_complaints:
                startActivity(new Intent(this, ComplaintsActivity.class));
                break;

            case R.id.navigation_logout:
                showLogoutDialog();
                break;



        }
        return false;
    }
    private void showLogoutDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.log_out_dialog,null);

        Button agreeButton = view.findViewById(R.id.yes_btn);
        Button cancelButton = view.findViewById(R.id.cancel_btn);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutDialog.dismiss();
            }
        });
        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseActivity.this, LoginActivity.class));
                finish();
            }
        });

        builder.setView(view);

        logoutDialog = builder.create();
        logoutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        logoutDialog.show();
    }

    public abstract int getContentViewId();
    public abstract int getNavigationMenuItemId();
}
