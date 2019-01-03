package com.example.marmm.animalviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Food> topFood;

    public SectionsPagerAdapter(FragmentManager fm, ArrayList<Food> topFood) {
        super(fm);
        this.topFood = topFood;

    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return FoodFragment.newInstance(topFood.get(position));
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return topFood.size();
    }
}
