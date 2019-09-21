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
import android.widget.TextView;

import com.android.airbag.R;
import com.android.airbag.ui.activities.ForgetPasswordActivity;
import com.android.airbag.ui.activities.bags_list.BagListActivity;
import com.android.airbag.ui.activities.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    private Unbinder unbinder;
    @BindView(R.id.sign_in_btn)
    Button signInButton;
    @BindView(R.id.forget_password_tv) TextView forgetPasswordTextView;
    @BindView(R.id.sign_up_btn) Button signUpButton;
    @BindView(R.id.skip_login_tv) TextView skipLoginTextView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        unbinder = ButterKnife.bind(this);
        signInButton.setOnClickListener(this);
        forgetPasswordTextView.setOnClickListener(this);
        signInButton.setOnClickListener(this);
        skipLoginTextView.setOnClickListener(this);

        SpannableString content = new SpannableString(getResources().getString(R.string.skip_login));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        skipLoginTextView.setText(content);





    }

    private void changeButtonBackgroundBasedOnUserType(){
        int colors[] = { 0xff255779, 0xffa6c0cd,0xffa6c0cd};


        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT, colors);

        gradientDrawable.setCornerRadius(50.0f);


        signInButton.setBackgroundDrawable(gradientDrawable);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.sign_in_btn:
                startActivity(new Intent(LoginActivity.this, BagListActivity.class));
                finish();
                break;

            case R.id.forget_password_tv:
                startActivity(new Intent(LoginActivity.this , ForgetPasswordActivity.class));
                break;

            case R.id.sign_up_btn:
                startActivity(new Intent(LoginActivity.this , RegisterActivity.class));
                break;

            case R.id.skip_login_tv:
                startActivity(new Intent(LoginActivity.this, BagListActivity.class));
                break;
        }
    }
}
