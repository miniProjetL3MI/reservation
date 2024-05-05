package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ModifierProfilPatientActivity extends AppCompatActivity {

    TextView nomPatient, prenomPatient, dateNai, NumTel;
    Button buttonModifierProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_profil_patient);
        nomPatient = findViewById(R.id.editTextTextprofileName);
        prenomPatient = findViewById(R.id.editTextTextprofilePrenom);
        dateNai = findViewById(R.id.editTextTextprofileEmail);
        NumTel = findViewById(R.id.editTextTextprofiletelephone);
        buttonModifierProfil = findViewById(R.id.editButton);

        // Récupérer l'email du patient depuis les SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        final String userEmail = sharedPreferences.getString("email", "");

        // Remplir les champs avec les informations actuelles du patient
        nomPatient.setText(sharedPreferences.getString("nom", ""));
        prenomPatient.setText(sharedPreferences.getString("prenom", ""));
        dateNai.setText(sharedPreferences.getString("datedenaiss", ""));
        NumTel.setText(sharedPreferences.getString("numTel", ""));

        buttonModifierProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = nomPatient.getText().toString();
                String userPrenom = prenomPatient.getText().toString();
                String userNaissance = dateNai.getText().toString();
                String userTel = NumTel.getText().toString();

                if (userName.isEmpty() || userPrenom.isEmpty() || userNaissance.isEmpty()) {
                    // Les champs sont vides, ne rien faire
                    Intent intent = new Intent(ModifierProfilPatientActivity.this, ProfilPatientActivity.class);
                    startActivity(intent);
                    return;

                }




                // Mettre à jour les valeurs dans SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nom", userName);
                editor.putString("prenom", userPrenom);
                editor.putString("datedenaiss", userNaissance);
                editor.putString("numTel", userTel);
                editor.apply();

                // Mettre à jour les valeurs dans la base de données
                Database db = new Database(getApplicationContext(), "miniprojet", null, 1);
                db.updatePatient(userEmail, userName, userPrenom, userNaissance, userTel);

                // Afficher un message de succès ou rediriger l'utilisateur
                Toast.makeText(ModifierProfilPatientActivity.this, "Profil mis à jour avec succès", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ModifierProfilPatientActivity.this, ProfilPatientActivity.class);
                startActivity(intent);
            }
        });

    }
}

