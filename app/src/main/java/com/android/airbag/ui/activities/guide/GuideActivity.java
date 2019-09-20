package com.android.airbag.ui.activities.guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.airbag.R;
import com.android.airbag.ui.activities.bags_list.BagListActivity;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "GuideActivity";
    private Unbinder unbinder;
    SectionsPagerAdapter mSectionsPagerAdapter ;
    @BindView(R.id.view_pager) ViewPager mViewPager ;
    @BindView(R.id.dots_indicator)
    SpringDotsIndicator dotsIndicator;
    @BindView(R.id.skip_intro_tv) TextView skipIntroTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        unbinder = ButterKnife.bind(this);

        skipIntroTextView.setOnClickListener(this::onClick);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        dotsIndicator.setViewPager(mViewPager);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.skip_intro_tv:
                startActivity(new Intent(GuideActivity.this , BagListActivity.class));
                finish();
                break;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_guide, container, false);
            ImageView imageView = rootView.findViewById(R.id.image);

            //ImageView shadowImage = rootView.findViewById(R.id.shadow_iv);



            switch (getArguments().getInt(ARG_SECTION_NUMBER)){

                case 1 :
                    imageView.setImageResource(R.drawable.ic_logo_colored);
//                    ln.setBackgroundColor(Color.GRAY);
                    Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
                    break;
                case 2 :
                    imageView.setImageResource(R.drawable.ic_logo_colored);

                    Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
//                    ln.setBackgroundColor(Color.RED);

                    break;
                case 3 :
                    imageView.setImageResource(R.drawable.ic_logo_colored);
                    Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
//                    ln.setBackgroundColor(Color.BLACK);
                    break;


            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
