package com.gruntultra.azurlaneinfo;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SkinAdapter extends ArrayAdapter {
    private static final String TAG = "SkillAdapter";
    private Context mContext;
    private ArrayList<Skins> mSkin;
    private int mResource;

    public SkinAdapter(@NonNull Context context, int resource, ArrayList<Skins> skin) {
        super(context, resource, skin);
        mContext = context;
        mSkin = skin;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String imageUrl = getItem(position).getImage();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tv1 = (TextView) convertView.findViewById(R.id.skinName);
        ImageView im1 = (ImageView) convertView.findViewById(R.id.skinView);
        tv1.setText(name);
        Picasso.get().load(imageUrl).into(im1);
        return convertView;
    }

    @Nullable
    @Override
    public Skins getItem(int position) {
        return mSkin.get(position);
    }
}
