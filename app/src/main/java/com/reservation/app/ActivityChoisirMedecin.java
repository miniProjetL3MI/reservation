package com.reservation.app;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.Context;


import android.widget.TextView;



public class ActivityChoisirMedecin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_medecin);
        // Récupérer le nom du patient depuis les SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String nomPatient = sharedPreferences.getString("nom", "");

        // Trouver le TextView dans la mise en page XML
        TextView welcomeTextView = findViewById(R.id.welcomeTextView);

        // Afficher le message de bienvenue avec le nom du patient
        welcomeTextView.setText("Bienvenue, " + nomPatient + " !");
    }
}
