package com.android.airbag.ui.activities.create_item

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


import kotlinx.android.synthetic.main.activity_create_item.*

class CreateItemActivity : BaseActivity(), View.OnClickListener {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_item)

        nav_view!!.setNavigationItemSelectedListener(this)
        menu_icon!!.setOnClickListener(this)
        Utilities.changeUserType(nav_view!!, this)


        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {

            nav_view!!.itemIconTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.orange))
        }
    }


    override val contentViewId: Int
        get() = R.layout.activity_create_bag

    override val navigationMenuItemId: Int
        get() = R.id.navigation_home

    override fun onClick(view: View) {

        when (view.id) {


            R.id.menu_icon -> if (!drawer_layout!!.isDrawerOpen(GravityCompat.START))
                drawer_layout!!.openDrawer(GravityCompat.START)
        }
    }

    companion object {

        private val TAG = "CreateItemActivity"
    }
}
