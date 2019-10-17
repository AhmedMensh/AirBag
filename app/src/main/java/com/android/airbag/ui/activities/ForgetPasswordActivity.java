package com.android.airbag.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.airbag.R;
import com.android.airbag.helpers.Constants;
import com.android.airbag.helpers.SharedPreferencesManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ForgetPasswordActivity extends AppCompatActivity {

    private static final String TAG = "ForgetPasswordActivity";
    private Unbinder unbinder;
    @BindView(R.id.logo_iv)
    ImageView logoIv;
    @BindView(R.id.app_name_tv)
    TextView appNameTv;
    @BindView(R.id.send_btn)
    Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);


        unbinder = ButterKnife.bind(this);

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1){
            logoIv.setImageResource(R.drawable.ic_logo_orang);
            appNameTv.setTextColor(getResources().getColor(R.color.orange));
            sendButton.setBackgroundResource(R.drawable.button_background_2);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
