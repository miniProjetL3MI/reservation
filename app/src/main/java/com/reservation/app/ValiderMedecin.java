package com.reservation.app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ValiderMedecin extends AppCompatActivity {
    EditText edUserName, edPrenom,edAdress,edSpecialite,edHeurOUver,edHeurFerm,edJour,edNumTel;
    ImageView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_medecin);
        edUserName=findViewById(R.id.editTextTextNom);
        edPrenom=findViewById(R.id.editTextTextPrenom);
        edAdress=findViewById(R.id.editTextTextAdresse);
        edSpecialite=findViewById(R.id.editTextTextSpecialite);
        edHeurOUver=findViewById(R.id.editTextTextHeureOuverture);
        edHeurFerm=findViewById(R.id.editTextTextHeureFermeture);
        edJour=findViewById(R.id.editTextTextJourTravail);
        edNumTel=findViewById(R.id.editTextTextNumTel);
        btn=findViewById(R.id.imageView6);
        btn.setOnClickListener(view -> Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show());

        edUserName.addTextChangedListener(new TextWatcher() {
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
                    edUserName.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edUserName.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
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
        edAdress.addTextChangedListener(new TextWatcher() {
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
                    edAdress.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edAdress.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
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
        edHeurOUver.addTextChangedListener(new TextWatcher() {
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
                    edHeurOUver.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edHeurOUver.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edHeurFerm.addTextChangedListener(new TextWatcher() {
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
                    edHeurFerm.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edHeurFerm.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edJour.addTextChangedListener(new TextWatcher() {
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
                    edJour.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edJour.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
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

    }
}
