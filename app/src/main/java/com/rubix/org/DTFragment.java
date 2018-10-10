package com.rubix.org;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class DTFragment extends Fragment implements ChildFragment.OnChildFragmentInteractionListener,galFrag.OnChildFragmentInteractionListener{
    TextView t1,t2,t3;
    Animation rtr;
    int pos=1;
    CardView c1,c2,c3;
    View v;
    static View.OnClickListener myOnClickListener;
Context c;
    ImageView i1,i2,i3;
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
            R.drawable.gal25


    };






    private OnFragmentInteractionListener listener;
    public static DTFragment newInstance() {
        return new DTFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {


        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("DesignThinking 1.0");
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v= inflater.inflate(R.layout.fragment_dt, container, false);

         final LayoutInflater f=inflater;
      final   ViewGroup g=container;

        rtr = AnimationUtils.loadAnimation(getActivity(),
                R.anim.anim_rotate_and_scale);


        t1=v.findViewById(R.id.img1);
        t2=v.findViewById(R.id.img2);
        t3=v.findViewById(R.id.img3);

        c1=v.findViewById(R.id.crd11);
        c2=v.findViewById(R.id.crd22);
        c3=v.findViewById(R.id.crd33);


        i1=v.findViewById(R.id.arr1);
        i2=v.findViewById(R.id.arr2);
        i3=v.findViewById(R.id.arr3);

        t1.startAnimation(rtr);

        Fragment galFrag = new galFrag();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, galFrag).commit();

        c1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Fragment galFrag = new galFrag();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, galFrag).commit();


             pos=1;
            intui();

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




                Fragment childFragment = new ChildFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, childFragment).commit();

               pos=2;
              intui();


            }
        });


        c3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

              pos=3;
             intui();






            }
        });


       // initViews();


        return v;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    public void messageFromChildToParent(String myString) {
        Log.i("TAG", myString);
    }

    public interface OnFragmentInteractionListener {
        void messageFromParentFragmentToActivity(String myString);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "fonts/Cav.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());

    }




    public void intui(){
        if(pos==1){
            t1.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundpink));
            t1.startAnimation(rtr);
            i1.setVisibility(View.VISIBLE);
            prs();
        }

        else if(pos==2){

            t2.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundpink));
            t2.startAnimation(rtr);
            i2.setVisibility(View.VISIBLE);
            prs();
        }

        else if(pos==3){

            t3.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundpink));
            t3.startAnimation(rtr);
            i3.setVisibility(View.VISIBLE);
            prs();

        }
    }

    public void prs(){

        if(pos!=1) {

            t1.setAnimation(null);
            t1.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc));
            i1.setVisibility(View.INVISIBLE);

        }
        if(pos!=2){
            t2.setAnimation(null);
            t2.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc));
            i2.setVisibility(View.INVISIBLE);
        }
        if(pos!=3) {
            t3.setAnimation(null);
            t3.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc));
            i3.setVisibility(View.INVISIBLE);
        }


    }
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(v.getContext().getApplicationContext());
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





}