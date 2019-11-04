package com.android.airbag.ui.activities

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.core.content.ContextCompat

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager

import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_forget_password.*

class ForgetPasswordActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)



        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            logo_iv!!.setImageResource(R.drawable.ic_logo_orang)
            app_name_tv!!.setTextColor(ContextCompat.getColor(this,R.color.orange))
            send_btn!!.setBackgroundResource(R.drawable.button_background_2)
        }
    }


    companion object {

        private val TAG = "ForgetPasswordActivity"
    }
}
