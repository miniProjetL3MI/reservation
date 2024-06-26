package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SignupAssistanteActivity  extends AppCompatActivity {
    EditText edNom,edPrenom,edMail,edMdp;
    ImageView btnSignUp,btnReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_assisstante);
        edNom=findViewById(R.id.editTextTextNom);
        edPrenom=findViewById(R.id.editTextTextPrenom);
        edMail=findViewById(R.id.editTextTextEmail);
        edMdp=findViewById(R.id.editTextTextMotDePasse);
        btnSignUp=findViewById(R.id.imageView2);
        btnReturn =findViewById(R.id.imageView14);

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
        edMail.addTextChangedListener(new TextWatcher() {
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
                    edMail.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edMail.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android

                }
            }
        });
        edMdp.addTextChangedListener(new TextWatcher() {
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
                    edMdp.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edMdp.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android

                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=edNom.getText().toString();
                String userPrenom=edPrenom.getText().toString();
                String userMail=edMail.getText().toString();
                String userMdp=edMdp.getText().toString();
                Database db = new Database(getApplicationContext(),"miniprojet",null,1);




                if(userName.length() == 0|| userPrenom.length() == 0 || userMail.length() == 0 || userMdp.length() == 0){
                    Toast.makeText(getApplicationContext(), "Remplissez les champs s'il vous plait", Toast.LENGTH_SHORT).show();
                }else {
                    if (Utils.isValidEmail(edMail.getText().toString()) && Utils.isValidMDP((userMdp))) {

                        db.registerassisstante(userName, userPrenom, userMail, userMdp);
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefss", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", userMail);
                        editor.putString("motdepasse", userMdp);
                        editor.putString("nom", userName);
                        editor.putString("prenom", userPrenom);
                        editor.apply();
                        Toast.makeText(getApplicationContext(), "Inscription validée", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupAssistanteActivity.this,FormulaireMedcinActivity.class));
                    } else {
                        if (!Utils.isValidEmail(edMail.getText().toString())) {
                            edMail.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                            edMail.setBackgroundResource(R.drawable.rouge_backround);
                        } else {
                            edMail.setBackgroundResource(R.drawable.edittext_background);
                        }
                        if (!Utils.isValidMDP(userMdp)) {
                            edMdp.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                            edMdp.setBackgroundResource(R.drawable.rouge_backround);
                        } else {
                            edMdp.setBackgroundResource(R.drawable.edittext_background);
                        }

                    }
                }
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupAssistanteActivity.this, ChoisirTypeActivity.class));
            }
        });



    }
    public static class Utils {

        public static boolean isValidEmail(CharSequence target) {
            return (target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches());
        }
        public static boolean isValidMDP(String passe){
            if ((passe.length()>=8)){
                return true;
            }else {
                return false;
            }

        }
    }

}

