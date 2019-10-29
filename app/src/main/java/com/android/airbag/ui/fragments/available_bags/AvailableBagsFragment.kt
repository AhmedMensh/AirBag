package com.android.airbag.ui.fragments.available_bags


import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.airbag.R
import com.android.airbag.adapters.AvailableBagsAdapter

import kotlinx.android.synthetic.main.fragment_available_bags.*

/**
 * A simple [Fragment] subclass.
 */
class AvailableBagsFragment : Fragment(), AvailableBagsAdapter.ItemClickListener {
    private var bagsAdapter: AvailableBagsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_available_bags, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBagsRv()
    }
    private fun initBagsRv() {

        layoutManager = LinearLayoutManager(context)
        bagsAdapter = AvailableBagsAdapter(this)
        available_bags_rv!!.adapter = bagsAdapter
        available_bags_rv!!.setHasFixedSize(true)
        available_bags_rv!!.layoutManager = layoutManager


    }

    private fun smoothScroll(itemPosition: Int) {
        val smoothScroller = object : LinearSmoothScroller(context!!) {
            override fun getVerticalSnapPreference(): Int {
                return LinearSmoothScroller.SNAP_TO_START
            }
        }
        smoothScroller.targetPosition = itemPosition
        layoutManager!!.startSmoothScroll(smoothScroller)
    }

    override fun onItemClickListener(itemPosition: Int) {
        smoothScroll(itemPosition)
    }

    companion object {

        private val TAG = "AvailableBagsFragment"
    }
}// Required empty public constructor
