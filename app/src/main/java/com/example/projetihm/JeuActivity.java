package com.example.projetihm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.projetihm.Classes.Grille;

public class JeuActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private Intent i ;
    public Grille g ;
    public float x ;
    public float y ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        g= (Grille) findViewById(R.id.grille);
        g.setOnClickListener(this);
        g.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
         i = new Intent(this,ChoixActivity.class);

        int index_x = (int) x/(Grille.taille_ecran/9) ;
        int index_y = (int) y/(Grille.taille_ecran/9) ;
        i.putExtra("x",index_x);
        i.putExtra("y",index_y);
        Log.v("POSITION","x= "+index_x+ "y= "+index_y);
        startActivity(i);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return false;
    }
}