package com.example.bastianvidal.gridviewapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Integer> arrayImg = new ArrayList<Integer>();
    int[] array;


    public ImageAdapter(Context c) {
        mContext = c;
        definirImagenes();
    }

    public int getCount() {
        return  array.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(array[position]);
        return imageView;
    }

    // references to our images
    public void definirImagenes() {
        ArrayList<String> imagenes = new ArrayList<String>();

        HelperBD helperBD = new HelperBD(mContext);
        SQLiteDatabase db = helperBD.getReadableDatabase();
        Cursor c;
        c = db.rawQuery("select * from productos", null);

        c.moveToFirst();

        do {
            imagenes.add(c.getString(4));

        } while (c.moveToNext());

        for(int i=0; i<imagenes.size();i++){
            if(imagenes.get(i).equals("acer_aspire_vx15")){
                arrayImg.add(R.drawable.acer_aspire_vx15);
            }

            if(imagenes.get(i).equals("acer_nitro_5")){
                arrayImg.add(R.drawable.acer_nitro_5);
            }
        }

        array = new int[arrayImg.size()];
            for (int i = 0 ; i<array.length;i++){
                array[i] = arrayImg.get(i);
            }
            c.close();
    }


    private Integer[] mThumbIds = {

    };
}
