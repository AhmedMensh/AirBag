package com.android.airbag.ui.activities.email_verification

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.ui.activities.guide.GuideActivity

import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_email_verification.*

class EmailVerificationActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_verification)



        continue_btn!!.setOnClickListener { this.onClick(it) }
        submit_btn!!.setOnClickListener { this.onClick(it) }
        edit_mail_tv!!.setOnClickListener{ this.onClick(it) }

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            continue_btn!!.setBackgroundResource(R.drawable.button_background_2)
            submit_btn!!.setBackgroundResource(R.drawable.button_background_2)
            logo_iv!!.setImageResource(R.drawable.ic_logo_orang)
            app_name_tv!!.setTextColor(resources.getColor(R.color.orange))
        }
    }


    override fun onClick(view: View) {


        when (view.id) {
            R.id.continue_btn -> {
                email_input_layout!!.visibility = View.GONE
                submit_code_layout!!.visibility = View.VISIBLE
            }

            R.id.edit_mail_tv -> {
                email_input_layout!!.visibility = View.VISIBLE
                submit_code_layout!!.visibility = View.GONE
            }

            R.id.submit_btn -> {
                startActivity(Intent(this@EmailVerificationActivity, GuideActivity::class.java))
                finish()
            }
        }
    }

    companion object {


        private val TAG = "PhoneVerification"
    }
}
