package com.example.projetihm.Classes;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SudokuExamples extends AsyncTask<String, Integer, String> {
    String url ;
    int v ;
    public SudokuExamples(String s ,int i) {
        url =s ;
        v= i;
    }

    @Override
    public String doInBackground(String... strings) {

        URL yahoo = null;
        try {
            yahoo = new URL(url+v);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            yahoo.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine;

        while (true) {
            try {
                if (!((inputLine = in.readLine()) != null)) System.out.println("merde" + inputLine); break;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
}