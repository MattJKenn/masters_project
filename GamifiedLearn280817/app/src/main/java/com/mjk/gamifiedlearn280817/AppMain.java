package com.mjk.gamifiedlearn280817;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class AppMain extends AppCompatActivity {


    FragmentManager fragmentManager;

    BottomNavigationView bottomNavigationView;
    NonSwipeableViewPager viewPager;

    SectionsFragment sectionsFragment;
    ProfileFragment profileFragment;
    SavedQFragment savedQFragment;

    MenuItem prevMenuItem = null;
    int tabPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);

        viewPager = (NonSwipeableViewPager) findViewById(R.id.viewPager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        fragmentManager = getSupportFragmentManager();

        setupUserData();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_sections:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_profile:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_saved_q:
                        viewPager.setCurrentItem(2);
                        break;
                    default:
                        viewPager.setCurrentItem(0);
                        break;
                }
                return false;
            }
        });

        viewPager.setOffscreenPageLimit(3);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    Menu menu = bottomNavigationView.getMenu();
                    MenuItem menuItem = menu.getItem(0);
                    menuItem.setChecked(false);
                }

                Menu menu = bottomNavigationView.getMenu();
                MenuItem menuItem = menu.getItem(position);
                menuItem.setChecked(true);
                prevMenuItem = menuItem;
                tabPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        setupViewPager(viewPager);
    }

    void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentManager);
        sectionsFragment = new SectionsFragment();
        profileFragment = new ProfileFragment();
        savedQFragment = new SavedQFragment();
        adapter.addFragment(sectionsFragment);
        adapter.addFragment(profileFragment);
        adapter.addFragment(savedQFragment);
        viewPager.setAdapter(adapter);

        System.out.println(adapter.getCount());
    }

    public void setupUserData() {
        SharedPreferences badgeProgressPref = getSharedPreferences("progress", MODE_PRIVATE);
        //SharedPreferences badge2status = getSharedPreferences("badge2", MODE_PRIVATE);

        //BadgeLogic.setBadges();
    }
}
