package com.android.airbag.ui.activities.notifications

import androidx.core.view.GravityCompat

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.helpers.Utilities
import com.android.airbag.ui.activities.BaseActivity
import com.android.airbag.ui.fragments.aprroved_notifications.ApprovedNotificationsFragment
import com.android.airbag.ui.fragments.notifications_history.NotificationsHistoryFragment

import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_notifications.*

class NotificationsActivity : BaseActivity(), View.OnClickListener {


    override val contentViewId: Int
        get() = R.layout.activity_notifications

    override val navigationMenuItemId: Int
        get() = R.id.navigation_message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)


        history_notification_tv!!.setOnClickListener { this.onClick(it) }
        approved_request_tv!!.setOnClickListener { this.onClick(it) }
        menu_icon!!.setOnClickListener { this.onClick(it) }
        nav_view.setNavigationItemSelectedListener(this)

        attachApprovedRequestFragment()
        Utilities.changeUserType(nav_view, this)

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            root_view_cl!!.setBackgroundResource(R.drawable.full_screen_background_orang)
            nav_view.itemIconTintList = ColorStateList.valueOf(resources.getColor(R.color.orange))
        }
    }

    private fun attachHistoryNotificationsFragment() {

        val fragment = NotificationsHistoryFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun attachApprovedRequestFragment() {

        val fragment = ApprovedNotificationsFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
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

    override fun onClick(view: View) {


        when (view.id) {
            R.id.approved_request_tv -> {
                attachApprovedRequestFragment()
                tab_indicator1!!.visibility = View.VISIBLE
                tab_indicator2!!.visibility = View.INVISIBLE
                approved_request_tv!!.setTextColor(resources.getColor(R.color.blue_dark))
                history_notification_tv!!.setTextColor(resources.getColor(R.color.grey))
            }

            R.id.history_notification_tv -> {
                attachHistoryNotificationsFragment()
                tab_indicator1!!.visibility = View.INVISIBLE
                tab_indicator2!!.visibility = View.VISIBLE
                approved_request_tv!!.setTextColor(resources.getColor(R.color.grey))
                history_notification_tv!!.setTextColor(resources.getColor(R.color.blue_dark))
            }


            R.id.menu_icon -> if (!drawer_layout!!.isDrawerOpen(GravityCompat.START)) drawer_layout!!.openDrawer(GravityCompat.START)
        }
    }

    companion object {

        private val TAG = "NotificationsActivity"
    }
}
