package com.android.airbag.ui.fragments.notifications_history;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.airbag.R;
import com.android.airbag.adapters.NotificationsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationsHistoryFragment extends Fragment {


    private static final String TAG = "NotificationsHistoryFra";
    private Unbinder unbinder;
    @BindView(R.id.notifications_history_rv)
    RecyclerView notificationsHistoryRv;
    public NotificationsHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications_history, container, false);

        unbinder = ButterKnife.bind(this,view);

        initNotificationsRv();
        return view;
    }

    private void initNotificationsRv() {
        notificationsHistoryRv.setLayoutManager(new LinearLayoutManager(getContext()));
        notificationsHistoryRv.setHasFixedSize(true);
        notificationsHistoryRv.setAdapter(new NotificationsAdapter());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
