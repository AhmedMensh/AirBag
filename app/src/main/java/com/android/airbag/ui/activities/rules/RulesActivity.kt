package com.android.airbag.ui.activities.rules

import androidx.core.view.GravityCompat

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.helpers.Utilities
import com.android.airbag.ui.activities.BaseActivity

import kotlinx.android.synthetic.main.activity_rules.*

class RulesActivity : BaseActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)


        sender_rules_tv!!.setOnClickListener { this.onClick(it) }
        carrier_rules_tv!!.setOnClickListener { this.onClick(it) }
        menu_icon!!.setOnClickListener{ this.onClick(it) }
        navigationView.setNavigationItemSelectedListener(this)

        Utilities.changeUserType(navigationView, this)
        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            layout!!.setBackgroundResource(R.drawable.full_screen_background_orang)
            navigationView.itemIconTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.orange))
        }
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.carrier_rules_tv -> {
                tab_indicator1!!.visibility = View.VISIBLE
                tab_indicator2!!.visibility = View.INVISIBLE
                carrier_rules_tv!!.setTextColor(ContextCompat.getColor(this,R.color.blue_dark))
                sender_rules_tv!!.setTextColor(ContextCompat.getColor(this ,R.color.grey))
            }

            R.id.sender_rules_tv -> {
                tab_indicator1!!.visibility = View.INVISIBLE
                tab_indicator2!!.visibility = View.VISIBLE
                carrier_rules_tv!!.setTextColor(ContextCompat.getColor(this,R.color.grey))
                sender_rules_tv!!.setTextColor(ContextCompat.getColor(this,R.color.blue_dark))
            }


            R.id.menu_icon -> if (!drawer_layout!!.isDrawerOpen(GravityCompat.START)) drawer_layout!!.openDrawer(GravityCompat.START)
        }
    }


    override val contentViewId: Int
        get() = R.layout.activity_rules

    override val navigationMenuItemId: Int
        get() = R.id.navigation_referrals

    override fun onBackPressed() {
        if (drawer_layout!!.isDrawerOpen(GravityCompat.START)) {
            drawer_layout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    companion object {


        private val TAG = "RulesActivity"
    }
}
