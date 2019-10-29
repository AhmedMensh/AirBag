package com.android.airbag.ui.activities.profile_settings

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.activity_profile_settings.*

class ProfileSettingsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)


        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            upload_image_btn!!.setBackgroundResource(R.drawable.button_background_2)
            upload_image_btn!!.setPadding(20, 20, 20, 20)
            save_btn!!.setBackgroundResource(R.drawable.button_background_2)
        }
    }



    companion object {

        private val TAG = "ProfileSettingsActivity"
    }
}

