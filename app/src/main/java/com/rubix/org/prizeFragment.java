package com.rubix.org;

import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;




public class prizeFragment extends Fragment implements View.OnClickListener {
Animation rtr;

    // **************** start interesting part ************************
View v;
    private OnChildFragmentToActivityInteractionListener mActivityListener;
    private OnChildFragmentInteractionListener mParentListener;

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
        View view = inflater.inflate(R.layout.prizes_frag, container, false);


        rtr = AnimationUtils.loadAnimation(getActivity(),
                R.anim.anim_translate_in);

        ImageView i1=view.findViewById(R.id.i1);
        ImageView i2=view.findViewById(R.id.i2);
        ImageView i3=view.findViewById(R.id.i3);

        Picasso.get().load(R.drawable.win1).into(i1);
        Picasso.get().load(R.drawable.win2).into(i2);
        Picasso.get().load(R.drawable.win3).into(i3);

        i1.startAnimation(rtr);
        i2.startAnimation(rtr);
        i3.startAnimation(rtr);

        v=view;


        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityListener = null;
        mParentListener = null;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "fonts/Cav.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());

    }
}