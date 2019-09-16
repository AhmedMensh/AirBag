package com.android.airbag.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.android.airbag.R;
import com.android.airbag.ui.activities.login.LoginActivity;
import com.android.airbag.ui.activities.phone_verification.PhoneVerificationActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(() -> startActivity(new Intent(SplashActivity.this, PhoneVerificationActivity.class)),SPLASH_TIME_OUT);
    }
}
