package com.android.airbag.ui.activities.complaints;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.airbag.R;
import com.android.airbag.helpers.Constants;
import com.android.airbag.helpers.SharedPreferencesManager;
import com.android.airbag.helpers.Utilities;
import com.android.airbag.ui.activities.BaseActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ComplaintsActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "ComplaintsActivity";
    private Unbinder unbinder;

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.menu_icon)
    ImageView menuIcon;
    @BindView(R.id.submit_btn)
    Button submitButton;
    @BindView(R.id.layout)
    LinearLayout rootViewCl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);

        unbinder = ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(this);
        menuIcon.setOnClickListener(this::onClick);
        submitButton.setOnClickListener(this::onClick);

        Utilities.changeUserType(navigationView ,this);
        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) ==1){
            rootViewCl.setBackgroundResource(R.drawable.full_screen_background_orang);
            submitButton.setBackgroundResource(R.drawable.button_background_2);
            navigationView.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.orange)));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_complaints;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_complaints;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.menu_icon:
                if (!drawer.isDrawerOpen(GravityCompat.START)) drawer.openDrawer(GravityCompat.START);
                break;

            case R.id.submit_btn:
                showConfirmationDialog();
                break;

        }
    }

    private void showConfirmationDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.confirm_dialog,null);

        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }
}
