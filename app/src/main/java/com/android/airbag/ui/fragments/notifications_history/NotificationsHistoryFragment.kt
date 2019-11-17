package com.android.airbag.ui.fragments.notifications_history


import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.airbag.R
import com.android.airbag.adapters.NotificationsAdapter

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.fragment_notifications_history.*

/**
 * A simple [Fragment] subclass.
 */
class NotificationsHistoryFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_notifications_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNotificationsRv()

    }
    private fun initNotificationsRv() {

        notifications_history_rv.setHasFixedSize(true)
        notifications_history_rv.adapter = NotificationsAdapter()
    }


    companion object {


        private val TAG = "NotificationsHistoryFra"
    }
}// Required empty public constructor
