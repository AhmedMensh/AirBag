package com.android.airbag.ui.activities.guide

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager
import com.android.airbag.ui.activities.bags_list.BagListActivity
import com.android.airbag.ui.activities.carrier_bags.CarrierBagsActivity

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.activity_guide.*

class GuideActivity : AppCompatActivity(), View.OnClickListener {

    private var userType: Int = 0
    internal lateinit var mSectionsPagerAdapter: SectionsPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)


        skip_intro_tv!!.setOnClickListener{ this.onClick(it) }
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        view_pager!!.adapter = mSectionsPagerAdapter
        dots_indicator!!.setViewPager(view_pager!!)

        userType = SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE)
        if (userType == 1) {
            logo_iv!!.setImageResource(R.drawable.ic_logo_orang)
            app_name_tv!!.setTextColor(resources.getColor(R.color.orange))

        }

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.skip_intro_tv -> {
                if (userType == 1)
                    startActivity(Intent(this@GuideActivity, CarrierBagsActivity::class.java))
                else
                    startActivity(Intent(this@GuideActivity, BagListActivity::class.java))
                finish()
            }
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {


        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_guide, container, false)
            val imageView = rootView.findViewById<ImageView>(R.id.image)

            //ImageView shadowImage = rootView.findViewById(R.id.shadow_iv);


            when (arguments!!.getInt(ARG_SECTION_NUMBER)) {

                1 -> imageView.setImageResource(R.drawable.ic_guide_img1)
                2 -> imageView.setImageResource(R.drawable.ic_guide_img2)
                3 -> imageView.setImageResource(R.drawable.ic_guide_img3)
            }//                    ln.setBackgroundColor(Color.GRAY)
            //                    ln.setBackgroundColor(Color.RED);
            //                    ln.setBackgroundColor(Color.BLACK);

            return rootView
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }


    companion object {

        private val TAG = "GuideActivity"
    }
}
