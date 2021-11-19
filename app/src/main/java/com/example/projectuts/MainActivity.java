package com.example.projectuts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout myTab;
    ViewPager myPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTab = (TabLayout) findViewById(R.id.myTab);
        myPage = (ViewPager)findViewById(R.id.myPager);

        myPage.setAdapter(new MyOwnPagerAdapter(getSupportFragmentManager()));
        myTab.setupWithViewPager(myPage);

        myTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    public void gotoFilm(View view) {
        Intent intent = new Intent(this, FilmDirectory.class);
        startActivity(intent);
    }

    public void gotoSetting(View view) {
        Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
        startActivity(intent);
    }

    class MyOwnPagerAdapter extends FragmentPagerAdapter {

        String page[] ={"Home", "About"};

        public MyOwnPagerAdapter(FragmentManager fm){super(fm);}

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new Home();
            }
            if(position == 1){
                return new About();
            }
            return null;
        }

        @Override
        public int getCount() {
            return page.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return page[position];
        }
    }
}