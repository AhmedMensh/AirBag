package com.android.airbag.ui.activities.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.airbag.R;
import com.android.airbag.ui.activities.BaseActivity;
import com.android.airbag.ui.fragments.aprroved_notifications.ApprovedNotificationsFragment;
import com.android.airbag.ui.fragments.notifications_history.NotificationsHistoryFragment;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NotificationsActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "NotificationsActivity";
    private Unbinder unbinder;
    @BindView(R.id.approved_request_tv)
    TextView approvedRequestTv;
    @BindView(R.id.history_notification_tv)
    TextView historyNotificationsTv;
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
    @BindView(R.id.menu_icon) ImageView menuIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        unbinder = ButterKnife.bind(this);
        historyNotificationsTv.setOnClickListener(this::onClick);
        approvedRequestTv.setOnClickListener(this::onClick);
        menuIcon.setOnClickListener(this::onClick);
        navigationView.setNavigationItemSelectedListener(this);

        attachApprovedRequestFragment();
    }

    private void attachHistoryNotificationsFragment(){

        NotificationsHistoryFragment fragment = new NotificationsHistoryFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }

    private void attachApprovedRequestFragment(){

        ApprovedNotificationsFragment fragment = new ApprovedNotificationsFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
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

    @Override
    public int getContentViewId() {
        return R.layout.activity_notifications;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_notifications;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.approved_request_tv:
                attachApprovedRequestFragment();
                tabIndicator1.setVisibility(View.VISIBLE);
                tabIndicator2.setVisibility(View.INVISIBLE);
                approvedRequestTv.setTextColor(getResources().getColor(R.color.blue_dark));
                historyNotificationsTv.setTextColor(getResources().getColor(R.color.grey));
                break;

            case R.id.history_notification_tv:
                attachHistoryNotificationsFragment();
                tabIndicator1.setVisibility(View.INVISIBLE);
                tabIndicator2.setVisibility(View.VISIBLE);
                approvedRequestTv.setTextColor(getResources().getColor(R.color.grey));
                historyNotificationsTv.setTextColor(getResources().getColor(R.color.blue_dark));
                break;


            case R.id.menu_icon:
                if (!drawer.isDrawerOpen(GravityCompat.START)) drawer.openDrawer(GravityCompat.START);
                break;


        }
    }
}
