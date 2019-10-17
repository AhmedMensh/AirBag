package com.android.airbag.ui.activities.promo_code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.airbag.R;
import com.android.airbag.helpers.Constants;
import com.android.airbag.helpers.SharedPreferencesManager;
import com.android.airbag.helpers.Utilities;
import com.android.airbag.ui.activities.BaseActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PromoCodeActivity extends BaseActivity implements View.OnClickListener{


    private static final String TAG = "PromoCodeActivity";
    private Unbinder unbinder;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.menu_icon)
    ImageView menuIcon;
    @BindView(R.id.share_btn)
    Button shareButton;
    @BindView(R.id.root_view_cl)
    ConstraintLayout rootViewCl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_code);

        unbinder = ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(this);
        menuIcon.setOnClickListener(this);
        Utilities.changeUserType(navigationView ,this);
        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) ==1){
            rootViewCl.setBackgroundResource(R.drawable.full_screen_background_orang);
            shareButton.setBackgroundResource(R.drawable.button_background_2);
            navigationView.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.orange)));
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_promo_code;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_promo_code;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.menu_icon:
                if (!drawer.isDrawerOpen(GravityCompat.START)) drawer.openDrawer(GravityCompat.START);
                break;
        }
    }
}
