package com.android.airbag.ui.fragments.aprroved_notifications;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.airbag.R;
import com.android.airbag.ui.activities.BaseActivity;
import com.android.airbag.ui.activities.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApprovedNotificationsFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "ApprovedNotificationsFr";
    private Unbinder unbinder;
    @BindView(R.id.show_carrier_details_btn)
    Button showCarrierDetailsButton;

    AlertDialog carrierDetailsdDialog;

    public ApprovedNotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_approved_notifications, container, false);

        unbinder = ButterKnife.bind(this ,view);
        showCarrierDetailsButton.setOnClickListener(this::onClick);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.show_carrier_details_btn:
                showCarrierDetailsDialog();
                break;
        }
    }

    private void showCarrierDetailsDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.contact_carrier_dialog,null);

        builder.setView(view);

        carrierDetailsdDialog = builder.create();
        carrierDetailsdDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        carrierDetailsdDialog.show();

    }
}
