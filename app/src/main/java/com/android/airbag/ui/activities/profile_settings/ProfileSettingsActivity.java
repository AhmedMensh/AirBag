package com.android.airbag.ui.activities.profile_settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.android.airbag.R;
import com.android.airbag.helpers.Constants;
import com.android.airbag.helpers.SharedPreferencesManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProfileSettingsActivity extends AppCompatActivity {

    private static final String TAG = "ProfileSettingsActivity";
    private Unbinder unbinder;
    @BindView(R.id.upload_image_btn)
    ImageView uploadImageBtn;
    @BindView(R.id.save_btn)
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        unbinder = ButterKnife.bind(this);

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) ==1){
            uploadImageBtn.setBackgroundResource(R.drawable.button_background_2);
            uploadImageBtn.setPadding(20,20,20,20);
            saveBtn.setBackgroundResource(R.drawable.button_background_2);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

