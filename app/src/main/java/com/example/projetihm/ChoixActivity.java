package com.example.projetihm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projetihm.Classes.NumberAdapter;

public class ChoixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        RecyclerView rv =(RecyclerView) findViewById(R.id.recyclerview);
        NumberAdapter na = new NumberAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(na);
    }
}