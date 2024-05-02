package com.reservation.app;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}
