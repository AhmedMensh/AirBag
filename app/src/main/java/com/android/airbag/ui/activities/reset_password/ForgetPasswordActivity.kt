package com.android.airbag.ui.activities.reset_password

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager

import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_forget_password.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgetPasswordActivity : AppCompatActivity() {


    private val viewModel : ResetPasswordViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)


        viewModel.error.observe(this , Observer {
            it?.let {
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        })

        sendBtn.setOnClickListener {
            if (emailET.text.isNullOrEmpty()){
                Toast.makeText(this,"Please Enter Your Email",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            viewModel.resetPassword(emailET.text.toString()).observe(this , Observer {

                it?.let {
                    Toast.makeText(this,"Please Check Your Inbox",Toast.LENGTH_LONG).show()
                }
            })
        }
        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            logo_iv!!.setImageResource(R.drawable.ic_logo_orang)
            app_name_tv.setTextColor(ContextCompat.getColor(this,R.color.orange))
            sendBtn.setBackgroundResource(R.drawable.button_background_2)
        }
    }


    companion object {

        private val TAG = "ForgetPasswordActivity"
    }
}
