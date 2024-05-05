package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityChoisirMedecin extends AppCompatActivity {
    TextView tv,nomPatient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_medecin);

        tv=findViewById(R.id.textView6);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        nomPatient=findViewById(R.id.textView4);
        nomPatient=findViewById(R.id.textView4);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String nomP=sharedPreferences.getString("nom","testToto");
        String prenomP=sharedPreferences.getString("prenom","testToto");

        // Concaténer le nom et le prénom
        String nomComplet = nomP + " " + prenomP;
        nomPatient.setText(nomComplet);



    }
}
