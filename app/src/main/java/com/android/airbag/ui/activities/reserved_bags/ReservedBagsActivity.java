package com.android.airbag.ui.activities.reserved_bags;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.airbag.R;
import com.android.airbag.adapters.ReservedBagsAdapter;
import com.android.airbag.ui.activities.BaseActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ReservedBagsActivity extends BaseActivity implements View.OnClickListener, ReservedBagsAdapter.ItemClickListener {

    private static final String TAG = "ReservedBagsActivity";
    private boolean isReservedBagDetailsShown = false;
    private Unbinder unbinder;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.menu_icon)
    ImageView menuIcon;
    @BindView(R.id.reserved_bags_rv)
    RecyclerView reservedBagsRv;
    @BindView(R.id.reserved_bag_details_layout)
    ConstraintLayout reservedBagDetailsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_bags);

        unbinder = ButterKnife.bind(this);

        menuIcon.setOnClickListener(this::onClick);

        navigationView.setNavigationItemSelectedListener(this);

        intReservedBagsRv();
    }

    private void intReservedBagsRv() {
        reservedBagsRv.setLayoutManager(new LinearLayoutManager(this));
        reservedBagsRv.setHasFixedSize(true);
        reservedBagsRv.setAdapter(new ReservedBagsAdapter(this));
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            Log.e(TAG, "onBackPressed: nav is open");
        } else {
            if (isReservedBagDetailsShown) {
                Log.e(TAG, "onBackPressed: nav is closed");
                Log.e(TAG, "onBackPressed: details is show");
                reservedBagDetailsLayout.setVisibility(View.INVISIBLE);
                reservedBagsRv.setVisibility(View.VISIBLE);
            } else {

                Log.e(TAG, "onBackPressed: nav is closed");
                Log.e(TAG, "onBackPressed: rc is shown");
                super.onBackPressed();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_reserved_bags;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_reserved_items;
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

    @Override
    public void onBagItemClickListener(int itemPosition) {
        isReservedBagDetailsShown = true;
        reservedBagsRv.setVisibility(View.INVISIBLE);
        reservedBagDetailsLayout.setVisibility(View.VISIBLE);
    }
}
