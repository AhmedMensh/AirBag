package com.android.airbag.ui.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.ui.activities.bags_list.BagListActivity
import com.android.airbag.ui.activities.carrier_bags.CarrierBagsActivity
import com.android.airbag.ui.activities.complaints.ComplaintsActivity
import com.android.airbag.ui.activities.create_bag.CreateBagActivity
import com.android.airbag.ui.activities.create_item.CreateItemActivity
import com.android.airbag.ui.activities.guide.GuideActivity
import com.android.airbag.ui.activities.login.LoginActivity
import com.android.airbag.ui.activities.notifications.NotificationsActivity
import com.android.airbag.ui.activities.payment.PaymentActivity
import com.android.airbag.ui.activities.profile_settings.ProfileSettingsActivity
import com.android.airbag.ui.activities.promo_code.PromoCodeActivity
import com.android.airbag.ui.activities.reserved_bags.ReservedBagsActivity
import com.android.airbag.ui.activities.rules.RulesActivity
import com.google.android.material.navigation.NavigationView

abstract class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    protected lateinit var navigationView: NavigationView
    internal lateinit var logoutDialog: AlertDialog

    abstract val contentViewId: Int
    abstract val navigationMenuItemId: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentViewId)


        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { this.onNavigationItemSelected(it) }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.navigation_home, R.id.navigation_current_bag -> {
                if (navigationMenuItemId == R.id.navigation_home) {
                    Toast.makeText(this, "You are in bag list ", Toast.LENGTH_SHORT).show()
                    return false
                }
                if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 0)
                    startActivity(Intent(this, BagListActivity::class.java))
                else
                    startActivity(Intent(this, CarrierBagsActivity::class.java))
            }


            R.id.navigation_create -> {
                if (navigationMenuItemId == R.id.navigation_create) {
                    Toast.makeText(this, "You are in bag list ", Toast.LENGTH_SHORT).show()
                    return false
                }
                if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 0)
                    startActivity(Intent(this, CreateBagActivity::class.java))
                else
                    startActivity(Intent(this, CreateItemActivity::class.java))
            }

            R.id.navigation_message -> {
                if (navigationMenuItemId == R.id.navigation_message) {
                    Toast.makeText(this, "You are in notifications activity", Toast.LENGTH_SHORT).show()
                    return false
                }
                startActivity(Intent(this, NotificationsActivity::class.java))
            }

            R.id.navigation_profile -> startActivity(Intent(this, ProfileSettingsActivity::class.java))


            R.id.navigation_history -> startActivity(Intent(this, ReservedBagsActivity::class.java))


            R.id.navigation_help -> startActivity(Intent(this, ComplaintsActivity::class.java))

            R.id.navigation_how_it_works -> startActivity(Intent(this, GuideActivity::class.java))

            R.id.navigation_about -> startActivity(Intent(this, RulesActivity::class.java))

            R.id.navigation_referrals -> startActivity(Intent(this, PromoCodeActivity::class.java))
            R.id.navigation_logout -> showLogoutDialog()
        }

        return false
    }

    private fun showLogoutDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.log_out_dialog, null)

        val agreeButton = view.findViewById<Button>(R.id.yes_btn)
        val cancelButton = view.findViewById<Button>(R.id.cancel_btn)

        cancelButton.setOnClickListener { logoutDialog.dismiss() }
        agreeButton.setOnClickListener {
            startActivity(Intent(this@BaseActivity, LoginActivity::class.java))
            finish()
        }

        builder.setView(view)

        logoutDialog = builder.create()
        logoutDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        logoutDialog.show()
    }

    companion object {

        private val TAG = "BaseActivity"
    }

}
