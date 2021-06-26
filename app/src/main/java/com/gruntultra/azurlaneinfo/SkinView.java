package com.gruntultra.azurlaneinfo;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class SkinView extends AppCompatActivity {
    ImageView imgLarge;
    String urlImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_view);
        imgLarge = (ImageView) findViewById(R.id.largeImg);
        Bundle bundle = getIntent().getExtras();
        urlImg = bundle.getString("urlImg");
        System.out.println(urlImg);
        Picasso.get().load(urlImg).into(imgLarge);
    }

}
