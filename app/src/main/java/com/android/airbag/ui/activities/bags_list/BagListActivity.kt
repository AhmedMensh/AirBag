package com.android.airbag.ui.activities.bags_list

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

import com.android.airbag.R
import com.android.airbag.helpers.Utilities
import com.android.airbag.ui.activities.BaseActivity
import com.android.airbag.ui.fragments.available_bags.AvailableBagsFragment
import com.android.airbag.ui.fragments.filter.FilterFragment
import com.android.airbag.ui.fragments.pending_items.PendingItemsFragment

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.activity_bag_list.*

class BagListActivity : BaseActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bag_list)


        available_bags_tv!!.setOnClickListener { this.onClick(it) }
        pending_items_tv!!.setOnClickListener { this.onClick(it) }
        filter_iv!!.setOnClickListener { this.onClick(it) }
        menu_icon!!.setOnClickListener { this.onClick(it) }
        attachAvailableBagsFragment()


        nav_view.setNavigationItemSelectedListener(this)
        Utilities.changeUserType(nav_view, this)


    }

    private fun attachAvailableBagsFragment() {
        val availableBagsFragment = AvailableBagsFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.fragment_container, availableBagsFragment)
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

    override fun onBackPressed() {
        if (drawer_layout!!.isDrawerOpen(GravityCompat.START)) {
            drawer_layout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override val contentViewId: Int
        get() =  R.layout.activity_bag_list
    override val navigationMenuItemId: Int
        get() = R.id.navigation_home


    override fun onClick(view: View) {

        when (view.id) {
            R.id.available_bags_tv -> {
                tab_indicator1!!.visibility = View.VISIBLE
                tab_indicator2!!.visibility = View.INVISIBLE
                available_bags_tv!!.setTextColor(ContextCompat.getColor(this ,R.color.blue_dark))
                pending_items_tv!!.setTextColor(ContextCompat.getColor(this,R.color.grey))
                attachAvailableBagsFragment()
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

            R.id.menu_icon -> if (!drawer_layout!!.isDrawerOpen(GravityCompat.START)) drawer_layout!!.openDrawer(GravityCompat.START)
        }
    }

    companion object {

        private val TAG = "AvailableBagsActivity"
    }
}
