package com.example.projetihm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.projetihm.Classes.Grille;
import com.example.projetihm.Classes.Sauvgarde;

import java.util.Arrays;

public class JeuActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private Intent i ;
    public Grille g ;
    public int x ;
    public int y ;
    public float xx ;
    public float yy ;
    private TextView challane_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        g= (Grille) findViewById(R.id.grille);
        g.setOnClickListener(this);
        g.setOnTouchListener(this);
        Button left_b = (Button) findViewById(R.id.leftb);
        Button right_b = (Button) findViewById(R.id.rightb);
        left_b.setOnClickListener(this);
        right_b.setOnClickListener(this);
        challane_num = (TextView) findViewById(R.id.challange_tv);
        Sauvgarde ss= new Sauvgarde();
        int index = ss.recuperer_last_index(this);
        challane_num.setText(""+index);
         changer_challange(index);

    }

    @Override
    protected void onStop() {
        Sauvgarde sauv = new Sauvgarde(g.matrix,g.fixIdx);
        sauv.sauvgarder( Integer.parseInt(challane_num.getText().toString()),this);
        sauv.sauvgarder_last_index(Integer.parseInt(challane_num.getText().toString()),this);
        super.onStop();
    }

    @Override
    protected void onPause() {
        Sauvgarde sauv = new Sauvgarde(g.matrix,g.fixIdx);
        sauv.sauvgarder( Integer.parseInt(challane_num.getText().toString()),this);
        sauv.sauvgarder_last_index(Integer.parseInt(challane_num.getText().toString()),this);
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int challenge ;
        switch (v.getId()){

            case R.id.grille :
               i = new Intent(this,ChoixActivity.class);
               x = (int) xx/(Grille.taille_ecran/9) ;
               y = (int) yy/(Grille.taille_ecran/9) ;
               i.putExtra("x",x);
               i.putExtra("y",y);
                //Log.v("POSITION","x= "+x+ "y= "+y);
                     if((x<9) && (y<9) && !g.fixIdx[y][x])
                         AgeDialog();
                  //  startActivity(i);
                break;
            case R.id.leftb :
                 challenge  = Integer.parseInt(challane_num.getText().toString());
                if(challenge>0){
                    challenge--;
                    changer_challange(challenge);
                }

                break;

            case R.id.rightb :
                 challenge  = Integer.parseInt(challane_num.getText().toString());
                if(challenge<29){
                    challenge++;
                    changer_challange(challenge);

                }
                break;

        }
    }


    public void changer_challange(int i){
        Sauvgarde ss= new Sauvgarde();
       //int index = ss.recuperer_last_index(this);
        challane_num.setText(""+i);
        Sauvgarde last = ss.recuperer(i,this);
        if(last == null){
            challane_num.setText(""+i);
            g.set(MainActivity.exemples.get(i));
            g.dessiner();
        }
        else {
            g.matrix = last.matrix;
            g.fixIdx = last.fix;
            g.dessiner();
        }



    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        xx = event.getX();
        yy = event.getY();

        return false;
    }

    public void AgeDialog(){

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(false);
        LinearLayout l1 = new LinearLayout(getApplicationContext());
        l1.setOrientation(LinearLayout.HORIZONTAL);
        final NumberPicker number =new NumberPicker((this));
        number.setMaxValue(9);
        number.setMinValue(0);
        number.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        number.setWrapSelectorWheel(true);
        l1.addView(number);
        l1.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);
        alert.setView(l1);
        alert.setPositiveButton("CHOISIR", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

                g.matrix[y][x] = number.getValue();
                Log.v("VALEUR","x= "+number.getValue());
                Log.v("position","x= "+x + "y= "+y);
                if(g.c != null ){g.dessiner();}
            }
        });

        alert.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });

        alert.show();
    }

}