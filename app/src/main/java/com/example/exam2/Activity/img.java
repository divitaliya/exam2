package com.example.exam2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.exam2.R;
import com.example.exam2.config;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class img extends AppCompatActivity {
    int pos;
    int[] img;
    ImageView imageView,next,prev,share,down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

            imageView = findViewById(R.id.view_img);
            next = findViewById(R.id.next);
            share = findViewById(R.id.share);
            prev = findViewById(R.id.prev);
            down = findViewById(R.id.download);

            pos = getIntent().getIntExtra("pos",0);
            img = getIntent().getIntArrayExtra("img");

            imageView.setImageResource(img[pos]);

            down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bitmap icon = getBitmapFromView(imageView);
                    System.out.println("bitmap==" + icon);
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                    int randam = new Random().nextInt(2000);
                    File f = new File(config.file.getAbsolutePath() + "/exam2" + "img_file" + randam + ".jpg");
                    try {
                        f.createNewFile();
                        FileOutputStream fo = new FileOutputStream(f);
                        fo.write(bytes.toByteArray());
                        Toast.makeText(img.this, "img down", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(pos>0) {
                        pos--;
                        imageView.setImageResource(img[pos]);
                    }
                }
            });
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(pos< config.art_img.length-1) {
                        pos++;
                        imageView.setImageResource(img[pos]);
                    }
                }
            });
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bitmap icon = getBitmapFromView(imageView);
                    System.out.println("bitmap=="+icon);
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("image/jpeg");
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                    int randam = new Random().nextInt(2000);
                    File f = new File(config.file.getAbsolutePath()+"/ipl"+"img_file"+randam+".jpg");
                    try {
                        f.createNewFile();
                        FileOutputStream fo = new FileOutputStream(f);
                        fo.write(bytes.toByteArray());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    share.putExtra(Intent.EXTRA_STREAM, Uri.parse(f.getAbsolutePath()));
                    startActivity(Intent.createChooser(share, "Share Image"));
                }
            });

        }
    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }

    }
