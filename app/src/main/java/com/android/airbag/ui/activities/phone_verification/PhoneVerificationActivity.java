package com.android.airbag.ui.activities.phone_verification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.airbag.R;

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
    TextView editTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);

       unbinder =  ButterKnife.bind(this);
       continueButton.setOnClickListener(this::onClick);
       submitButton.setOnClickListener(this::onClick);
       editTv.setOnClickListener(this::onClick);

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
        }
    }
}
