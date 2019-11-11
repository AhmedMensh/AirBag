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
import com.android.airbag.ui.activities.reset_password.ForgetPasswordActivity
import com.android.airbag.ui.activities.bags_list.BagListActivity
import com.android.airbag.ui.activities.carrier_bags.CarrierBagsActivity
import com.android.airbag.ui.activities.account_verification.EmailVerificationActivity
import com.android.airbag.ui.activities.account_verification.PhoneVerificationActivity
import com.android.airbag.ui.activities.register.RegisterActivity

import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private var userType: Int = 0
    val viewModel: LoginViewModel by viewModel()
    private val loginBody = LoginBody()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel.error.observe(this, Observer {
            it?.let {
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        })

        signInBtn!!.setOnClickListener{
            if (validateInputs()){
                viewModel.login(loginBody).observe(this, Observer {
                    it?.let {

                        if(it.status == 0){
                            startActivity( Intent(this, PhoneVerificationActivity::class.java))
                        }
                        if(it.status == 1){
                            startActivity( Intent(this,EmailVerificationActivity::class.java))
                        }
                        if (it.status == 2){

                            startActivity(Intent(this ,BagListActivity::class.java))
                        }

                        Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
                        finish()
                    }
                })
            }

        }
        forgetPasswordTV!!.setOnClickListener{
            startActivity(Intent(this@LoginActivity, ForgetPasswordActivity::class.java))
        }
        signUpBtn!!.setOnClickListener{startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))}
        skip_login_tv!!.setOnClickListener{
            if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 0)
                startActivity(Intent(this@LoginActivity, BagListActivity::class.java))
            else
                startActivity(Intent(this@LoginActivity, CarrierBagsActivity::class.java))
        }

        val content = SpannableString(resources.getString(R.string.skip_login))
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        skip_login_tv!!.text = content

        userType = SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE)



        if (userType == 1) {
            sign_as_label!!.visibility = View.VISIBLE
            skip_login_tv!!.setTextColor(ContextCompat.getColor(this,R.color.orange))
            signInBtn!!.background = ContextCompat.getDrawable(this,R.drawable.button_background_2)
            signUpBtn!!.setTextColor(ContextCompat.getColor(this,R.color.orange))
            logo_iv!!.setImageResource(R.drawable.ic_logo_orang)
            app_name_tv!!.setTextColor(ContextCompat.getColor(this,R.color.orange))
        }
    }



    private fun validateInputs() : Boolean{

        if (emailET.text.isNullOrEmpty() || passwordET.text.isNullOrEmpty()){
            Toast.makeText(this,R.string.all_fields_required,Toast.LENGTH_SHORT).show()
            return false
        }
        loginBody.email = emailET.text.toString()
        loginBody.password = passwordET.text.toString()
        return true
    }
    companion object {

        private val TAG = "LoginActivity"
    }
}
