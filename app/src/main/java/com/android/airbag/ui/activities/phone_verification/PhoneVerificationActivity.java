package com.android.airbag.ui.activities.phone_verification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.airbag.R;
import com.android.airbag.ui.activities.email_verification.EmailVerificationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PhoneVerificationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "PhoneVerification";
    private Unbinder unbinder;

    @BindView(R.id.phone_input_layout)
    LinearLayout phoneInputLayout;

    @BindView(R.id.submit_code_layout) LinearLayout submitCodeLayout;
    @BindView(R.id.continue_btn)
    Button continueButton;
    @BindView(R.id.submit_btn) Button submitButton;
    @BindView(R.id.edit_tv)
    TextView editPhoneNumberTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);

       unbinder =  ButterKnife.bind(this);
       continueButton.setOnClickListener(this::onClick);
       submitButton.setOnClickListener(this::onClick);
       editPhoneNumberTv.setOnClickListener(this::onClick);

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
                phoneInputLayout.setVisibility(View.GONE);
                submitCodeLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.edit_tv:
                phoneInputLayout.setVisibility(View.VISIBLE);
                submitCodeLayout.setVisibility(View.GONE);
                break;

            case R.id.submit_btn:
                startActivity(new Intent(PhoneVerificationActivity.this, EmailVerificationActivity.class));
                finish();
                break;
        }
    }
}
