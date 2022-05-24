package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class editproduit extends AppCompatActivity {
    Spinner sp;
    MyDBProduit db;
    EditText ed1,ed2,ed3,ed4,ed5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editproduit);
        db=new MyDBProduit(this);
        ArrayList<produit> prd=MyDBProduit.getall(db.getReadableDatabase());
        ArrayList<String> prds =new ArrayList<>();
        for(produit pa : prd){
            prds.add(pa.getId()+"-"+ pa.getLibelle());

        }
        ArrayAdapter d =new ArrayAdapter(this,R.layout.activity_editproduit,prd);
        sp.setAdapter(d);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        ed4=findViewById(R.id.ed4);
        ed5=findViewById(R.id.ed5);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void valider(View view) {
        produit p=new produit();
        p.setId(Integer.parseInt(ed5.getText().toString()));
        p.setLibelle(ed1.getText().toString());
        p.setFamille(ed2.getText().toString());
        p.setPrixAchat(Double.parseDouble(ed3.getText().toString()) );
        p.setPrixVente(Double.parseDouble(ed4.getText().toString()));
        MyDBProduit.update_produit(db.getWritableDatabase(),p);


    }
}