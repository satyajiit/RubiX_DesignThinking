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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class OverviewFragment extends Fragment {

    CardView learn,sub,cust;
LinearLayout ll1,ll2,ll3;
ImageView im1,im2,im3,img1,img2,img3;
TextView t1;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ovr, container, false);

        learn=view.findViewById(R.id.crd1);
        sub=view.findViewById(R.id.crd2);
        cust=view.findViewById(R.id.crd3);

        ll1=view.findViewById(R.id.ll1);
        ll2=view.findViewById(R.id.ll2);
        ll3=view.findViewById(R.id.ll3);

        im1=view.findViewById(R.id.ar1);
        im2=view.findViewById(R.id.ar2);
        im3=view.findViewById(R.id.ar3);


        img1=view.findViewById(R.id.img1);
        img2=view.findViewById(R.id.img2);
        img3=view.findViewById(R.id.img3);


        t1=view.findViewById(R.id.exp);

        learn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setColors(1);
                img1.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundgreen));
                im1.setVisibility(View.VISIBLE);
                t1.setText(getResources().getText(R.string.learn));
            }
        });


        sub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setColors(2);
                img2.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundgreen));
                im2.setVisibility(View.VISIBLE);
                t1.setText(getResources().getText(R.string.submit));
            }
        });


        cust.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setColors(3);
                img3.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundgreen));
                im3.setVisibility(View.VISIBLE);
                t1.setText(getResources().getText(R.string.identify));
            }
        });



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
    }

    public interface OnFragmentInteractionListener {
    }

    public void setColors(int pos){

        if(pos!=1) {
            img1.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc));
            im1.setVisibility(View.INVISIBLE);
        }
        if(pos!=2) {
            img2.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc));
            im2.setVisibility(View.INVISIBLE);
        }
        if(pos!=3) {
            img3.setBackground(getResources().getDrawable(R.drawable.cerclebackgroundblc));
            im3.setVisibility(View.INVISIBLE);
        }

    }

}