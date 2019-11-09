package com.android.airbag.ui.activities

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.network.Network
import com.android.airbag.ui.activities.bags_list.BagListActivity
import com.android.airbag.ui.activities.create_bag.CreateBagActivity
import com.android.airbag.ui.activities.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if (SharedPreferencesManager.getStringValue(this,Constants.TOKEN) != ""){
            Network.authToken = SharedPreferencesManager.getStringValue(this,Constants.TOKEN)
        }

    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed({ startActivity(Intent(this@SplashActivity, LoginActivity::class.java)) }, SPLASH_TIME_OUT.toLong())
    }

    companion object {

        private const val SPLASH_TIME_OUT = 2000
    }
}
