package com.android.airbag.ui.fragments.pending_items;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.airbag.R;
import com.android.airbag.ui.activities.bags_list.BagListActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PendingItemsFragment extends Fragment {


    public PendingItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pending_items, container, false);

        view.findViewById(R.id.new_item_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((BagListActivity)getActivity()).attachCreatePendingItemsFragment();
            }
        });
        return  view;
    }

}
