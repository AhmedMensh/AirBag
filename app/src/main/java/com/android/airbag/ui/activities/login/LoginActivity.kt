package com.android.airbag.ui.activities.login

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.models.LoginBody
import com.android.airbag.ui.activities.ForgetPasswordActivity
import com.android.airbag.ui.activities.bags_list.BagListActivity
import com.android.airbag.ui.activities.carrier_bags.CarrierBagsActivity
import com.android.airbag.ui.activities.register.RegisterActivity
import com.android.airbag.ui.activities.register.RegisterViewModel

import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.bag_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var userType: Int = 0
    val viewModel: LoginViewModel by viewModel()
    private val loginBody = LoginBody()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        loginBody.email = "ahmedmensh8@gmail.com"
        loginBody.password = "123456"
        viewModel.error.observe(this, Observer {
            it?.let {
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        })

        sign_in_btn!!.setOnClickListener{
            viewModel.login(loginBody).observe(this, Observer {
                it?.let {
                    Toast.makeText(this,it.firstName,Toast.LENGTH_SHORT).show()
                }
            })
        }
        forget_password_tv!!.setOnClickListener(this)
        sign_up_btn!!.setOnClickListener(this)
        skip_login_tv!!.setOnClickListener(this)

        val content = SpannableString(resources.getString(R.string.skip_login))
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        skip_login_tv!!.text = content

        userType = SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE)



        if (userType == 1) {
            sign_as_label!!.visibility = View.VISIBLE
            skip_login_tv!!.setTextColor(ContextCompat.getColor(this,R.color.orange))
            sign_in_btn!!.background = ContextCompat.getDrawable(this,R.drawable.button_background_2)
            sign_up_btn!!.setTextColor(ContextCompat.getColor(this,R.color.orange))
            logo_iv!!.setImageResource(R.drawable.ic_logo_orang)
            app_name_tv!!.setTextColor(ContextCompat.getColor(this,R.color.orange))
        }
    }


    override fun onClick(view: View) {

        when (view.id) {
//            R.id.sign_in_btn -> {
//                if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 0)
//                    startActivity(Intent(this@LoginActivity, BagListActivity::class.java))
//                else
//                    startActivity(Intent(this@LoginActivity, CarrierBagsActivity::class.java))
//                finish()
//            }

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
