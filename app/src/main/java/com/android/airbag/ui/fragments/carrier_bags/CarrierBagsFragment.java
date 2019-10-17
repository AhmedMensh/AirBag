package com.android.airbag.ui.fragments.carrier_bags;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.airbag.R;
import com.android.airbag.adapters.AvailableBagsAdapter;
import com.android.airbag.adapters.CarrierBagsAdapter;
import com.android.airbag.ui.activities.create_bag.CreateBagActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarrierBagsFragment extends Fragment implements CarrierBagsAdapter.ItemClickListener {
    private static final String TAG = "CarrierBagsFragment";
    private CarrierBagsAdapter carrierBagsAdapter;
    private Unbinder unbinder;
    private LinearLayoutManager layoutManager;

    @BindView(R.id.carrier_bags_rv)
    RecyclerView carrierBagsRv;

    public CarrierBagsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carrier_bags, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        unbinder = ButterKnife.bind(this,view);
        initBagsRv();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void initBagsRv() {

        layoutManager = new LinearLayoutManager(getContext());
        carrierBagsAdapter = new CarrierBagsAdapter(this);
        carrierBagsRv.setAdapter(carrierBagsAdapter);
        carrierBagsRv.setHasFixedSize(true);
        carrierBagsRv.setLayoutManager(layoutManager);


    }

    @Override
    public void onItemClickListener(int itemPosition) {

        startActivity(new Intent(getContext() , CreateBagActivity.class));
    }
}
