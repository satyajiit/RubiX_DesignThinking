package com.rubix.org;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagesListAdapter extends RecyclerView.Adapter<ImagesListAdapter.ViewHolder> {
    private ArrayList<GalleryImages> gal_items;
    private Context context;
    ImagePopup imagePopup;
View v;
Animation rtr;
    public ImagesListAdapter(Context context,ArrayList<GalleryImages> android_versions) {
        this.context = context;
        this.gal_items = android_versions;

    }

    @Override
    public ImagesListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_pics_gallery, viewGroup, false);


v=view;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

       imagePopup = new ImagePopup(v.getContext());

        final int x=i;
        rtr = AnimationUtils.loadAnimation(v.getContext(),
                R.anim.anim_translate_in);

        viewHolder.img_android.startAnimation(rtr);
        Picasso.get().load(gal_items.get(i).getGal_image_url()).resize(290,230).into(viewHolder.img_android);


        viewHolder.img_android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub


                Drawable drawable = v.getResources().getDrawable(gal_items.get(x).getGal_image_url());




                imagePopup.setImageOnClickClose(true);

                imagePopup.setWindowHeight(1100); // Optional
                imagePopup.setWindowWidth(1000);

                imagePopup.initiatePopup(drawable);



               imagePopup.viewPopup();

            }
        });







    }

    @Override
    public int getItemCount() {
        return gal_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_android;
        public ViewHolder(View view) {
            super(view);


            img_android = view.findViewById(R.id.img_android);
        }
    }
}