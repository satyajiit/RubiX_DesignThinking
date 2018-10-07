package com.rubix.org;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SyllabusFragment extends Fragment {
    private OnFragmentInteractionListener listener;

    CardView c1,c2,c3;
    ImageView i1,i2,i3;
    Button nw;
    int pos=1;
    TextView t1,t2,t3,exp,exp2;
    Animation animationFadeIn,trans,rtr;
    public static SyllabusFragment newInstance() {
        return new SyllabusFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Schedule of Workshop");

        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_syl, container, false);

        rtr = AnimationUtils.loadAnimation(getActivity(),
                R.anim.anim_rotate_and_scale);

        trans = AnimationUtils.loadAnimation(getActivity(),
                R.anim.anim_translate_in);

        animationFadeIn = AnimationUtils.loadAnimation(getActivity(),
                R.anim.fade_in);

        c1=view.findViewById(R.id.crd11);
        c2=view.findViewById(R.id.crd22);
        c3=view.findViewById(R.id.crd33);

        i1=view.findViewById(R.id.arr1);
        i2=view.findViewById(R.id.arr2);
        i3=view.findViewById(R.id.arr3);

        exp=view.findViewById(R.id.exp2);
        exp2=view.findViewById(R.id.exp);

        t1=view.findViewById(R.id.img1);
        t2=view.findViewById(R.id.img2);
        t3=view.findViewById(R.id.img3);

        nw=view.findViewById(R.id.nextw);

        t1.startAnimation(rtr);



        exp.startAnimation(trans);
            exp2.startAnimation(animationFadeIn);

        c1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                pos=1;
                intui();

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


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

nw.startAnimation(animationFadeIn);

        nw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ++pos;
                if(pos==3){


                }
                else if(pos==4) {
                    pos=1;
                }

            nw.setAnimation(null);
                intui();
            }
        });






        return view;
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

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "fonts/Cav.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());





    }



    public interface OnFragmentInteractionListener {
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

    public void intui(){
        if(pos==1){
            t1.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundpink));
            i1.setVisibility(View.VISIBLE);

            exp.setText(getResources().getString(R.string.week1));
            exp2.setText(getResources().getString(R.string.week1s));
            nw.setText("NEXT WEEK");
            exp.startAnimation(trans);
            t1.startAnimation(rtr);
            exp2.startAnimation(animationFadeIn);
            prs();
        }
        else if(pos==2){
            t2.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundpink));
            i2.setVisibility(View.VISIBLE);

            nw.setText("NEXT WEEK");
            exp.setText(getResources().getString(R.string.week2));
            exp2.setText(getResources().getString(R.string.week2s));

            exp.startAnimation(trans);
            exp2.startAnimation(animationFadeIn);
            t2.startAnimation(rtr);
            prs();
        }

        else if(pos==3){

            nw.setText("< FIRST WEEK");

            t3.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundpink));
            i3.setVisibility(View.VISIBLE);


            exp.setText(getResources().getString(R.string.week3));
            exp2.setText(getResources().getString(R.string.week3s));

            exp.startAnimation(trans);
            t3.startAnimation(rtr);
            exp2.startAnimation(animationFadeIn);
            prs();

        }
    }

}
