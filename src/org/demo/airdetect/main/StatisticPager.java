package org.demo.airdetect.main;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StatisticPager extends FragmentActivity {
	
    CollectionPagerAdapter mCollectionPagerAdapter;    
    ViewPager mViewPager;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        mCollectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
       
        final ActionBar actionBar = getActionBar();      
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Set up the ViewPager, attaching the adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCollectionPagerAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//            	NavUtils.navigateUpTo(this, new Intent(this, IndexFragment.class));
            	finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * A {@link android.support.v4.app.FragmentStatePagerAdapter} that returns a fragment
     * representing an object in the collection.
     */
    public static class CollectionPagerAdapter extends FragmentStatePagerAdapter {

    	String[] titles = {"日","周","月"};
        public CollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
        	Bundle args = new Bundle();
            args.putInt(StatisticsFragment.EXTRA_ARG, i); // Our object is just an integer :-P
            Fragment fragment = new StatisticsFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // For this contrived example, we have a 100-object collection.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }   
}
