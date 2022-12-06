package com.example.exam2.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.exam2.Adapter.catagory_ditel_adapter;
import com.example.exam2.R;
import com.example.exam2.config;

public class catagory_ditel extends AppCompatActivity {

    GridView gridView;
    int pos;
    int[] img;
    String[] name;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catagory_ditel_layout);

        gridView = findViewById(R.id.grid);

        pos = getIntent().getIntExtra("pos",0);
        actionBar = getSupportActionBar();
        actionBar.setTitle(config.catagory_name[pos]);

        if(pos==0)
        {
            img = config.art_img;
            name = config.art_name;
        }
        if(pos==1)
        {
            img = config.citycapes_img;
            name = config.citycapes_name;
        }if(pos==2)
        {
            img = config.earth_img;
            name = config.earth_name;
        }if(pos==3)
        {
            img = config.lanscape_img;
            name = config.lanscape_name;
        }if(pos==4)
        {
            img = config.life_img;
            name = config.life_name;
        }if(pos==5)
        {
            img = config.seascape_img;
            name = config.seascape_name;
        }

        catagory_ditel_adapter catagory_ditel_adapter = new catagory_ditel_adapter(this,img);
        gridView.setAdapter(catagory_ditel_adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(catagory_ditel.this,img.class);
                intent.putExtra("pos",position);
                intent.putExtra("img",img);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });


    }
}