package com.android.airbag.ui.activities.register

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.ui.activities.phone_verification.PhoneVerificationActivity

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.android.airbag.models.RegisterBody
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    val viewModel: RegisterViewModel by viewModel()
    var registerBody  = RegisterBody()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        registerBody.confirmPassword = "123456"
        registerBody.email = "ahmed@e.com"
        registerBody.firstName = "Ahmed"
        registerBody.lastName = "Mensh"
        registerBody.nickname = "Mensh"
        registerBody.password = "123456"
        registerBody.phone = "1284596559"
        registerBody.phoneCountry = "+20"
        submit_btn!!.setOnClickListener{
            viewModel.register(registerBody).observe(this , Observer {
                it?.let {
                    Log.e("TAG","${it.firstName}")
                }
            })
        }

        viewModel.error.observe(this , Observer {
            it?.let {
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        })

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {

            root_view_layout!!.background = ContextCompat.getDrawable(this,R.drawable.full_screen_background_orang)
            submit_btn!!.background = ContextCompat.getDrawable(this ,R.drawable.button_background_2)
        }
    }


    companion object {

        private val TAG = "RegisterActivity"
    }
}
