package com.android.airbag.ui.fragments.available_bags;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.airbag.R;
import com.android.airbag.adapters.AvailableBagsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AvailableBagsFragment extends Fragment {

    private static final String TAG = "AvailableBagsFragment";
    private AvailableBagsAdapter bagsAdapter;
    private Unbinder unbinder;

    @BindView(R.id.available_bags_rv)
    RecyclerView availableBagsRv;

    public AvailableBagsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_available_bags, container, false);

        unbinder = ButterKnife.bind(this,view);
        initBagsRv();
        return view;
    }

    private void initBagsRv() {

        bagsAdapter = new AvailableBagsAdapter();
        availableBagsRv.setAdapter(bagsAdapter);
        availableBagsRv.setHasFixedSize(true);
        availableBagsRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
