package com.android.airbag.ui.activities.phone_verification

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.ui.activities.email_verification.EmailVerificationActivity

import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_phone_verification.*

class PhoneVerificationActivity : AppCompatActivity(), View.OnClickListener {
//    private var unbinder: Unbinder? = null
//
//    @BindView(R.id.phone_input_layout)
//    internal var phone_input_layout: LinearLayout? = null

//    @BindView(R.id.submit_code_layout)
//    internal var submit_code_layout: LinearLayout? = null
//    @BindView(R.id.continue_btn)
//    internal var continue_btn: Button? = null
//    @BindView(R.id.submit_btn)
//    internal var submit_btn: Button? = null
//    @BindView(R.id.edit_tv)
//    internal var edit_tv: TextView? = null
//    @BindView(R.id.logo_iv)
//    internal var logo_iv: ImageView? = null
//    @BindView(R.id.app_name_tv)
//    internal var app_name_tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_verification)

        continue_btn!!.setOnClickListener( { this.onClick(it) })
        submit_btn!!.setOnClickListener{ this.onClick(it) }
        edit_tv!!.setOnClickListener { this.onClick(it) }

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            continue_btn!!.setBackgroundResource(R.drawable.button_background_2)
            submit_btn!!.setBackgroundResource(R.drawable.button_background_2)
            logo_iv!!.setImageResource(R.drawable.ic_logo_orang)
            app_name_tv!!.setTextColor(ContextCompat.getColor(this,R.color.orange))
        }
    }



    override fun onClick(view: View) {

        when (view.id) {
            R.id.continue_btn -> {
                phone_input_layout!!.visibility = View.GONE
                submit_code_layout!!.visibility = View.VISIBLE
            }

            R.id.edit_tv -> {
                phone_input_layout!!.visibility = View.VISIBLE
                submit_code_layout!!.visibility = View.GONE
            }

            R.id.submit_btn -> {
                startActivity(Intent(this@PhoneVerificationActivity, EmailVerificationActivity::class.java))
                finish()
            }
        }
    }

    companion object {

        private val TAG = "PhoneVerification"
    }
}
