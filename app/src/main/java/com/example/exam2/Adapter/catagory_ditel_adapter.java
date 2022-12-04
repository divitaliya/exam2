package com.example.exam2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.exam2.Activity.catagory_ditel;
import com.example.exam2.R;

public class catagory_ditel_adapter extends BaseAdapter {

    catagory_ditel catagory_ditel;
    int[] img;
    public catagory_ditel_adapter(catagory_ditel catagory_ditel, int[] img) {
        this.catagory_ditel=catagory_ditel;
        this.img=img;
    }
    @Override
    public int getCount() {
        return img.length;
    }
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(catagory_ditel).inflate(R.layout.catagory_ditel_item,parent,false);

        ImageView imageView= convertView.findViewById(R.id.grid_image);
        imageView.setImageResource(img[position]);

        return convertView;
    }
}
