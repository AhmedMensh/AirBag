package com.android.airbag.ui.activities.login

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.View

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.ui.activities.ForgetPasswordActivity
import com.android.airbag.ui.activities.bags_list.BagListActivity
import com.android.airbag.ui.activities.carrier_bags.CarrierBagsActivity
import com.android.airbag.ui.activities.register.RegisterActivity

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var userType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        sign_in_btn!!.setOnClickListener(this)
        forget_password_tv!!.setOnClickListener(this)
        sign_up_btn!!.setOnClickListener(this)
        skip_login_tv!!.setOnClickListener(this)

        val content = SpannableString(resources.getString(R.string.skip_login))
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        skip_login_tv!!.text = content

        userType = SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE)



        if (userType == 1) {
            sign_as_label!!.visibility = View.VISIBLE
            skip_login_tv!!.setTextColor(resources.getColor(R.color.orange))
            sign_in_btn!!.background = resources.getDrawable(R.drawable.button_background_2)
            sign_up_btn!!.setTextColor(resources.getColor(R.color.orange))
            logo_iv!!.setImageResource(R.drawable.ic_logo_orang)
            app_name_tv!!.setTextColor(resources.getColor(R.color.orange))
        }
    }


    override fun onClick(view: View) {

        when (view.id) {
            R.id.sign_in_btn -> {
                if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 0)
                    startActivity(Intent(this@LoginActivity, BagListActivity::class.java))
                else
                    startActivity(Intent(this@LoginActivity, CarrierBagsActivity::class.java))
                finish()
            }

            R.id.forget_password_tv -> startActivity(Intent(this@LoginActivity, ForgetPasswordActivity::class.java))

            R.id.sign_up_btn -> startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))

            R.id.skip_login_tv -> if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 0)
                startActivity(Intent(this@LoginActivity, BagListActivity::class.java))
            else
                startActivity(Intent(this@LoginActivity, CarrierBagsActivity::class.java))
        }
    }

    companion object {

        private val TAG = "LoginActivity"
    }
}
