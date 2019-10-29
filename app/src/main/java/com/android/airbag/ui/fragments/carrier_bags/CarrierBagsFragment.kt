package com.android.airbag.ui.fragments.carrier_bags


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.airbag.R
import com.android.airbag.adapters.CarrierBagsAdapter
import com.android.airbag.ui.activities.create_bag.CreateBagActivity

import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.fragment_carrier_bags.*

/**
 * A simple [Fragment] subclass.
 */
class CarrierBagsFragment : Fragment(), CarrierBagsAdapter.ItemClickListener {
    private var carrierBagsAdapter: CarrierBagsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carrier_bags, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBagsRv()

    }


    private fun initBagsRv() {

        layoutManager = LinearLayoutManager(context)
        carrierBagsAdapter = CarrierBagsAdapter(this)
        carrier_bags_rv!!.adapter = carrierBagsAdapter
        carrier_bags_rv!!.setHasFixedSize(true)
        carrier_bags_rv!!.layoutManager = layoutManager


    }

    override fun onItemClickListener(itemPosition: Int) {

        startActivity(Intent(context, CreateBagActivity::class.java))
    }

    companion object {
        private val TAG = "CarrierBagsFragment"
    }
}// Required empty public constructor
