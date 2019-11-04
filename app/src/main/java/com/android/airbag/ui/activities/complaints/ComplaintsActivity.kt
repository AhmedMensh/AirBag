package com.android.airbag.ui.activities.complaints

import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.helpers.Utilities
import com.android.airbag.ui.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_complaints.*
import kotlinx.android.synthetic.main.activity_complaints.drawer_layout
import kotlinx.android.synthetic.main.activity_complaints.layout
import kotlinx.android.synthetic.main.activity_complaints.menu_icon
import kotlinx.android.synthetic.main.activity_complaints.nav_view


class ComplaintsActivity : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaints)



        nav_view.setNavigationItemSelectedListener(this)
        menu_icon!!.setOnClickListener { this.onClick(it) }
        submit_btn!!.setOnClickListener { this.onClick(it) }

        Utilities.changeUserType(nav_view, this)
        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {
            layout!!.setBackgroundResource(R.drawable.full_screen_background_orang)
            submit_btn!!.setBackgroundResource(R.drawable.button_background_2)
            nav_view.itemIconTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.orange))
        }
    }

    override val contentViewId: Int
        get() = R.layout.activity_complaints

    override val navigationMenuItemId: Int
        get() = R.id.navigation_help

    override fun onClick(view: View) {

        when (view.id) {
            R.id.menu_icon -> if (!drawer_layout!!.isDrawerOpen(GravityCompat.START)) drawer_layout!!.openDrawer(GravityCompat.START)

            R.id.submit_btn -> showConfirmationDialog()
        }
    }

    private fun showConfirmationDialog() {

        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.confirm_dialog, null)

        builder.setView(view)

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

    }

    companion object {

        private val TAG = "ComplaintsActivity"
    }
}
