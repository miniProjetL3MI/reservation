package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class FormulaireMedcinActivity extends AppCompatActivity {
    EditText edNom,edPrenom,edNumTel,edAdresse,edSpecialite,edHeureOuverture,edHeureFermeture,edJourTravail;
    ImageView btnSignUp,btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_medecin);
        edNom = findViewById(R.id.editTextTextNom);
        edPrenom = findViewById(R.id.editTextTextPrenom);
        edNumTel = findViewById(R.id.editTextTextNumTel);
        edAdresse = findViewById(R.id.editTextTextAdresse);
        edSpecialite = findViewById(R.id.editTextTextSpecialite);
        edHeureOuverture = findViewById(R.id.editTextTextHeureOuverture);
        edHeureFermeture = findViewById(R.id.editTextTextHeureFermeture);
        edJourTravail = findViewById(R.id.editTextTextJourTravail);
        btnSignUp=findViewById(R.id.imageView6);
        btnReturn =findViewById(R.id.imageView13);

        edNom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ne rien faire avant le changement de texte
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne rien faire pendant le changement de texte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Vérifier si le texte est vide
                if (s.toString().trim().isEmpty()) {
                    // Si le texte est vide, afficher le hint avec la couleur grise
                    edNom.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edNom.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edPrenom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ne rien faire avant le changement de texte
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne rien faire pendant le changement de texte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Vérifier si le texte est vide
                if (s.toString().trim().isEmpty()) {
                    // Si le texte est vide, afficher le hint avec la couleur grise
                    edPrenom.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edPrenom.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edNumTel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ne rien faire avant le changement de texte
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne rien faire pendant le changement de texte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Vérifier si le texte est vide
                if (s.toString().trim().isEmpty()) {
                    // Si le texte est vide, afficher le hint avec la couleur grise
                    edNumTel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edNumTel.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edAdresse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ne rien faire avant le changement de texte
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne rien faire pendant le changement de texte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Vérifier si le texte est vide
                if (s.toString().trim().isEmpty()) {
                    // Si le texte est vide, afficher le hint avec la couleur grise
                    edAdresse.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edAdresse.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edSpecialite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ne rien faire avant le changement de texte
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne rien faire pendant le changement de texte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Vérifier si le texte est vide
                if (s.toString().trim().isEmpty()) {
                    // Si le texte est vide, afficher le hint avec la couleur grise
                    edSpecialite.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edSpecialite.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edHeureOuverture.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ne rien faire avant le changement de texte
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne rien faire pendant le changement de texte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Vérifier si le texte est vide
                if (s.toString().trim().isEmpty()) {
                    // Si le texte est vide, afficher le hint avec la couleur grise
                    edHeureOuverture.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edHeureOuverture.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edHeureFermeture.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ne rien faire avant le changement de texte
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne rien faire pendant le changement de texte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Vérifier si le texte est vide
                if (s.toString().trim().isEmpty()) {
                    // Si le texte est vide, afficher le hint avec la couleur grise
                    edHeureFermeture.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edHeureFermeture.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edJourTravail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ne rien faire avant le changement de texte
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne rien faire pendant le changement de texte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Vérifier si le texte est vide
                if (s.toString().trim().isEmpty()) {
                    // Si le texte est vide, afficher le hint avec la couleur grise
                    edJourTravail.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edJourTravail.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=edNom.getText().toString();
                String userPrenom=edPrenom.getText().toString();
                String userNumTel=edNumTel.getText().toString();
                String userAdresse=edAdresse.getText().toString();
                String userSpecialite=edSpecialite.getText().toString();
                String userHeureOuverture=edHeureOuverture.getText().toString();
                String userHeureFermeture=edHeureFermeture.getText().toString();
                String userJourTravail=edJourTravail.getText().toString();
                Database db = new Database(getApplicationContext(),"miniprojet",null,1);



                if(userName.length() == 0|| userPrenom.length() == 0 || userNumTel.length() == 0 || userAdresse.length() == 0 || userSpecialite.length() == 0 || userHeureOuverture.length() == 0 || userHeureFermeture.length() == 0 || userJourTravail.length() == 0){
                    Toast.makeText(getApplicationContext(), "Remplissez les champs s'il vous plait", Toast.LENGTH_SHORT).show();
                }else {
                    if (SignupPatientActivity.Utils.isValidTel(userNumTel) ){

                        db.registermedecin(userName, userPrenom, userNumTel, userAdresse , userSpecialite , userHeureOuverture , userHeureFermeture , userJourTravail);
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefsss", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("nom", userName);
                        editor.putString("prenom", userPrenom);
                        editor.putString("numTel", userNumTel);
                        editor.putString("adresse", userAdresse);
                        editor.putString("specialite", userSpecialite);
                        editor.putString("heurOuverture", userHeureOuverture);
                        editor.putString("heurFermeture", userHeureFermeture);
                        editor.putString("jourTravail", userJourTravail);
                        editor.apply();
                        Toast.makeText(getApplicationContext(), "Inscription validée", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(FormulaireMedcinActivity.this,ProfilCoteMedecinActivity.class));
                    } else {
                        edNumTel.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                        edNumTel.setBackgroundResource(R.drawable.rouge_backround);
                    }


                }
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FormulaireMedcinActivity.this, SignupAssistanteActivity.class));
            }
        });


    }
}
