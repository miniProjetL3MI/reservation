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
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;


import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edUserName, edPassword;
    ImageView btn;
    TextView newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName=findViewById(R.id.editTextTextPersonName);
        edPassword=findViewById(R.id.editTextTextPasswordName);
        btn=findViewById(R.id.bouttonLogin);
        newUser=findViewById(R.id.newUtilisateur);
        Database db = new Database(getApplicationContext(),"miniprojet",null,1);
        // Ajout de l'écouteur de texte pour edUserName
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
        edPassword.addTextChangedListener(new TextWatcher() {
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
                    edPassword.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edPassword.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Remplissez les champs s'il vous plait", Toast.LENGTH_SHORT).show();
                } else {
                    if (db.login(username, password) == 1) {
                        Toast.makeText(getApplicationContext(), "Authentification validée", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", username);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this, ChoisirSpecialitesActivity.class));
                    } else if (db.login1(username, password) == 1) {
                        Toast.makeText(getApplicationContext(), "Authentification validée", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", username);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this, ProfilCoteMedecinActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ChoisirTypeActivity.class));


            }
        });
    }
}
