package com.rubix.org;


import android.app.AlertDialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.LinearLayout;

import dmax.dialog.SpotsDialog;


public class MainActivity extends AppCompatActivity implements OverviewFragment.OnFragmentInteractionListener,
        SyllabusFragment.OnFragmentInteractionListener, DTFragment.OnFragmentInteractionListener,AboutFragment.OnFragmentInteractionListener {
    private Toolbar toolbar;
    LinearLayout ll1, ll2, ll3;
    BottomNavigationView navigation;

    Animation animation;
    AlertDialog dialog;
    Context c;
    @Override
    public void setContentView(View view) {
        super.setContentView(view);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "fonts/dis.ttf");
        fontChanger.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));

        animation = AnimationUtils.loadAnimation(this,
                R.anim.anim_rotate_and_scale);

        c=this;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.icon:
new loader().execute();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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


        dialog = new SpotsDialog.Builder()
                .setContext(this)
                .setTheme(R.style.regis)
                .build();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



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


    private class loader extends AsyncTask<String, Integer, String> {




        // Runs in UI before background thread is called
        @Override
        protected void onPreExecute() {


dialog.setCancelable(false);
            dialog.show();



        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {


            String res="";
            try {




                Thread.sleep(3500);






            } catch (Exception e) {

                Log.d("CSE", String.valueOf(e));
            }


            return res;
        }

        // This is called from background thread but runs in UI
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            // Do things like update the progress bar
        }

        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://google.in"));
            startActivity(browserIntent);

        }
    }


}