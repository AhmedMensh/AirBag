package com.android.airbag.ui.fragments.filter


import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_filter.*

/**
 * A simple [Fragment] subclass.
 */
class FilterFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (SharedPreferencesManager.getIntValue(context!!, Constants.USER_TYPE) == 1) {
            filter_btn!!.setBackgroundResource(R.drawable.button_background_2)
        }
    }

    companion object {

        private val TAG = "FilterFragment"
    }
}// Required empty public constructor
