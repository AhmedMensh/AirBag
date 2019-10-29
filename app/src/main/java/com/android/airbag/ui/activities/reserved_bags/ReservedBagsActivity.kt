package com.android.airbag.ui.activities.reserved_bags

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

import com.android.airbag.R
import com.android.airbag.adapters.ReservedBagsAdapter
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.helpers.Utilities
import com.android.airbag.ui.activities.BaseActivity

import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_reserved_bags.*

class ReservedBagsActivity : BaseActivity(), View.OnClickListener, ReservedBagsAdapter.ItemClickListener {
    private var isReservedBagDetailsShown = false
//    private var unbinder: Unbinder? = null
//    @BindView(R.id.nav_view)
//    internal var navigationView: NavigationView? = null
//    @BindView(R.id.drawer_layout)
//    internal var drawer_layout: DrawerLayout? = null
//    @BindView(R.id.menu_icon)
//    internal var menu_icon: ImageView? = null
//    @BindView(R.id.reserved_bags_rv)
//    internal var reserved_bags_rv: RecyclerView? = null
//    @BindView(R.id.reserved_bag_details_layout)
//    internal var reserved_bag_details_layout: ConstraintLayout? = null
//    @BindView(R.id.app_bar_layout)
//    internal var app_bar_layout: LinearLayout? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserved_bags)


        menu_icon!!.setOnClickListener { this.onClick(it) }

        nav_view.setNavigationItemSelectedListener(this)

        intReservedBagsRv()
        Utilities.changeUserType(nav_view, this)
        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            app_bar_layout!!.setBackgroundResource(R.drawable.full_screen_background_orang)
            nav_view.itemIconTintList = ColorStateList.valueOf(resources.getColor(R.color.orange))
        }
    }


    private fun intReservedBagsRv() {
        reserved_bags_rv!!.layoutManager = LinearLayoutManager(this)
        reserved_bags_rv!!.setHasFixedSize(true)
        reserved_bags_rv!!.adapter = ReservedBagsAdapter(this)
    }


    override fun onBackPressed() {
        if (drawer_layout!!.isDrawerOpen(GravityCompat.START)) {
            drawer_layout!!.closeDrawer(GravityCompat.START)
        } else {
            if (isReservedBagDetailsShown) {
                reserved_bag_details_layout!!.visibility = View.INVISIBLE
                reserved_bags_rv!!.visibility = View.VISIBLE
                isReservedBagDetailsShown = false
            } else {
                super.onBackPressed()
            }
        }
    }


    override val contentViewId: Int
        get() = R.layout.activity_reserved_bags

    override val navigationMenuItemId: Int
        get() = R.id.navigation_history
    override fun onClick(view: View) {

        when (view.id) {
            R.id.menu_icon -> if (!drawer_layout!!.isDrawerOpen(GravityCompat.START))
                drawer_layout!!.openDrawer(GravityCompat.START)
        }
    }

    override fun onBagItemClickListener(itemPosition: Int) {
        isReservedBagDetailsShown = true
        reserved_bags_rv!!.visibility = View.INVISIBLE
        reserved_bag_details_layout!!.visibility = View.VISIBLE
    }

    companion object {

        private val TAG = "ReservedBagsActivity"
    }
}
