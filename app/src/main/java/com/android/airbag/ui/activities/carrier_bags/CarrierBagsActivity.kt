package com.android.airbag.ui.activities.carrier_bags

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

import com.android.airbag.R
import com.android.airbag.helpers.Utilities
import com.android.airbag.ui.activities.BaseActivity
import com.android.airbag.ui.fragments.carrier_bags.CarrierBagsFragment
import com.android.airbag.ui.fragments.filter.FilterFragment
import com.android.airbag.ui.fragments.pending_items.PendingItemsFragment

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.activity_carrier_bags.*

class CarrierBagsActivity : BaseActivity(), View.OnClickListener {
    private var unbinder: Unbinder? = null
//    @BindView(R.id.available_bags_tv)
//    internal var available_bags_tv: TextView? = null
//    @BindView(R.id.pending_items_tv)
//    internal var pending_items_tv: TextView? = null
//    @BindView(R.id.tab_indicator1)
//    internal var tab_indicator1: View? = null
//    @BindView(R.id.tab_indicator2)
//    internal var tab_indicator2: View? = null
//    @BindView(R.id.filter_iv)
//    internal var filter_iv: ImageView? = null
//    @BindView(R.id.tabs_icon_layout)
//    internal var tabs_icon_layout: LinearLayout? = null
//    @BindView(R.id.tabs_indicator_layout)
//    internal var tabs_indicator_layout: LinearLayout? = null
//    @BindView(R.id.nav_view)
//    internal var navigationView: NavigationView? = null
//    @BindView(R.id.drawer_layout)
//    internal var drawer_layout: DrawerLayout? = null
//    @BindView(R.id.menu_icon)
//    internal var menu_icon: ImageView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrier_bags)



        available_bags_tv!!.setOnClickListener { this.onClick(it) }
        pending_items_tv!!.setOnClickListener{ this.onClick(it) }
        filter_iv!!.setOnClickListener{ this.onClick(it) }
        menu_icon!!.setOnClickListener{ this.onClick(it) }
        attachCarrierBagsFragment()

        nav_view.setNavigationItemSelectedListener(this)

        nav_view.itemIconTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.orange))
        Utilities.changeUserType(nav_view, this)

    }

    private fun attachCarrierBagsFragment() {
        val carrierBagsFragment = CarrierBagsFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.fragment_container, carrierBagsFragment)
        transaction.commit()
    }

    private fun attachFilterFragment() {
        val fragment = FilterFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()


    }

    private fun attachPendingItemsFragment() {
        val fragment = PendingItemsFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()


    }

    override val contentViewId: Int
        get() = R.layout.activity_carrier_bags

    override val navigationMenuItemId: Int
        get() = R.id.navigation_home

    override fun onBackPressed() {
        if (drawer_layout!!.isDrawerOpen(GravityCompat.START)) {
            drawer_layout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.available_bags_tv -> {
                tab_indicator1!!.visibility = View.VISIBLE
                tab_indicator2!!.visibility = View.INVISIBLE
                available_bags_tv!!.setTextColor(ContextCompat.getColor(this,R.color.blue_dark))
                pending_items_tv!!.setTextColor(ContextCompat.getColor(this,R.color.grey))
                attachCarrierBagsFragment()
            }

            R.id.pending_items_tv -> {
                tab_indicator1!!.visibility = View.INVISIBLE
                tab_indicator2!!.visibility = View.VISIBLE
                available_bags_tv!!.setTextColor(ContextCompat.getColor(this,R.color.grey))
                pending_items_tv!!.setTextColor(ContextCompat.getColor(this,R.color.blue_dark))
                attachPendingItemsFragment()
            }

            R.id.filter_iv -> {
                attachFilterFragment()
                tabs_icon_layout!!.visibility = View.GONE
                tabs_indicator_layout!!.visibility = View.GONE
            }

            R.id.menu_icon -> if (!drawer_layout!!.isDrawerOpen(GravityCompat.START))
                drawer_layout!!.openDrawer(GravityCompat.START)
        }
    }

    companion object {


        private val TAG = "CarrierBagsActivity"
    }
}
