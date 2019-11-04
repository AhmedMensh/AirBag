package com.android.airbag.helpers

import android.app.Activity
import android.content.Intent
import android.widget.Button
import android.widget.TextView

import com.android.airbag.R
import com.android.airbag.ui.activities.login.LoginActivity
import com.google.android.material.navigation.NavigationView

object Utilities {


    fun changeUserType(navigationView: NavigationView, context: Activity) {

        val header = navigationView.getHeaderView(0)
        val headerBtn = header.findViewById<Button>(R.id.user_type_btn)
        val userTypeTv = header.findViewById<TextView>(R.id.user_type_tv)

        val userType = SharedPreferencesManager.getIntValue(context, Constants.USER_TYPE)

        if (userType == 1) {
            val navMenu = navigationView.menu
            navMenu.findItem(R.id.navigation_message).isVisible = false
            headerBtn.text = "Be Sender"
            headerBtn.setBackgroundResource(R.drawable.button_background_2)
            userTypeTv.text = "I am Carrier"
        } else {
            userTypeTv.text = "I am Sender"
            headerBtn.text = "Be Carrier"
            headerBtn.setBackgroundResource(R.drawable.button_background_2)
        }




        headerBtn.setOnClickListener {
            if (userType == 1)
                SharedPreferencesManager.setIntValue(context, Constants.USER_TYPE, 0)
            else
                SharedPreferencesManager.setIntValue(context, Constants.USER_TYPE, 1)
            context.startActivity(Intent(context, LoginActivity::class.java))
            context.finish()
        }
    }

}
