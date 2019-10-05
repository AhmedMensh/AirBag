package com.android.airbag.ui.activities.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.airbag.R;
import com.android.airbag.ui.activities.phone_verification.PhoneVerificationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RegisterActivity";
    private Unbinder unbinder;

    @BindView(R.id.submit_btn)
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        unbinder = ButterKnife.bind(this);
        submitButton.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.submit_btn:
                startActivity(new Intent(RegisterActivity.this, PhoneVerificationActivity.class));
                finish();
                break;
        }


    }
}
