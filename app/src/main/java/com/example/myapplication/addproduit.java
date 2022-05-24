package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addproduit extends AppCompatActivity {
    MyDBProduit db;
    EditText ed1,ed2,ed3,ed4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduit);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        ed4=findViewById(R.id.ed4);
    }

    public void valider(View view) {
        db=new MyDBProduit(this);
        produit p =new produit();
        p.setLibelle(ed1.getText().toString());
        p.setFamille(ed2.getText().toString());
        p.setPrixAchat(Double.parseDouble(ed3.getText().toString())  );
        p.setPrixAchat(Double.parseDouble(ed4.getText().toString()));
       if( MyDBProduit.insert_produit(db.getWritableDatabase(),p)==-1){
           Toast.makeText(this, "insertion echoue", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(this, "insertion réussie", Toast.LENGTH_SHORT).show();

       }


    }


}