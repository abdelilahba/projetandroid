package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Intent n =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void acces(View view) {
        switch (view.getId()){
            case R.id.btn1:n=new Intent(MainActivity.this,addproduit.class);break;
            case R.id.btn4:n=new Intent(MainActivity.this,editproduit.class);break;
        }
        startActivity(n);

    }
}