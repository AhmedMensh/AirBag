package com.android.airbag.ui.activities.payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.airbag.R;
import com.android.airbag.ui.activities.BaseActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PaymentActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "PaymentActivity";
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
        setContentView(R.layout.activity_payment);

        unbinder = ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(this);
        menuIcon.setOnClickListener(this::onClick);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_payment;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_payment_wallet;
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
