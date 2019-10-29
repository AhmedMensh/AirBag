package com.android.airbag.ui.activities.promo_code

import androidx.core.view.GravityCompat

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.helpers.Utilities
import com.android.airbag.ui.activities.BaseActivity

import kotlinx.android.synthetic.main.activity_promo_code.*

class PromoCodeActivity : BaseActivity(), View.OnClickListener {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promo_code)


        nav_view.setNavigationItemSelectedListener(this)
        menu_icon!!.setOnClickListener(this)
        Utilities.changeUserType(nav_view, this)
        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            root_view_cl!!.setBackgroundResource(R.drawable.full_screen_background_orang)
            share_btn!!.setBackgroundResource(R.drawable.button_background_2)
            nav_view.itemIconTintList = ColorStateList.valueOf(resources.getColor(R.color.orange))
        }
    }

    override fun onBackPressed() {
        if (drawer_layout!!.isDrawerOpen(GravityCompat.START)) {
            drawer_layout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override val contentViewId: Int
        get() = R.layout.activity_promo_code

    override val navigationMenuItemId: Int
        get() = R.id.navigation_message

    override fun onClick(view: View) {

        when (view.id) {
            R.id.menu_icon -> if (!drawer_layout!!.isDrawerOpen(GravityCompat.START)) drawer_layout!!.openDrawer(GravityCompat.START)
        }
    }

    companion object {


        private val TAG = "PromoCodeActivity"
    }
}
