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
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.*;
import com.example.projetihm.Classes.SudokuExamples;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<String> exemples = new ArrayList<String>();
    public static ProgressBar pb ;
    public static int boucle = 0;
    public static TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         pb = (ProgressBar) findViewById(R.id.progressBar2);
        for (int i=0 ; i<= 29 ; i++) {

            new SudokuExamples("https://labsticc.univ-brest.fr/~bounceur/cours/android/tps/sudoku/index.php?v=", i).gets();
        }
       //  tv = (TextView ) findViewById(R.id.textView);
      //   tv.setText("recuperation des jeux d'essaies en cour ...");
        InputStream imageStream = this.getResources().openRawResource(R.raw.sudoku);
        Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        iv.setImageBitmap(bitmap);
        Button jouer = (Button) findViewById(R.id.jouer);
        jouer.setOnClickListener(this);

        Button apropos = (Button) findViewById(R.id.apropos);
        apropos.setOnClickListener(this);
        pb.setVisibility(View.VISIBLE);




    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){

            case  R.id.jouer :
                 i = new Intent(this,JeuActivity.class);
                startActivity(i);
                break;
            case R.id.apropos :
                 i = new Intent(this,AboutActivity.class);
                startActivity(i);
                break;




        }
    }
}