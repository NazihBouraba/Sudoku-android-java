package com.example.projetihm.Classes;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetihm.MainActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SudokuExamples  {
    String url ;

    int v ;
    public SudokuExamples(String s ,int i) {
        url =s ;
        v= i;
    }

    public String gets()
    {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {

                    Document doc = Jsoup.connect(url+v).get();
                    Element s =  doc.select("body").first();
                    MainActivity.exemples.add( s.text());
                    System.out.println("le contenu est " + s.text());

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });

        thread.start();
        return null ;
    }




}