package com.android.airbag.ui.fragments.pending_items


import android.content.Intent
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.ui.activities.create_item.CreateItemActivity

import kotlinx.android.synthetic.main.fragment_pending_items.*

/**
 * A simple [Fragment] subclass.
 */
class PendingItemsFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pending_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        if (SharedPreferencesManager.getIntValue(context!!, Constants.USER_TYPE) == 1) {
            addNewItemButton.visibility = View.INVISIBLE
        }
        addNewItemButton.setOnClickListener { startActivity(Intent(context, CreateItemActivity::class.java)) }
    }


    companion object {

        private val TAG = "PendingItemsFragment"
    }
}// Required empty public constructor
