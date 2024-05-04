package com.reservation.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilPatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_specialites);

        // Récupération du nom et du prénom depuis les SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String nom = sharedPreferences.getString("nom", "");
        String prenom = sharedPreferences.getString("prenom", "");



        Log.d("ProfilPatientActivity", "Nom: " + nom + ", Prenom: " + prenom);


        // Affichage du nom et du prénom dans le TextView correspondant
        TextView textViewNomPrenom = findViewById(R.id.textView4);
        textViewNomPrenom.setText(nom + " " + prenom);
    }
}
