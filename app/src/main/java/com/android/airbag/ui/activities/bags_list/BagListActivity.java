package com.android.airbag.ui.activities.bags_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.airbag.R;
import com.android.airbag.ui.activities.BaseActivity;
import com.android.airbag.ui.fragments.CreateBagFragment;
import com.android.airbag.ui.fragments.available_bags.AvailableBagsFragment;
import com.android.airbag.ui.fragments.filter.FilterFragment;
import com.android.airbag.ui.fragments.pending_items.PendingItemsFragment;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BagListActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "AvailableBagsActivity";
    private Unbinder unbinder;
    @BindView(R.id.available_bags_tv)
    TextView availableBagsTv;
    @BindView(R.id.pending_items_tv)
    TextView pendingItemsTv;
    @BindView(R.id.tab_indicator1)
    View tabIndicator1;
    @BindView(R.id.tab_indicator2)
    View tabIndicator2;
    @BindView(R.id.filter_iv)
    ImageView filterIv;
    @BindView(R.id.tabs_icon_layout)
    LinearLayout tabsIconLayout;
    @BindView(R.id.tabs_indicator_layout)
    LinearLayout tabsIndicatorLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.menu_icon) ImageView menuIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag_list);


        unbinder = ButterKnife.bind(this);
        availableBagsTv.setOnClickListener(this::onClick);
        pendingItemsTv.setOnClickListener(this::onClick);
        filterIv.setOnClickListener(this::onClick);
        menuIcon.setOnClickListener(this::onClick);
        attachAvailableBagsFragment();

        navigationView.setNavigationItemSelectedListener(this);




    }

    private void attachAvailableBagsFragment() {
        AvailableBagsFragment availableBagsFragment = new AvailableBagsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment_container, availableBagsFragment);
        transaction.commit();
    }

    private void attachFilterFragment() {
        FilterFragment fragment = new FilterFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();


    }

    private void attachPendingItemsFragment() {
        PendingItemsFragment fragment = new PendingItemsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();


    }


        public void attachCreateItemsFragment() {
        CreateBagFragment fragment = new CreateBagFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
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
    public int getContentViewId(){
        return R.layout.activity_bag_list;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_my_bags;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.available_bags_tv:
                tabIndicator1.setVisibility(View.VISIBLE);
                tabIndicator2.setVisibility(View.INVISIBLE);
                availableBagsTv.setTextColor(getResources().getColor(R.color.blue_dark));
                pendingItemsTv.setTextColor(getResources().getColor(R.color.grey));
                attachAvailableBagsFragment();
                break;

            case R.id.pending_items_tv:
                tabIndicator1.setVisibility(View.INVISIBLE);
                tabIndicator2.setVisibility(View.VISIBLE);
                availableBagsTv.setTextColor(getResources().getColor(R.color.grey));
                pendingItemsTv.setTextColor(getResources().getColor(R.color.blue_dark));
                attachPendingItemsFragment();
                break;

            case R.id.filter_iv:
                attachFilterFragment();
                tabsIconLayout.setVisibility(View.GONE);
                tabsIndicatorLayout.setVisibility(View.GONE);
                break;

            case R.id.menu_icon:
                if (!drawer.isDrawerOpen(GravityCompat.START)) drawer.openDrawer(GravityCompat.START);
                break;


        }
    }
}
