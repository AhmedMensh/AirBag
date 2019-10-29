package com.android.airbag.ui.activities.payment

import androidx.core.view.GravityCompat

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View


import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.helpers.Utilities
import com.android.airbag.ui.activities.BaseActivity

import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : BaseActivity(), View.OnClickListener {


    override val contentViewId: Int
        get() = R.layout.activity_payment

    override val navigationMenuItemId: Int
        get() = R.id.navigation_help

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)


        nav_view.setNavigationItemSelectedListener(this)
        menu_icon!!.setOnClickListener { this.onClick(it) }
        Utilities.changeUserType(nav_view, this)

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            layout!!.setBackgroundResource(R.drawable.full_screen_background_orang)
            add_new_card_btn!!.setBackgroundResource(R.drawable.button_background_2)
            nav_view.itemIconTintList = ColorStateList.valueOf(resources.getColor(R.color.orange))
        }
    }



    override fun onClick(view: View) {

        when (view.id) {
            R.id.menu_icon -> if (!drawer_layout!!.isDrawerOpen(GravityCompat.START)) drawer_layout!!.openDrawer(GravityCompat.START)
        }
    }

    companion object {

        private val TAG = "PaymentActivity"
    }

}
