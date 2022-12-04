package com.example.exam2.Adapter;

import static com.example.exam2.config.catagory_name;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.exam2.Activity.catagory;
import com.example.exam2.R;
import com.example.exam2.config;

public class catagory_adapter extends BaseAdapter {
    catagory catagory;
    public catagory_adapter(catagory catagory) {
        this.catagory=catagory;
    }

    @Override
    public int getCount() {
        return catagory_name.length;
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

        convertView = LayoutInflater.from(catagory).inflate(R.layout.catagory_item,parent,false);

        TextView textView = convertView.findViewById(R.id.catagory_text);
        textView.setText(catagory_name[position]);

        return convertView;
    }
}
