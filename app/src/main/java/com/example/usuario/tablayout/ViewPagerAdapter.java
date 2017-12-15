package com.example.usuario.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by usuario on 12/13/17.
 */

class ViewPagerAdapter extends FragmentPagerAdapter {

    private int pageCount;
    private ArrayList<String> titulos;

    public ViewPagerAdapter(FragmentManager fm, int pageCount, ArrayList<String> titulos) {
        super(fm);
        this.pageCount = pageCount;
        this.titulos = titulos;
    }

    @Override
    public Fragment getItem(int position) {
        CustomFragment customFragment = null;
        Bundle bundle = new Bundle();

        switch (position) {
            case 0:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 1");
                customFragment = CustomFragment.newInstance(bundle);
                break;

            case 1:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 2");
                customFragment = CustomFragment.newInstance(bundle);
                break;

            case 2:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 3");
                customFragment = CustomFragment.newInstance(bundle);
                break;

            case 3:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 4");
                customFragment = CustomFragment.newInstance(bundle);
                break;

            case 4:
                bundle.putString(CustomFragment.KEY_MESSAGE, "Fragment 5");
                customFragment = CustomFragment.newInstance(bundle);
                break;
        }

        return customFragment;

    }

    @Override
    public int getCount() {
        return pageCount;
    }

    /*
    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
    }
    */
}
