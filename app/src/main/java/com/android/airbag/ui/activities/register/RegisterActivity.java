package com.android.airbag.ui.activities.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.airbag.R;
import com.android.airbag.helpers.Constants;
import com.android.airbag.helpers.SharedPreferencesManager;
import com.android.airbag.helpers.Utilities;
import com.android.airbag.ui.activities.phone_verification.PhoneVerificationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RegisterActivity";
    private Unbinder unbinder;

    @BindView(R.id.submit_btn)
    Button submitButton;
    @BindView(R.id.root_view_layout)
    NestedScrollView rootViewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        unbinder = ButterKnife.bind(this);
        submitButton.setOnClickListener(this::onClick);


        Log.e(TAG, "onCreate: "+SharedPreferencesManager.getIntValue(this,Constants.USER_TYPE));
        if (SharedPreferencesManager.getIntValue(this,Constants.USER_TYPE) ==1){

            rootViewLayout.setBackground(getResources().getDrawable(R.drawable.full_screen_background_orang));
            submitButton.setBackground(getResources().getDrawable(R.drawable.button_background_2));
        }
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
