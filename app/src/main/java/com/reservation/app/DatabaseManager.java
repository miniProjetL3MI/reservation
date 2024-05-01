package com.reservation.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.reservation.app.Admin;
import com.reservation.app.AssistanteMedicale;
import com.reservation.app.CabinetMedicale;
import com.reservation.app.Medecin;
import com.reservation.app.Patient;
import com.reservation.app.RendezVous;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "RendezVous.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table Medecin(" +
                "idMedecin integer primary key autoincrement," +
                "nom text not null," +
                "prenom text not null," +
                "numTelephone text not null unique," +
                "specialite text not null," +
                "email text not null unique," +
                "heurOuverture text not null," +
                "heurFermeture text not null," +
                "jourTravail text not null" +
                ")";
        db.execSQL(strSql);

        String strSql1 = "create table Assistante(" +
                "idAssistante integer primary key autoincrement," +
                "nom text not null," +
                "prenom text not null," +
                "email text not null unique," +
                "motDePasse text not null unique," +
                "idMedecin integer," +
                "foreign key (idMedecin) references Medecin(idMedecin)" +
                ")";
        db.execSQL(strSql1);

        String strSql2 = "create table Patient(" +
                "idPatient integer primary key autoincrement," +
                "nom text not null," +
                "prenom text not null," +
                "email text not null unique," +
                "motDePasse text not null unique," +
                "dateNaissance text not null" +
                ")";
        db.execSQL(strSql2);

        String strSql3 = "create table Admin(" +
                "idAdmin integer primary key autoincrement," +
                "nom text not null," +
                "prenom text not null," +
                "email text not null unique," +
                "motDePasse text not null unique" +
                ")";
        db.execSQL(strSql3);

        String strSql4 = "create table CabinetMedical(" +
                "idCabinet integer primary key autoincrement," +
                "adresse text not null" +
                ")";
        db.execSQL(strSql4);

        String strSql5 = "create table RendezVous(" +
                "idRendezVous integer primary key autoincrement," +
                "heurRendezVous text not null," +
                "dateRendezVous text not null," +
                "idAssistante integer," +
                "idPatient integer," +
                "foreign key (idAssistante) references Assistante(idAssistante)," +
                "foreign key (idPatient) references Patient(idPatient)" +
                ")";
        db.execSQL(strSql5);

        String strSql6 = "create table Choisir(" +
                "idMedecin integer," +
                "idUtilisateur integer," +
                "foreign key (idMedecin) references Medecin(idMedecin)," +
                "foreign key (idUtilisateur) references Patient(idPatient)," +
                "primary key(idMedecin, idUtilisateur)" +
                ")";
        db.execSQL(strSql6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, and create tables again
        db.execSQL("DROP TABLE IF EXISTS Medecin");
        db.execSQL("DROP TABLE IF EXISTS Assistante");
        db.execSQL("DROP TABLE IF EXISTS Patient");
        db.execSQL("DROP TABLE IF EXISTS Admin");
        db.execSQL("DROP TABLE IF EXISTS CabinetMedical");
        db.execSQL("DROP TABLE IF EXISTS RendezVous");
        db.execSQL("DROP TABLE IF EXISTS Choisir");
        onCreate(db);
    }

    public ArrayList<Medecin> getAllMedecin() {
        ArrayList<Medecin> medecins = new ArrayList<>();

        String strSql = "select * from Medecin";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(strSql, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int idMedecin = cursor.getInt(cursor.getColumnIndex("idMedecin"));
                String nom = cursor.getString(cursor.getColumnIndex("nom"));
                String prenom = cursor.getString(cursor.getColumnIndex("prenom"));
                String numTelephone = cursor.getString(cursor.getColumnIndex("numTelephone"));
                String specialite = cursor.getString(cursor.getColumnIndex("specialite"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String heurOuverture = cursor.getString(cursor.getColumnIndex("heurOuverture"));
                String heurFermeture = cursor.getString(cursor.getColumnIndex("heurFermeture"));
                String jourTravail = cursor.getString(cursor.getColumnIndex("jourTravail"));

                Medecin medecin = new Medecin(idMedecin, nom, prenom, numTelephone, specialite, email, heurOuverture, heurFermeture, jourTravail);
                medecins.add(medecin);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return medecins;
    }

    // Add other methods for Assistante, Patient, Admin, CabinetMedical, and RendezVous as needed
    public ArrayList<AssistanteMedicale> getAllAssistante() {
        ArrayList<AssistanteMedicale> assistantes = new ArrayList<>();

        String strSql1 = "select * from Assistante";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(strSql1, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int idAssistante = cursor.getInt(cursor.getColumnIndex("idAssistante"));
                String nom = cursor.getString(cursor.getColumnIndex("nom"));
                String prenom = cursor.getString(cursor.getColumnIndex("prenom"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String motDePasse = cursor.getString(cursor.getColumnIndex("motDePasse"));
                int idMedecin = cursor.getInt(cursor.getColumnIndex("idMedecin"));

                AssistanteMedicale assistante = new AssistanteMedicale(idAssistante, nom, prenom, email, motDePasse, idMedecin);
                assistantes.add(assistante);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return assistantes;
    }

    public ArrayList<Patient> getAllPatient() {
        ArrayList<Patient> patients = new ArrayList<>();

        String strSql2 = "select * from Patient";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(strSql2, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int idPatient = cursor.getInt(cursor.getColumnIndex("idPatient"));
                String nom = cursor.getString(cursor.getColumnIndex("nom"));
                String prenom = cursor.getString(cursor.getColumnIndex("prenom"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String motDePasse = cursor.getString(cursor.getColumnIndex("motDePasse"));
                String dateNaissance = cursor.getString(cursor.getColumnIndex("dateNaissance"));

                Patient patient = new Patient(idPatient, nom, prenom, email, motDePasse, dateNaissance);
                patients.add(patient);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return patients;
    }

    public ArrayList<Admin> getAllAdmin() {
        ArrayList<Admin> admins = new ArrayList<>();

        String strSql3 = "select * from Admin";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(strSql3, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int idAdmin = cursor.getInt(cursor.getColumnIndex("idAdmin"));
                String nom = cursor.getString(cursor.getColumnIndex("nom"));
                String prenom = cursor.getString(cursor.getColumnIndex("prenom"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String motDePasse = cursor.getString(cursor.getColumnIndex("motDePasse"));

                Admin admin = new Admin(idAdmin, nom, prenom, email, motDePasse);
                admins.add(admin);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return admins;
    }

    public ArrayList<CabinetMedicale> getAllCabinet() {
        ArrayList<CabinetMedicale> cabinets = new ArrayList<>();

        String strSql4 = "select * from CabinetMedical";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(strSql4, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int idCabinet = cursor.getInt(cursor.getColumnIndex("idCabinet"));
                String adresse = cursor.getString(cursor.getColumnIndex("adresse"));

                CabinetMedicale cabinet = new CabinetMedicale(idCabinet, adresse);
                cabinets.add(cabinet);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return cabinets;
    }
    public ArrayList<RendezVous> getAllRendezVous() {
        ArrayList<RendezVous> rendezVousList = new ArrayList<>();

        String strSql5 = "select * from RendezVous";
        Cursor cursor = this.getWritableDatabase().rawQuery(strSql5, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int idRendezVous = cursor.getInt(cursor.getColumnIndex("idRendezVous"));
                String heurRDV = cursor.getString(cursor.getColumnIndex("heurRendezVous"));
                String dateRDV = cursor.getString(cursor.getColumnIndex("dateRendezVous"));

                RendezVous rendezVous = new RendezVous();
                rendezVous.setIdRDV(idRendezVous);
                rendezVous.setHeurRDV(heurRDV);
                rendezVous.setDateRDV(dateRDV);

                rendezVousList.add(rendezVous);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return rendezVousList;
    }


}
