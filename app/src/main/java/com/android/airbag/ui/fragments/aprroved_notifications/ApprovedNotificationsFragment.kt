package com.android.airbag.ui.fragments.aprroved_notifications


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.fragment_approved_notifications.*

/**
 * A simple [Fragment] subclass.
 */
class ApprovedNotificationsFragment : Fragment(), View.OnClickListener {


    internal lateinit var carrierDetailsdDialog: AlertDialog


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_approved_notifications, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        show_carrier_details_btn!!.setOnClickListener{ this.onClick(it) }
        if (SharedPreferencesManager.getIntValue(context, Constants.USER_TYPE) == 1) {
            show_carrier_details_btn!!.setBackgroundResource(R.drawable.button_background_2)
        }
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.show_carrier_details_btn -> showCarrierDetailsDialog()
        }
    }

    private fun showCarrierDetailsDialog() {

        val builder = AlertDialog.Builder(context!!)
        val view = layoutInflater.inflate(R.layout.contact_carrier_dialog, null)

        builder.setView(view)

        carrierDetailsdDialog = builder.create()
        carrierDetailsdDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        carrierDetailsdDialog.show()

    }

    companion object {

        private val TAG = "ApprovedNotificationsFr"
    }
}// Required empty public constructor
