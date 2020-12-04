package com.example.projetihm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.*;
import com.example.projetihm.Classes.SudokuExamples;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<String> exemples = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream imageStream = this.getResources().openRawResource(R.raw.sudoku);
        Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        iv.setImageBitmap(bitmap);

        Button jouer = (Button) findViewById(R.id.jouer);
        jouer.setOnClickListener(this);

        Button apropos = (Button) findViewById(R.id.apropos);
        apropos.setOnClickListener(this);

       for (int i=0 ; i<= 29 ; i++) {
           new SudokuExamples("https://labsticc.univ-brest.fr/~bounceur/cours/android/tps/sudoku/index.php?v=", i).gets();
       }
        Log.i("TAGSSS", exemples.toString());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case  R.id.jouer :
                Intent i = new Intent(this,JeuActivity.class);
                startActivity(i);
                break;




        }
    }
}