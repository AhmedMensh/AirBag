package com.android.airbag.ui.activities.account_verification

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.models.ActiveUser
import com.android.airbag.ui.activities.guide.GuideActivity
import kotlinx.android.synthetic.main.activity_email_verification.*

import kotlinx.android.synthetic.main.activity_phone_verification.*
import kotlinx.android.synthetic.main.activity_phone_verification.app_name_tv
import kotlinx.android.synthetic.main.activity_phone_verification.continue_btn
import kotlinx.android.synthetic.main.activity_phone_verification.fifthDigitET
import kotlinx.android.synthetic.main.activity_phone_verification.firstDigitET
import kotlinx.android.synthetic.main.activity_phone_verification.forthDigitET
import kotlinx.android.synthetic.main.activity_phone_verification.logo_iv
import kotlinx.android.synthetic.main.activity_phone_verification.secondDigitET
import kotlinx.android.synthetic.main.activity_phone_verification.submitBtn
import kotlinx.android.synthetic.main.activity_phone_verification.thirdDigitET
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.StringBuilder

class PhoneVerificationActivity : AppCompatActivity() {


    private val viewModel: AccountVerificationViewModel by viewModel()
    private val activeUser by lazy { ActiveUser() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_verification)


        viewModel.error.observe(this , Observer {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

        submitBtn.setOnClickListener {

            if (validiteInputs()) {
                viewModel.activeUser(activeUser).observe(this, Observer {
                    it?.let {
                        startActivity(Intent(this@PhoneVerificationActivity, GuideActivity::class.java))
                        finish()
                    }
                })
            }
        }

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            continue_btn!!.setBackgroundResource(R.drawable.button_background_2)
            submitBtn!!.setBackgroundResource(R.drawable.button_background_2)
            logo_iv!!.setImageResource(R.drawable.ic_logo_orang)
            app_name_tv!!.setTextColor(ContextCompat.getColor(this,R.color.orange))
        }
    }

    private fun validiteInputs(): Boolean {
        if (firstDigitET.text.isNullOrEmpty() || secondDigitET.text.isNullOrEmpty() || thirdDigitET.text.isNullOrEmpty()
                || forthDigitET.text.isNullOrEmpty() || fifthDigitET.text.isNullOrEmpty()) {
            Toast.makeText(this, "Please Enter The 5 Digits", Toast.LENGTH_SHORT).show()
            return false
        }
        var stringBuilder = StringBuilder()
        stringBuilder.append(firstDigitET.text.toString())
        stringBuilder.append(secondDigitET.text.toString())
        stringBuilder.append(thirdDigitET.text.toString())
        stringBuilder.append(forthDigitET.text.toString())
        stringBuilder.append(fifthDigitET.text.toString())
        activeUser.type = "phone"
        activeUser.code = stringBuilder.toString()
        return true


    }


    companion object {

        private val TAG = "PhoneVerification"
    }
}