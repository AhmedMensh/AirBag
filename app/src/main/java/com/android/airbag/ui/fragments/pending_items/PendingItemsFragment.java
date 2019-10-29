package com.android.airbag.ui.fragments.pending_items;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.airbag.R;
import com.android.airbag.helpers.Constants;
import com.android.airbag.helpers.SharedPreferencesManager;
import com.android.airbag.ui.activities.bags_list.BagListActivity;
import com.android.airbag.ui.activities.create_bag.CreateBagActivity;
import com.android.airbag.ui.activities.create_item.CreateItemActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PendingItemsFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "PendingItemsFragment";
    private Unbinder unbinder;
    @BindView(R.id.new_item_btn)
    Button addNewItemButton;

    public PendingItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pending_items, container, false);

        unbinder = ButterKnife.bind(this,view);

        if (SharedPreferencesManager.INSTANCE.getIntValue(getContext(), Constants.INSTANCE.getUSER_TYPE()) == 1){
            addNewItemButton.setVisibility(View.INVISIBLE);
        }
        addNewItemButton.setOnClickListener(view1 ->
                startActivity(new Intent(getContext(), CreateItemActivity.class)));
        return  view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_item_btn:
                startActivity(new Intent(getContext(), CreateItemActivity.class));
                Log.e(TAG, "onClick: ");
                break;
        }
    }
}
