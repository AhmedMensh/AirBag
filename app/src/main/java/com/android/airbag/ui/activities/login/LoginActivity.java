package com.android.airbag.ui.activities.login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.airbag.R;
import com.android.airbag.helpers.Constants;
import com.android.airbag.helpers.SharedPreferencesManager;
import com.android.airbag.helpers.Utilities;
import com.android.airbag.ui.activities.ForgetPasswordActivity;
import com.android.airbag.ui.activities.bags_list.BagListActivity;
import com.android.airbag.ui.activities.carrier_bags.CarrierBagsActivity;
import com.android.airbag.ui.activities.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    private Unbinder unbinder;
    private int userType;
    @BindView(R.id.sign_in_btn)
    Button signInButton;
    @BindView(R.id.logo_iv)
    ImageView logoIv;
    @BindView(R.id.forget_password_tv) TextView forgetPasswordTextView;
    @BindView(R.id.sign_up_btn) Button signUpButton;
    @BindView(R.id.skip_login_tv) TextView skipLoginTextView;
    @BindView(R.id.sign_as_label) TextView signAsTv;
    @BindView(R.id.app_name_tv) TextView appNameTv;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        unbinder = ButterKnife.bind(this);
        signInButton.setOnClickListener(this);
        forgetPasswordTextView.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        skipLoginTextView.setOnClickListener(this);

        SpannableString content = new SpannableString(getResources().getString(R.string.skip_login));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        skipLoginTextView.setText(content);

        userType  = SharedPreferencesManager.getIntValue(this,Constants.USER_TYPE);



        if (userType == 1){
            signAsTv.setVisibility(View.VISIBLE);
            skipLoginTextView.setTextColor(getResources().getColor(R.color.orange));
            signInButton.setBackground(getResources().getDrawable(R.drawable.button_background_2));
            signUpButton.setTextColor(getResources().getColor(R.color.orange));
            logoIv.setImageResource(R.drawable.ic_logo_orang);
            appNameTv.setTextColor(getResources().getColor(R.color.orange));
        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.sign_in_btn:
                if ( SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 0)
                    startActivity(new Intent(LoginActivity.this, BagListActivity.class));
                else
                    startActivity(new Intent(LoginActivity.this, CarrierBagsActivity.class));
                finish();
                break;

            case R.id.forget_password_tv:
                startActivity(new Intent(LoginActivity.this , ForgetPasswordActivity.class));
                break;

            case R.id.sign_up_btn:
                startActivity(new Intent(LoginActivity.this , RegisterActivity.class));
                break;

            case R.id.skip_login_tv:
                if ( SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 0)
                startActivity(new Intent(LoginActivity.this, BagListActivity.class));
                else
                startActivity(new Intent(LoginActivity.this, CarrierBagsActivity.class));
                break;
        }
    }
}
