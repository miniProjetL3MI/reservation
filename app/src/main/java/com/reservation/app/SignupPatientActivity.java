package com.reservation.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupPatientActivity extends AppCompatActivity {
    EditText edNom, edPrenom, edMail, edMdp, edDateNaissance, edTel;
    ImageView btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_patient);
        edNom=findViewById(R.id.editTextTextNom);
        edPrenom=findViewById(R.id.editTextTextPrenom);
        edMail=findViewById(R.id.editTextTextEmail);
        edMdp=findViewById(R.id.editTextTextMotDePasse);
        edDateNaissance=findViewById(R.id.editTextTextDateNaiss);
        edTel=findViewById(R.id.editTextTextTelephone);
        btnSignup=findViewById(R.id.btnSignUpPatient);




             btnSignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String userName=edNom.getText().toString();
                    String userPrenom=edPrenom.getText().toString();
                    String userMail=edMail.getText().toString();
                    String userMdp=edMdp.getText().toString();
                    String userNaissance=edDateNaissance.getText().toString();
                    String userTel=edTel.getText().toString();

                    if(userName.length() == 0|| userPrenom.length() == 0 || userMail.length() == 0 || userMdp.length() == 0 || userNaissance.length() == 0 ||
                            userTel.length() == 0){
                        Toast.makeText(getApplicationContext(), "Remplissez les champs s'il vous plait", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Inscription validée", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupPatientActivity.this,ChoisirSpecialitesActivity.class));

                    }

                }
            });

    }
}