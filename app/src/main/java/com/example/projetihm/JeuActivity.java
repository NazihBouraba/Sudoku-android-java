package com.example.projetihm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.projetihm.Classes.Grille;

public class JeuActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    public float x ;
    public float y ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        Grille g= (Grille) findViewById(R.id.grille);
        g.setOnClickListener(this);
        g.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {



        Log.v("POSITION","x= "+x/(594/9) + "y= "+y/(594/9));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return false;
    }
}