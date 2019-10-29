package com.android.airbag.ui.activities.register

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.ui.activities.phone_verification.PhoneVerificationActivity

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        submit_btn!!.setOnClickListener{ this.onClick(it) }


        Log.e(TAG, "onCreate: " + SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE))
        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {

            root_view_layout!!.background = resources.getDrawable(R.drawable.full_screen_background_orang)
            submit_btn!!.background = resources.getDrawable(R.drawable.button_background_2)
        }
    }

    override fun onClick(view: View) {

        when (view.id) {

            R.id.submit_btn -> {
                startActivity(Intent(this@RegisterActivity, PhoneVerificationActivity::class.java))
                finish()
            }
        }


    }

    companion object {

        private val TAG = "RegisterActivity"
    }
}
