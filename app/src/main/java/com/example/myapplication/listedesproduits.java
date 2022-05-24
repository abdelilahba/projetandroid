package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listedesproduits extends AppCompatActivity {
    ListView lst;
    MyDBProduit db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listedesproduits);
        db=new MyDBProduit(this);
         ArrayList<produit> ps= MyDBProduit.getall(db.getReadableDatabase());
         ArrayList<String> s=new ArrayList<>();
         for(produit p : ps){
             s.add(p.getId()+"  "+ p.getLibelle());
         }
         ArrayAdapter d =new ArrayAdapter(this,R.layout.activity_listedesproduits,s);
         lst.setAdapter(d);


    }
}