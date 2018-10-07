package com.rubix.org;



import android.content.Context;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class OverviewFragment extends Fragment {

    CardView cir;
LinearLayout ll1,ll2,ll3;
ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img11,img22,img33,img44,img55,img66,img77,img88,img99;
TextView exp;
Button next;
View v;



int position=1;

    Timer timerAsync;
     Animation animation,animationFade,animationOut,animationFadeIn,TRA;

    private OnFragmentInteractionListener listener;
    public static OverviewFragment newInstance() {
        return new OverviewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


      ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("DesignThinking - Overview");
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ovr, container, false);


         exp=view.findViewById(R.id.exp);

        cir=view.findViewById(R.id.imgCir);



        next=view.findViewById(R.id.next);



        img1=view.findViewById(R.id.img1);
        img2=view.findViewById(R.id.img2);
        img3=view.findViewById(R.id.img3);
        img4=view.findViewById(R.id.img4);
        img5=view.findViewById(R.id.img5);
        img6=view.findViewById(R.id.img6);
        img7=view.findViewById(R.id.img7);
        img8=view.findViewById(R.id.img8);
        img9=view.findViewById(R.id.img9);



        img11=view.findViewById(R.id.img11);
        img22=view.findViewById(R.id.img22);
        img33=view.findViewById(R.id.img33);
        img44=view.findViewById(R.id.img44);
        img55=view.findViewById(R.id.img55);
        img66=view.findViewById(R.id.img66);
        img77=view.findViewById(R.id.img77);
        img88=view.findViewById(R.id.img88);
        img99=view.findViewById(R.id.img99);


        TRA = AnimationUtils.loadAnimation(getActivity(),
                R.anim.anim_translate_in); //translate in

        animation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.anim_rotate_and_scale);

        animationFadeIn = AnimationUtils.loadAnimation(getActivity(),
                R.anim.fade_in); //for button

        animationFade = AnimationUtils.loadAnimation(getActivity(),
                R.anim.fade_in);  //for text nessage
// Start animating the image
        animationOut = AnimationUtils.loadAnimation(getActivity(),
                R.anim.fade_out);

        img1.startAnimation(animation);

        next.startAnimation(TRA);



        cir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                ++position;

                set();
                setColors(position);



            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                timerAsync.cancel();

                loop();

                set();
                setColors(position);






            }
        });



img1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                timerAsync.cancel();

                position=1;
                set();
                setColors(position);

                loop();

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                timerAsync.cancel();
                position=2;
                set();
                setColors(position);
                loop();


            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                timerAsync.cancel();
                position=3;
                set();
                setColors(position);
                loop();

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                timerAsync.cancel();
                position=4;
                set();
                setColors(position);
                loop();

            }
        });

       img5.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {


               timerAsync.cancel();
               position=5;

               set();
               setColors(position);
               loop();

           }
       });

        img6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                timerAsync.cancel();
                position=6;

                set();
                setColors(position);
                loop();

            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                timerAsync.cancel();
                position=7;

                set();
                setColors(position);
                loop();

            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                timerAsync.cancel();

                position=8;

                set();
                setColors(position);
                loop();
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                timerAsync.cancel();
                position=9;
                set();
                setColors(position);
                loop();

            }
        });


loop();









        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "fonts/Cav.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());



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
        timerAsync.cancel();
    }

    public interface OnFragmentInteractionListener {
    }

    public void setColors(int pos){

        if(pos!=1) {
            img1.setAnimation(null);
            img1.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc,null));
            img11.setVisibility(View.INVISIBLE);

        }
        if(pos!=2) {
            img2.setAnimation(null);
            img22.setVisibility(View.INVISIBLE);
            img2.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc,null));

        }
        if(pos!=3) {
            img3.setAnimation(null);
            img33.setVisibility(View.INVISIBLE);
            img3.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc,null));

        }
        if(pos!=4) {
            img4.setAnimation(null);
            img44.setVisibility(View.INVISIBLE);
            img4.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc,null));

        }
        if(pos!=5) {
            img5.setAnimation(null);
            img55.setVisibility(View.INVISIBLE);
            img5.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc,null));

        }
        if(pos!=6) {
            img6.setAnimation(null);
            img66.setVisibility(View.INVISIBLE);
            img6.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc,null));

        }
        if(pos!=7) {
            img7.setAnimation(null);
            img77.setVisibility(View.INVISIBLE);
            img7.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc,null));

        }
        if(pos!=8) {
            img8.setAnimation(null);
            img88.setVisibility(View.INVISIBLE);
            img8.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc,null));

        }
        if(pos!=9) {
            img9.setAnimation(null);
            img99.setVisibility(View.INVISIBLE);
            img9.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc,null));

        }
















    }

public void set(){


        if(position>9) position=1;








        if(position==1){
            img1.setBackground(getResources().getDrawable(R.drawable.cirg,null));
            img11.setVisibility(View.VISIBLE);
            img1.startAnimation(animation);
            exp.startAnimation(animationFade);
            exp.setText(getResources().getString(R.string.learn));
        }
    else if(position==2){
        img2.setBackground(getResources().getDrawable(R.drawable.cirg,null));
        img22.setVisibility(View.VISIBLE);
            img2.startAnimation(animation);
            exp.startAnimation(animationFade);
            exp.setText(getResources().getString(R.string.submit));

    }
        else if(position==3){
            img3.setBackground(getResources().getDrawable(R.drawable.cirg,null));
            img33.setVisibility(View.VISIBLE);
            img3.startAnimation(animation);
            exp.startAnimation(animationFade);
            exp.setText(getResources().getString(R.string.identify));
        }
        else if(position==4){
            img4.setBackground(getResources().getDrawable(R.drawable.cirg,null));
            img44.setVisibility(View.VISIBLE);
            img4.startAnimation(animation);
            exp.startAnimation(animationFade);
            exp.setText(getResources().getString(R.string.four));
        }
        else if(position==5){
            img5.setBackground(getResources().getDrawable(R.drawable.cirg,null));
            img55.setVisibility(View.VISIBLE);
            img5.startAnimation(animation);
            exp.startAnimation(animationFade);
            exp.setText(getResources().getString(R.string.five));
        }
        else if(position==6){
            img6.setBackground(getResources().getDrawable(R.drawable.cirg,null));
            img66.setVisibility(View.VISIBLE);
            img6.startAnimation(animation);
            exp.startAnimation(animationFade);
            exp.setText(getResources().getString(R.string.six));
        }
        else if(position==7){
            img7.setBackground(getResources().getDrawable(R.drawable.cirg,null));
            img77.setVisibility(View.VISIBLE);
            img7.startAnimation(animation);
            exp.startAnimation(animationFade);
            exp.setText(getResources().getString(R.string.seven));
        }
        else if(position==8){
            img8.setBackground(getResources().getDrawable(R.drawable.cirg,null));
            img88.setVisibility(View.VISIBLE);
            img8.startAnimation(animation);
            exp.startAnimation(animationFade);
            exp.setText(getResources().getString(R.string.eight));
        }
        else if(position==9){
            img9.setBackground(getResources().getDrawable(R.drawable.cirg,null));
            img99.setVisibility(View.VISIBLE);
            img9.startAnimation(animation);
            exp.startAnimation(animationFade);
            exp.setText(getResources().getString(R.string.nine));
        }



}


public void loop(){
     timerAsync = new Timer();
   TimerTask timerTaskAsync = new TimerTask() {
        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override public void run() {
                    Log.i("Background Perform",
                            "-------> Text from Background Perform");


                    setColors(position);

                    set();

                    ++position;
                }
            });
        }
    };
    timerAsync.schedule(timerTaskAsync, 0, 4000);

}








}