package com.example.rateacher.Adapters;

import android.content.Context;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.rateacher.Fragments.CommentsFragment;
import com.example.rateacher.Fragments.MenuFragment;
import com.example.rateacher.Fragments.RestaurantInfoFragment;
import com.example.rateacher.R;
import com.google.firebase.database.annotations.Nullable;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class RestaurantSectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_info,R.string.tab_text_menu,R.string.tab_text_komente,R.string.tab_text_komente};
    private final Context mContext;

    public RestaurantSectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a RestaurantInfoFragment (defined as a static inner class below).
        //return RestaurantInfoFragment.newInstance(position + 1);

        int i=position%4;
       if(i==0)
         return  RestaurantInfoFragment.newInstance(position+1);
       else if (i==1)
           return MenuFragment.newInstance("","");
       else if(i==2)
            return  CommentsFragment.newInstance(position+1);
       else return CommentsFragment.newInstance(position+1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}