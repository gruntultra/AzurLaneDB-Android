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


public class SkillAdapter extends ArrayAdapter {
    private static final String TAG = "SkillAdapter";
    private Context mContext;
    private ArrayList<Skills> mskill;
    private int mResource;

    public SkillAdapter(@NonNull Context context, int resource, ArrayList<Skills> skill) {
        super(context, resource, skill);
        mContext = context;
        mskill = skill;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getNames().getEn();
        String desc = getItem(position).getDescription();
        String imageUrl = getItem(position).getIcon();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);


        ImageView im1 = (ImageView) convertView.findViewById(R.id.skillView);
        TextView tv1 = (TextView) convertView.findViewById(R.id.skillnameView);
        TextView tv2 = (TextView) convertView.findViewById(R.id.descripView);
        tv2.setMovementMethod(new ScrollingMovementMethod());

        tv1.setText(name);
        tv2.setText(desc);
        Picasso.get().load(imageUrl).into(im1);
        return convertView;
    }

    @Nullable
    @Override
    public Skills getItem(int position) {
        return mskill.get(position);
    }

}
