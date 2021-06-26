package com.gruntultra.azurlaneinfo;


import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class ShipAdapter extends ArrayAdapter {
    private static final String TAG = "ShipAdapter";
    private Context mContext;
    private ArrayList<Ship> mShips;
    private int mResource;
    private int counter = 0;

    public ShipAdapter(@NonNull Context context, int resource, ArrayList<Ship> ships) {
        super(context, resource, ships);
        mContext = context;
        mShips = ships;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         String name = getItem(position).getNames().getEn();
         String desc = getItem(position).getHullType();
         String imageUrl = getItem(position).getThumbnail();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);


        ImageView im1 = (ImageView) convertView.findViewById(R.id.imageView);
        TextView tv1 = (TextView) convertView.findViewById(R.id.nameView);
        TextView tv2 = (TextView) convertView.findViewById(R.id.descView);

        tv1.setText(name);
        tv2.setText(desc);

        ContextWrapper cw = new ContextWrapper(getContext());
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        File myImageFile = new File(directory, name + ".png");
        Picasso.get().load(myImageFile).into(im1);

        //Picasso.get().load(imageUrl).into(im1);


        return convertView;
    }


    @Nullable
    @Override
    public Ship getItem(int position) {
        return mShips.get(position);
    }
}
