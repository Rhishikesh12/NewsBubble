package com.example.newsbubble;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tablayout;
    TabItem mhome, mtech, msports, mentertainment,mhealth,mscience;
    PageAdapter pagerAdapter;
    Toolbar mtoolbar;

    String api = "3bf4e0ab2601477b990923690bc052e0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.Home);
        mtech = findViewById(R.id.Technology);
        msports = findViewById(R.id.Sports);
        mentertainment = findViewById(R.id.Entertainment);
        mhealth = findViewById(R.id.Health);
        mscience = findViewById(R.id.Science);

        ViewPager viewPager = findViewById(R.id.fragmentContainer);

        tablayout = findViewById(R.id.include);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||
                        tab.getPosition()==3|| tab.getPosition()==4||tab.getPosition()==5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }
}