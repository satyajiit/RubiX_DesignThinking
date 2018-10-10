package com.rubix.org;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ChildFragment extends Fragment implements View.OnClickListener {


    // **************** start interesting part ************************

    private OnChildFragmentToActivityInteractionListener mActivityListener;
    private OnChildFragmentInteractionListener mParentListener;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //case R.id.child_fragment_contact_activity_button:
               // mActivityListener.messageFromChildFragmentToActivity("Hello, Activity. I am the child fragment.");
                //break;
            //case R.id.child_fragment_contact_parent_button:
               // mParentListener.messageFromChildToParent("Hello, parent. I am your child.");
               // break;
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
        View view = inflater.inflate(R.layout.fragment_prj, container, false);
        //view.findViewById(R.id.child_fragment_contact_activity_button).setOnClickListener(this);
        //view.findViewById(R.id.child_fragment_contact_parent_button).setOnClickListener(this);
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