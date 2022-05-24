package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBProduit extends SQLiteOpenHelper {
    public static String DB_NAME="DBProduit.db";
    public static String TABLE_NAME="PRODUIT";
    public static String COL1="ID";
    public static String COL2="LIBELLE";
    public static String COL3="FAMILLE";
    public static String COL4="PRIXACHAT";
    public static String COL5="PRIXVENTE";



    public MyDBProduit(Context c){
        super(c,DB_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + "("+COL1+" integer primary key autoincrement,"+COL2+" TEXT,"+COL3+" TEXT,"+COL4+" double,"+COL5+" double)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public static long insert_produit(SQLiteDatabase sqLiteDatabase ,produit p){
        ContentValues cn= new ContentValues();
        cn.put(COL2,p.getLibelle());
        cn.put(COL3,p.getFamille());
        cn.put(COL4,p.getPrixAchat());
        cn.put(COL5,p.getPrixVente());
        return sqLiteDatabase.insert(TABLE_NAME,null,cn) ;

    }
    public static long update_produit(SQLiteDatabase sqLiteDatabase ,produit p){
        ContentValues cn= new ContentValues();
        cn.put(COL2,p.getLibelle());
        cn.put(COL3,p.getFamille());
        cn.put(COL4,p.getPrixAchat());
        cn.put(COL5,p.getPrixVente());
        long l=sqLiteDatabase.update(TABLE_NAME,cn,"id="+p.getId(),null);
        sqLiteDatabase.close();
        return l;
    }
    public static long delete_produit(SQLiteDatabase sqLiteDatabase ,produit p){
        long result = sqLiteDatabase.delete(TABLE_NAME,"id = "+p.getId(),null);
        sqLiteDatabase.close();


        return result;
    }
    public  static ArrayList<produit> getall(SQLiteDatabase sqLiteDatabase){
        ArrayList<produit> pts =new ArrayList<>();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        while (cursor.moveToNext()){
            produit p =new produit();
            p.setId(cursor.getInt(0));
            p.setLibelle(cursor.getString(1));
            p.setFamille(cursor.getString(2));
            p.setPrixAchat(cursor.getDouble(3));
            p.setPrixVente(cursor.getDouble(4));
            pts.add(p);

        }
        return pts;
    }
    public  static produit getallbyid(SQLiteDatabase sqLiteDatabase,int id){
        produit p=null;
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+"where id="+id,null );
       if (cursor.moveToNext()){
             p =new produit();
            p.setId(cursor.getInt(0));
            p.setLibelle(cursor.getString(1));
            p.setFamille(cursor.getString(2));
            p.setPrixAchat(cursor.getDouble(3));
            p.setPrixVente(cursor.getDouble(4));



        }
        return p;

    }

}
