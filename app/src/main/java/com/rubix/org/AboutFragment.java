package com.rubix.org;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;


public class AboutFragment extends Fragment {
    Animation rtr,tin;
    View v;
    private OnFragmentInteractionListener listener;
    public static AboutFragment newInstance() {
        return new AboutFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {


        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("DesignThinking 2.0 - About");
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


v=inflater.inflate(R.layout.fragment_abt, container, false);
        rtr = AnimationUtils.loadAnimation(v.getContext(),
                R.anim.rtr);
        tin = AnimationUtils.loadAnimation(v.getContext(),
                R.anim.anim_translate_in);


        TextView t1=v.findViewById(R.id.exp2);
        TextView t2=v.findViewById(R.id.exp222);
        ImageView i=v.findViewById(R.id.rbx);
        TextView sj=v.findViewById(R.id.sj);

        t1.startAnimation(tin);
        t2.startAnimation(tin);
        i.startAnimation(rtr);


        sj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.linkedin.com/in/satyajiit"));
                startActivity(browserIntent);


            }
        });

        i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.linkedin.com/in/satyajiit"));
                startActivity(browserIntent);


            }
        });

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "fonts/Cav.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());
        KonfettiView viewKonfetti=v.findViewById(R.id.viewKonfetti);
        viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA,Color.BLUE)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(17000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5))
                .setPosition(90f, viewKonfetti.getWidth() + 50f, -50f, -50f)
                .streamFor(150, 2000L);
    }


    public interface OnFragmentInteractionListener {
    }
}