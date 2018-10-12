package com.rubix.org;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class galFrag extends Fragment implements View.OnClickListener {


    // **************** start interesting part ************************
View v;
    private OnChildFragmentToActivityInteractionListener mActivityListener;
    private OnChildFragmentInteractionListener mParentListener;
    private final String gal_item_names[] = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",

            "20",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",


            "13",
            "14",
            "15",
            "16",
            "17"


    };

    private final int gal_image_urls[] = {
            R.drawable.gal1,
            R.drawable.gal2,
            R.drawable.gal3,
            R.drawable.gal4,
            R.drawable.gal5,
            R.drawable.gal6,
            R.drawable.gal7,
            R.drawable.gal8,
            R.drawable.gal9,
            R.drawable.gal10,
            R.drawable.gal11,
            R.drawable.gal18,
            R.drawable.gal21,
            R.drawable.gal22,
            R.drawable.gal23,
            R.drawable.gal24,
            R.drawable.gal25,
            R.drawable.gal12,
            R.drawable.gal13,
            R.drawable.gal14,
            R.drawable.gal15,
            R.drawable.gal16,
            R.drawable.gal17,
            R.drawable.gal20,
            R.drawable.ex1,
            R.drawable.ex2,
            R.drawable.ex3,
            R.drawable.ex4,
            R.drawable.ex5
    };
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    public interface OnChildFragmentToActivityInteractionListener {
        void messageFromChildFragmentToActivity(String myString);
    }

    public interface OnChildFragmentInteractionListener {
        void messageFromChildToParent(String myString);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // check if Activity implements listener
        if (context instanceof OnChildFragmentToActivityInteractionListener) {
            mActivityListener = (OnChildFragmentToActivityInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnChildFragmentToActivityInteractionListener");
        }

        // check if parent Fragment implements listener
        if (getParentFragment() instanceof OnChildFragmentInteractionListener) {
            mParentListener = (OnChildFragmentInteractionListener) getParentFragment();
        } else {
            throw new RuntimeException("The parent fragment must implement OnChildFragmentInteractionListener");
        }
    }

    // **************** end interesting part ************************



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gal, container, false);

        v=view;
        //view.findViewById(R.id.child_fragment_contact_activity_button).setOnClickListener(this);
        //view.findViewById(R.id.child_fragment_contact_parent_button).setOnClickListener(this);

        initViews();
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityListener = null;
        mParentListener = null;
    }
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(v.getContext().getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(v.getContext().getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        ImagesListAdapter adapter = new ImagesListAdapter(v.getContext().getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList prepareData(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<gal_item_names.length;i++){
            GalleryImages galleryImages = new GalleryImages();
            galleryImages.setGal_item_name(gal_item_names[i]);
            galleryImages.setGal_image_url(gal_image_urls[i]);
            android_version.add(galleryImages);
        }
        return android_version;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "fonts/Cav.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());

    }
}