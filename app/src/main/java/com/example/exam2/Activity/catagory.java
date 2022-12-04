package com.example.exam2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exam2.Adapter.catagory_adapter;
import com.example.exam2.R;
import com.example.exam2.config;

import java.io.File;

public class catagory extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catagory_layout);

        ActivityCompat.requestPermissions(catagory.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);

        listView = findViewById(R.id.list);

        catagory_adapter catagory_adapter = new catagory_adapter(this);
        listView.setAdapter(catagory_adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(catagory.this,catagory_ditel.class);
                intent.putExtra("pos",position);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {


                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    config.file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)+"/exam2");
                    if(config.file.exists())
                    {
                        System.out.println("folder is avilable");
                    }
                    else
                    {
                        System.out.println("folder is not avilable");
                        if(config.file.mkdir())
                        {
                            System.out.println("create folder");
                        }
                        else{
                            System.out.println("not create folder");
                        }
                    }
                } else {
                    ActivityCompat.requestPermissions(catagory.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            1);
                    Toast.makeText(catagory.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}