package com.example.projetihm.Classes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.projetihm.MainActivity;
import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

public class Sauvgarde {
   public int matrix[][];
   public boolean fix[][];


    public Sauvgarde(int[][] matrix, boolean[][] fix) {
        this.matrix = matrix;
        this.fix = fix;

    }

    public Sauvgarde() {

    }

    public  void sauvgarder(int i , Activity c){
        SharedPreferences mPrefs = c.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(this);
        prefsEditor.putString(""+i, json);
        prefsEditor.commit();

    }
    public  Sauvgarde recuperer(int i ,Activity c ){
        SharedPreferences mPrefs = c.getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString(""+i, "");
        if(json==""){return null;}
        Sauvgarde obj = gson.fromJson(json, Sauvgarde.class);
        return  obj;
    }

    public void sauvgarder_last_index(int i , Activity c){
        SharedPreferences mPrefs = c.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putInt("index", i);
        prefsEditor.commit();
    }

    public int recuperer_last_index(Activity c ){
        SharedPreferences mPrefs = c.getPreferences(MODE_PRIVATE);
        int  index = mPrefs.getInt("index",0);
        return  index ;

    }
}
