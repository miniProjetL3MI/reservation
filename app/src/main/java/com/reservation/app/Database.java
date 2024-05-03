package com.reservation.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 ="create table medecin(idMedecin integer primary key autoincrement,nom text not null ,prenom text not null ,numTelephone text not null unique,specialite text not null ,email text not null unique,heurOuverture text not null ,heurFermeture text not null,jourTravail text not null)";
        sqLiteDatabase.execSQL(qry1);
        String qry2 ="create table assisstante(idUtilisateur integer primary key autoincrement,nom text not null,prenom text not null,email text not null unique,motDePasse text not null unique ,idMedecin integer,foreign key (idMedecin) references medecin(idMedecin))";
        sqLiteDatabase.execSQL(qry2);
        String qry3 = "create table patient(idUtilisateur integer primary key autoincrement,nom text not null ,prenom text not null,email text not null unique,motDePasse text not null unique,datedenaiss text not null)";
        sqLiteDatabase.execSQL(qry3);
        String qry4 = "create table admin(idUtilisateur integer primary key autoincrement,nom text not null ,prenom text not null,email text not null unique ,motDePasse text not null unique)";
        sqLiteDatabase.execSQL(qry4);
        String qry5 = "create table cabinetmedical(idcabinet integer primary key autoincrement,adresse text not null)";
        sqLiteDatabase.execSQL(qry5);
        String qry6 = "create table rendezvous(idrendezvous integer primary key autoincrement,heurrendezvous text not null,daterendezrvous text not null,idAssistante integer,idPatient integer,foreign key (idAssistante) references assistante(idUtilisateur),foreign key (idPatient) references patient(idUtilisateur) )";
        sqLiteDatabase.execSQL(qry6);
        String qry7 = "create table choisir(idMedecin integer,idUtilisateur integer, foreign key (idMedecin) references medecin(idMedecin),foreign key (idUtilisateur) references patient(idUtilisateur),primary key(idMedecin, idUtilisateur))";
        sqLiteDatabase.execSQL(qry7);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void registerassisstante(String nom ,String prenom ,String email ,String motdepasse){
        ContentValues cv =new ContentValues();
        cv.put("nom",nom);
        cv.put("prenom",prenom);
        cv.put("email ",email );
        cv.put("motDePasse",motdepasse);
        SQLiteDatabase db = getWritableDatabase();db.insert("assisstante",null ,cv);
        db.close();
    }
    public void registermedecin(String nom ,String prenom ,String numTelephone ,String specialite ,String email ,String heurOuverture ,String heurFermeture ,String jourTravail){
        ContentValues cv1 =new ContentValues();
        cv1.put("nom",nom);
        cv1.put("prenom",prenom);
        cv1.put("numTelephone",numTelephone);
        cv1.put("specialite",specialite);
        cv1.put("email ",email );
        cv1.put("heurOuverture",heurOuverture);
        cv1.put("heurFermeture",heurFermeture);
        cv1.put("jourTravail",jourTravail);
        SQLiteDatabase db1= getWritableDatabase();
        db1.insert("medecin",null ,cv1);
        db1.close();
    }
    public void registerpatient(String nom ,String prenom ,String email ,String motdepasse ,String datedenaiss){
        ContentValues cv2 =new ContentValues();
        cv2.put("nom",nom);
        cv2.put("prenom",prenom);
        cv2.put("email ",email );
        cv2.put("motDePasse",motdepasse);
        cv2.put("datedenaiss",datedenaiss);
        SQLiteDatabase db2= getWritableDatabase();db2.insert("patient",null ,cv2);
        db2.close();
    }
    public void registeradmin(String nom ,String prenom ,String email ,String motdepasse){
        ContentValues cv3 =new ContentValues();
        cv3.put("nom",nom);
        cv3.put("prenom",prenom);
        cv3.put("email ",email );
        cv3.put("motDePasse",motdepasse);
        SQLiteDatabase db3 = getWritableDatabase();
        db3.insert("admin",null ,cv3);
        db3.close();
    }
    public void registercabinet(String adresse){
        ContentValues cv3 =new ContentValues();
        cv3.put("adresse",adresse);
        SQLiteDatabase db3= getWritableDatabase();db3.insert("cabinetmedical",null ,cv3);
        db3.close();
    }
    public void registerrendezvous(String heurrendezvous ,String daterendezvous){
        ContentValues cv4 =new ContentValues();
        cv4.put("heurrendezvous",heurrendezvous);
        cv4.put("daterendezvous",daterendezvous);
        SQLiteDatabase db4= getWritableDatabase();db4.insert("rendezvous",null ,cv4);
        db4.close();
    }
    public int login(String nom ,String motdepasse){
        int result=0;
        String str[]=new String[2];
        str[0]=nom;
        str[1]=motdepasse;
        SQLiteDatabase db =getWritableDatabase();
        Cursor c= db.rawQuery("select * from patient where nom =? and motDePasse =?",str);
        if(c.moveToFirst()){
            result=1;
        }
        return result;
    }
}
