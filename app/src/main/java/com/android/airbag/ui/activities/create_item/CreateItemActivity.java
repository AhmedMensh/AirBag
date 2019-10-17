package com.android.airbag.ui.activities.create_item;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
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

public class CreateItemActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "CreateItemActivity";
    private Unbinder unbinder;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.menu_icon)
    ImageView menuIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);

        unbinder = ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(this);
        menuIcon.setOnClickListener(this);
        Utilities.changeUserType(navigationView,this);


        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1){

            navigationView.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.orange)));
        }
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_create_bag;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_my_bags;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.menu_icon:
                if (!drawer.isDrawerOpen(GravityCompat.START))
                    drawer.openDrawer(GravityCompat.START);
                break;


        }
    }
}
