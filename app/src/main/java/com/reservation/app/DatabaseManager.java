package com.reservation.app;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.reservation.app.Medecin;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="RendezVous.db";
    private static final int DATABASE_VERSION= 1;

    public DatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table Medecin(" +
                "idMedecin integer primary key autoincrement,"
                +"nom text not null,"
                +"prenom text not null,"
                +"numTelephone text not null unique,"
                +"specialite text not null,"
                +"email text not null unique,"
                +"heurOuverture text not null ,"
                +"heurFermeture text not null,"
                +"jourTravail text not null"
                +")";
        db.execSQL(strSql);
        String strSql1="create table Assisstante("+
                "idAssisstante integer primary key autoincrement,"
                +"nom text not null,"
                +"prenom text not null,"
                +"email text not null unique,"
                +"motDePasse text not null unique,"
                +"idMedecin integer,"
                +"foreign key (idMedecin) references medecin (idMedecin)"
                +")";
        db.execSQL(strSql1);
        String strSql2="create table Patient("+
                "idPatient integer primary key autoincrement,"
                +"nom text not null,"
                +"prenom text not null,"
                +"email text not null unique,"
                +"motDePasse text not null unique,"
                +"dateNaissance text not null"
                +")";
        db.execSQL(strSql2);
        String strSql3="create table Admin("+
                "idAdmin integer primary key autoincrement,"
                +"nom text not null,"
                +"prenom text not null,"
                +"email text not null unique,"
                +"motDePasse text not null unique"
                +")";
        db.execSQL(strSql3);
        String strSql4="create table CabinetMedical("+
                "idCabinet integer primary key autoincrement,"
                +"adresse text not null"
                +")";
        db.execSQL(strSql4);
        String strSql5="create table RendezVous("+
                "idRendezVous integer primary key autoincrement,"
                +"heurRendezVous text not null,"
                +"dateRendezVous text not null,"
                +"idAssisstante integer, "
                +"idPatient integer,"
                +"foreign key (idAssisstante) references Assisstante(idUtilisateur),"
                +"foreign key (idPatient) references Patient(idUtilisateur)"
                +")";
        db.execSQL(strSql5);
        String strSql6="create table Choisir("+
                "idMedecin integer ,"
                +"idUtilisateur integer ,"
                +"foreign key (idMedecin) references Medecin(idMedecin),"
                +"foreign key (idUtilisateur) references Patient(idUtilisateur),"
                +"primary key(idMedecin, idUtilisateur)"
                +")";

        db.execSQL(strSql6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public ArrayList<Medecin> getAllMedecin(){
        ArrayList<Medecin> med=new ArrayList<Medecin>();
        String strSql="select * from Medecin";
        Cursor cursor=this.getWritableDatabase().rawQuery(strSql, null);
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                int idMedecin = cursor.getInt(cursor.getColumnIndex("idMedecin"));
                String nomMedecin= cursor.getString(cursor.getColumnIndex("nom"));
                String prenomMedecin=cursor.getString(cursor.getColumnIndex("prenom"));
                String numTel= cursor.getString(cursor.getColumnIndex("numTelephone"));
                String specialiteM= cursor.getString(cursor.getColumnIndex("specialite"));
                String emailMedecin= cursor.getString(cursor.getColumnIndex("email"));
                String heurOuvertureM= cursor.getString(cursor.getColumnIndex("heurOuverture"));
                String heurFermetureM= cursor.getString(cursor.getColumnIndex("heurFermeture"));
                String jourTravailM= cursor.getString(cursor.getColumnIndex("jourTravail"));

                Medecin medecinObj=new Medecin();
                medecinObj.setIdMedecin(idMedecin);
                medecinObj.setNomMedecin(nomMedecin);
                medecinObj.setPrenomMedecin((prenomMedecin));
                medecinObj.setNumTel(numTel);
                medecinObj.setSpecialite(specialiteM);
                medecinObj.setEmailMedecin(emailMedecin);
                medecinObj.setHeurOuverture(heurOuvertureM);
                medecinObj.setHeurFermeture(heurFermetureM);
                medecinObj.setJourTravail(jourTravailM);

                med.add(medecinObj);
                cursor.moveToNext();



            }
        }
        return med;
    }
}
