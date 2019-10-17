package com.android.airbag.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.android.airbag.R;
import com.android.airbag.ui.activities.login.LoginActivity;
import com.google.android.material.navigation.NavigationView;

public class Utilities {




    public static void changeUserType(NavigationView navigationView, Activity context){

        View header = navigationView.getHeaderView(0);
        Button headerBtn = header.findViewById(R.id.user_type_btn);

        int userType = SharedPreferencesManager.getIntValue(context,Constants.USER_TYPE);

        if (userType == 1 ){
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.navigation_promo_code).setVisible(false);
            headerBtn.setText("Be Sender");
            headerBtn.setBackgroundResource(R.drawable.button_background_2);
        }else {
            headerBtn.setText("Be Carrier");
            headerBtn.setBackgroundResource(R.drawable.button_background_2);
        }



        headerBtn.setOnClickListener(view -> {
            if (userType == 1) SharedPreferencesManager.setIntValue(context ,Constants.USER_TYPE ,0);
            else SharedPreferencesManager.setIntValue(context ,Constants.USER_TYPE ,1);
            context.startActivity(new Intent(context, LoginActivity.class));
            context.finish();
        });
    }

}
