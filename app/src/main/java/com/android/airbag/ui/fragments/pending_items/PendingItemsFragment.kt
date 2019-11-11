package com.android.airbag.ui.fragments.pending_items


import android.content.Intent
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.ui.activities.bags_list.BagListActivity
import com.android.airbag.ui.activities.create_bag.CreateBagActivity
import com.android.airbag.ui.activities.create_item.CreateItemActivity

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.fragment_pending_items.*

/**
 * A simple [Fragment] subclass.
 */
class PendingItemsFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pending_items, container, false)



        if (SharedPreferencesManager.getIntValue(context!!, Constants.USER_TYPE) == 1) {
            addNewItemButton!!.visibility = View.INVISIBLE
        }
        addNewItemButton!!.setOnClickListener { startActivity(Intent(context, CreateItemActivity::class.java)) }
        return view
    }


    companion object {

        private val TAG = "PendingItemsFragment"
    }
}// Required empty public constructor
