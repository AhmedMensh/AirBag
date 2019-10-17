package com.android.airbag.ui.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.airbag.R;
import com.android.airbag.helpers.Constants;
import com.android.airbag.helpers.SharedPreferencesManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateBagFragment extends Fragment {

    private static final String TAG = "CreateBagFragment";
    private Unbinder unbinder;
    @BindView(R.id.create_item_btn)
    Button createBtn;

    public CreateBagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_bag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        unbinder = ButterKnife.bind(this ,view);
        if (SharedPreferencesManager.getIntValue(getContext(), Constants.USER_TYPE) == 1){
            createBtn.setBackgroundResource(R.drawable.button_background_2);
        }
    }
}
