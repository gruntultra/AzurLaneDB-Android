package com.gruntultra.azurlaneinfo;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class downloadImg {
    private Context context;
    private static final String File_Name = "ships.json";

    public downloadImg(Context context) {
        this.context = context;
    }

    protected void loadImage() {
        String data = loadData();
        Gson gson = new Gson();
        final Ship[] ships = gson.fromJson(data, Ship[].class);
        ContextWrapper cw = new ContextWrapper(context);
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        if (directory .isDirectory()) {
            String[] children = directory .list();
            for (int i = 0; i < children.length; i++) {
                new File(directory , children[i]).delete();
            }
        }
        for(int i = 0; i < ships.length; i ++) {
            String imgUrl = ships[i].getThumbnail();
            Picasso.get().load(imgUrl).into(picassoImageTarget(context, "imageDir", ships[i].getNames().getEn() + ".png"));
        }
        System.out.println("wtf");
    }

    private Target picassoImageTarget(Context context, final String imageDir, final String imageName) {
        ContextWrapper cw = new ContextWrapper(context);
        final File directory = cw.getDir(imageDir, Context.MODE_PRIVATE);
        return new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final File myImageFile = new File(directory, imageName); // Create image file
                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(myImageFile);
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } /*finally {
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }*/
                    }
                }).start();
            }
            @Override
            public void onBitmapFailed(Exception ex , Drawable errorDrawable) {
            }
            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                if (placeHolderDrawable != null) {}
            }
        };
    }

    public String loadData() {
        String data = "";
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(File_Name);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            data = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
