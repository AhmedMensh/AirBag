package com.android.airbag.ui.activities.create_bag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.android.airbag.R;
import com.android.airbag.ui.fragments.CreateBagFragment;
import com.android.airbag.ui.fragments.available_bags.AvailableBagsFragment;

public class BagListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag_list);

        AvailableBagsFragment availableBagsFragment = new AvailableBagsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment_container,availableBagsFragment);
        transaction.commit();
     }
}
