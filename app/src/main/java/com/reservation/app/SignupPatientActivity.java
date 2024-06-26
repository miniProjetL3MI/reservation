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

public class SignupPatientActivity extends AppCompatActivity {
    EditText edNom, edPrenom, edMail, edMdp, edDateNaissance, edTel;
    ImageView btnSignup, btnreturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_patient);
        edNom = findViewById(R.id.editTextTextNom);
        edPrenom = findViewById(R.id.editTextTextPrenom);
        edMail = findViewById(R.id.editTextTextEmail);
        edMdp = findViewById(R.id.editTextTextMotDePasse);
        edDateNaissance = findViewById(R.id.editTextTextDateNaiss);
        edTel = findViewById(R.id.editTextTextTelephone);
        btnSignup = findViewById(R.id.imageView15);
        btnreturn = findViewById(R.id.btnSignUpPatient);


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
        edDateNaissance.addTextChangedListener(new TextWatcher() {
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
                    edDateNaissance.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edDateNaissance.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        edTel.addTextChangedListener(new TextWatcher() {
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
                    edTel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorHint)); // Couleur grise définie dans les ressources
                } else {
                    // Si le texte n'est pas vide, afficher le texte en noir
                    edTel.setTextColor(getResources().getColor(android.R.color.black)); // Couleur noire par défaut d'Android
                }
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edNom.getText().toString();
                String userPrenom = edPrenom.getText().toString();
                String userMail = edMail.getText().toString();
                String userMdp = edMdp.getText().toString();
                String userNaissance = edDateNaissance.getText().toString();
                String userTel = edTel.getText().toString();
                Database db = new Database(getApplicationContext(), "miniprojet", null, 1);


                if (userName.length() == 0 || userPrenom.length() == 0 || userMail.length() == 0 || userMdp.length() == 0 || userNaissance.length() == 0 ||
                        userTel.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Remplissez les champs s'il vous plait", Toast.LENGTH_SHORT).show();
                } else {
                    if (SignupAssistanteActivity.Utils.isValidEmail(edMail.getText().toString()) && SignupPatientActivity.Utils.isValidTel(userTel) && SignupPatientActivity.Utils.isValidDate(userNaissance)
                    && SignupAssistanteActivity.Utils.isValidMDP(userMdp)) {

                        db.registerpatient(userName, userPrenom, userMail, userMdp, userNaissance, userTel);

                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("nom", userName);
                        editor.putString("prenom", userPrenom);
                        editor.putString("email", userMail);
                        editor.putString("datedenaiss", userNaissance);
                        editor.putString("numTel", userTel);
                        editor.putString("motdepasse", userMdp);
                        editor.apply();




                        Toast.makeText(getApplicationContext(), "Inscription validée", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupPatientActivity.this, ChoisirSpecialitesActivity.class));
                    } else {
                        if (!SignupAssistanteActivity.Utils.isValidEmail(edMail.getText().toString())) {
                            edMail.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                            edMail.setBackgroundResource(R.drawable.rouge_backround);
                        } else {
                            edMail.setBackgroundResource(R.drawable.edittext_background);
                        }
                        if (!SignupPatientActivity.Utils.isValidTel(userTel)) {
                            edTel.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                            edTel.setBackgroundResource(R.drawable.rouge_backround);
                        } else {
                            edTel.setBackgroundResource(R.drawable.edittext_background);
                        }
                        if (!SignupPatientActivity.Utils.isValidDate(userNaissance)) {
                            edDateNaissance.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                            edDateNaissance.setBackgroundResource(R.drawable.rouge_backround);
                        } else {
                            edDateNaissance.setBackgroundResource(R.drawable.edittext_background);
                        }
                        if (!SignupAssistanteActivity.Utils.isValidMDP(userMdp)) {
                            edMdp.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                            edMdp.setBackgroundResource(R.drawable.rouge_backround);
                        } else {
                            edMdp.setBackgroundResource(R.drawable.edittext_background);
                        }
                    }


                }
            }
        });
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupPatientActivity.this, LoginActivity.class));
            }
        });


    }

    public static class Utils {

        public static boolean isValidTel(String phonenumber) {
            int i = 0;
            char c = phonenumber.charAt(i);
            if (phonenumber.length() == 10) {
                if (c == '0') {
                    i++;
                    c = phonenumber.charAt(i);
                    if (c == '5' || c == '6' || c == '7') {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }

        }

        public static boolean isValidDate(String date) {
            int i = 0;
            char c = date.charAt(i);
            if (date.length() == 10) {
                if (c == '0' || c == '2' ||c=='1') {
                    i++;
                    c = date.charAt(i);
                    if (c <= '9') {
                        i++;
                        c = date.charAt(i);
                        if (c == '/') {
                            i++;
                            c = date.charAt(i);
                            if (c == '0') {
                                i++;
                                c = date.charAt(i);
                                if (c <= '9') {
                                    i++;
                                    c = date.charAt(i);
                                    if (c == '/') {
                                        i++;
                                        c = date.charAt(i);
                                        if (c == '1' || c == '2') {
                                            i++;
                                            c = date.charAt(i);
                                            if (c == '9' || c == '0') {
                                                i++;
                                                c = date.charAt(i);
                                                if (c <= '9') {
                                                    i++;
                                                    c = date.charAt(i);
                                                    if (c <= '9') {
                                                        return true;

                                                    } else {
                                                        return false;
                                                    }
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                return false;
                                            }
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else if (c == '1') {
                                i++;
                                c = date.charAt(i);
                                if (c <= '2') {
                                    i++;
                                    c = date.charAt(i);
                                    if (c == '/') {
                                        i++;
                                        c = date.charAt(i);
                                        if (c == '1' || c == '2') {
                                            i++;
                                            c = date.charAt(i);
                                            if (c == '9' || c == '0') {
                                                i++;
                                                c = date.charAt(i);
                                                if (c <= '9') {
                                                    i++;
                                                    c = date.charAt(i);
                                                    if (c <= '9') {
                                                        return true;

                                                    } else {
                                                        return false;
                                                    }
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                return false;
                                            }
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }

                } else if (c == '3') {
                    i++;
                    c = date.charAt(i);
                    if (c <= '2') {
                        i++;
                        c = date.charAt(i);
                        if (c == '/') {
                            i++;
                            c = date.charAt(i);
                            if (c == '0') {
                                i++;
                                c = date.charAt(i);
                                if (c <= '9') {
                                    i++;
                                    c = date.charAt(i);
                                    if (c == '/') {
                                        i++;
                                        c = date.charAt(i);
                                        if (c == '1' || c == '2') {
                                            i++;
                                            c = date.charAt(i);
                                            if (c == '9' || c == '0') {
                                                i++;
                                                c = date.charAt(i);
                                                if (c <= '9') {
                                                    i++;
                                                    c = date.charAt(i);
                                                    if (c <= '9') {
                                                        return true;

                                                    } else {
                                                        return false;
                                                    }
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                return false;
                                            }
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else if (c == '1') {
                                i++;
                                c = date.charAt(i);
                                if (c <= '2') {
                                    i++;
                                    c = date.charAt(i);
                                    if (c == '/') {
                                        i++;
                                        c = date.charAt(i);
                                        if (c == '1' || c == '2') {
                                            i++;
                                            c = date.charAt(i);
                                            if (c == '9' || c == '0') {
                                                i++;
                                                c = date.charAt(i);
                                                if (c <= '9') {
                                                    i++;
                                                    c = date.charAt(i);
                                                    if (c <= '9') {
                                                        return true;

                                                    } else {
                                                        return false;
                                                    }
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                return false;
                                            }
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }

                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
    }
}