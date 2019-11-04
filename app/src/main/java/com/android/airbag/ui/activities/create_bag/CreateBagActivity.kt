package com.android.airbag.ui.activities.create_bag

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat

import com.android.airbag.R
import com.android.airbag.helpers.Utilities
import com.android.airbag.ui.activities.BaseActivity

import butterknife.BindView
import kotlinx.android.synthetic.main.activity_create_bag.*


class CreateBagActivity : BaseActivity(), View.OnClickListener {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_bag)

        nav_view!!.setNavigationItemSelectedListener(this)
        menu_icon!!.setOnClickListener(this)
        nav_view!!.itemIconTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.orange))
        Utilities.changeUserType(nav_view!!, this)
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

        private val TAG = "CreateBagActivity"
    }
}
