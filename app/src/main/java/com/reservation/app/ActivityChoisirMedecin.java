package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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
        ImageView profil =findViewById(R.id.imageView);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String nomP=sharedPreferences.getString("nom","testToto");
        String prenomP=sharedPreferences.getString("prenom","testToto");

        // Concaténer le nom et le prénom
        String nomComplet = nomP + " " + prenomP;
        nomPatient.setText(nomComplet);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(ActivityChoisirMedecin.this,ProfilPatientActivity.class);
                startActivity(it);
            }
        });

        nomPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(ActivityChoisirMedecin.this,ProfilPatientActivity.class);
                startActivity(it);
            }
        });


    }
}
