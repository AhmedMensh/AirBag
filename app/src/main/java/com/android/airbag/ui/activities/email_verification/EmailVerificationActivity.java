package com.android.airbag.ui.activities.email_verification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.airbag.R;
import com.android.airbag.helpers.Constants;
import com.android.airbag.helpers.SharedPreferencesManager;
import com.android.airbag.ui.activities.guide.GuideActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EmailVerificationActivity extends AppCompatActivity implements View.OnClickListener{



    private static final String TAG = "PhoneVerification";
    private Unbinder unbinder;

    @BindView(R.id.email_input_layout)
    LinearLayout emailInputLayout;

    @BindView(R.id.submit_code_layout) LinearLayout submitCodeLayout;
    @BindView(R.id.continue_btn)
    Button continueButton;
    @BindView(R.id.submit_btn) Button submitButton;
    @BindView(R.id.edit_mail_tv)
    TextView editEmailTv;
    @BindView(R.id.logo_iv)
    ImageView logoIv;
    @BindView(R.id.app_name_tv) TextView appNameTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);


        unbinder =  ButterKnife.bind(this);
        continueButton.setOnClickListener(this::onClick);
        submitButton.setOnClickListener(this::onClick);
        editEmailTv.setOnClickListener(this::onClick);

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1){
            continueButton.setBackgroundResource(R.drawable.button_background_2);
            submitButton.setBackgroundResource(R.drawable.button_background_2);
            logoIv.setImageResource(R.drawable.ic_logo_orang);
            appNameTv.setTextColor(getResources().getColor(R.color.orange));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {



        switch (view.getId()){
            case R.id.continue_btn:
                emailInputLayout.setVisibility(View.GONE);
                submitCodeLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.edit_mail_tv:
                emailInputLayout.setVisibility(View.VISIBLE);
                submitCodeLayout.setVisibility(View.GONE);
                break;

            case R.id.submit_btn:
                startActivity(new Intent(EmailVerificationActivity.this , GuideActivity.class));
                finish();
                break;
        }
    }
}
