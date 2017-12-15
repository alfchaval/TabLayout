package com.example.usuario.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * OPCIÓN 1: En este ejercicio se ha visto cómo crear un TabLayout de forma independiente al elemento ViewPager.
 * Para ello hay que implementar el listener en TabLayout y el listener en Viewpager y vincularlos de forma que
 * se actualice el otro elemento
 * OPCIÓN 2: Es vincular el Tablayout al ViewPager con el método setupWithViewPager().
 * se debe cumplir únicamente el siguiente requisito: el título de las pestañas del tab
 * se inicializarán mediante el método getPageTitle();
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.tabs)))));
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        for(String title:getResources().getStringArray(R.array.tabs)) {
            //tabLayout.addTab(tabLayout.newTab().setText(title));
            tabLayout.addTab(tabLayout.newTab());
        }

        //OPCIÓN 2:
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        //Si se quiere personalizar las pestañas del Tablayout siempre se debe realizar después del método Tablayout.


        //OPCIÓN 1:
        /*
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        */

    }

    private void setupTabIcons() {
        for(int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(getResources().getIdentifier("icon"+i,"drawable", getPackageName()));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}
