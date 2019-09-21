package com.android.airbag.ui.activities.rules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.airbag.R;
import com.android.airbag.ui.activities.BaseActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RulesActivity extends BaseActivity implements View.OnClickListener{


    private static final String TAG = "RulesActivity";
    private Unbinder unbinder;
    @BindView(R.id.carrier_rules_tv)
    TextView carrierRulesTv;
    @BindView(R.id.sender_rules_tv)
    TextView senderRulesTv;
    @BindView(R.id.tab_indicator1)
    View tabIndicator1;
    @BindView(R.id.tab_indicator2)
    View tabIndicator2;
    @BindView(R.id.tabs_icon_layout)
    LinearLayout tabsIconLayout;
    @BindView(R.id.tabs_indicator_layout)
    LinearLayout tabsIndicatorLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.menu_icon)
    ImageView menuIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        unbinder = ButterKnife.bind(this);
        senderRulesTv.setOnClickListener(this::onClick);
        carrierRulesTv.setOnClickListener(this::onClick);
        menuIcon.setOnClickListener(this::onClick);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_rules;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_safety_rules;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.carrier_rules_tv:
                tabIndicator1.setVisibility(View.VISIBLE);
                tabIndicator2.setVisibility(View.INVISIBLE);
                carrierRulesTv.setTextColor(getResources().getColor(R.color.blue_dark));
                senderRulesTv.setTextColor(getResources().getColor(R.color.grey));
                break;

            case R.id.sender_rules_tv:
                tabIndicator1.setVisibility(View.INVISIBLE);
                tabIndicator2.setVisibility(View.VISIBLE);
                carrierRulesTv.setTextColor(getResources().getColor(R.color.grey));
                senderRulesTv.setTextColor(getResources().getColor(R.color.blue_dark));
                break;


            case R.id.menu_icon:
                if (!drawer.isDrawerOpen(GravityCompat.START)) drawer.openDrawer(GravityCompat.START);
                break;


        }
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
}
