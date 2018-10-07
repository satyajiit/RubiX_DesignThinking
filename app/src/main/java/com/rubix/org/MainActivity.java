package com.rubix.org;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OverviewFragment.OnFragmentInteractionListener,
        SyllabusFragment.OnFragmentInteractionListener, DTFragment.OnFragmentInteractionListener,AboutFragment.OnFragmentInteractionListener {
    private Toolbar toolbar;
    LinearLayout ll1, ll2, ll3;
    BottomNavigationView navigation;
    @Override
    public void setContentView(View view) {
        super.setContentView(view);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "fonts/dis.ttf");
        fontChanger.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); //sets screen always on

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, OverviewFragment.newInstance());
        fragmentTransaction.commit();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    //Change fragments by click nav buttons
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_over:
                    fragment = OverviewFragment.newInstance();
                    break;
                case R.id.navigation_syl:
                    fragment = SyllabusFragment.newInstance();
                    break;
                case R.id.navigation_dt:
                    fragment = DTFragment.newInstance();
                    break;
                case R.id.navigation_about:
                    fragment = AboutFragment.newInstance();
                    break;

            }
            if (fragment != null) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, fragment);
                fragmentTransaction.commit();
            }
            return true;
        }
    };


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;


        Snackbar snackbar= Snackbar.make(findViewById(R.id.placeSnackBar), "Hit back again to Exit..", Snackbar.LENGTH_LONG);

        snackbar.show();



        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }

}