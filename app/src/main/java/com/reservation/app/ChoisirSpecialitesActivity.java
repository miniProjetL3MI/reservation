package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChoisirSpecialitesActivity extends AppCompatActivity {

    TextView nomPatient ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_specialites);

        nomPatient=findViewById(R.id.textView4);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String nomP=sharedPreferences.getString("nom","testToto");
        String prenomP=sharedPreferences.getString("prenom","testToto");

        // Concaténer le nom et le prénom
        String nomComplet = nomP + " " + prenomP;
        nomPatient.setText(nomComplet);
        ImageView profil =findViewById(R.id.imageView);
        ImageView cardio =findViewById(R.id.imageView4);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(ChoisirSpecialitesActivity.this,ProfilPatientActivity.class);
                startActivity(it);
            }
        });

        nomPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(ChoisirSpecialitesActivity.this,ProfilPatientActivity.class);
                startActivity(it);
            }
        });

        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(ChoisirSpecialitesActivity.this,ActivityChoisirMedecin.class);
                it.putExtra("title","Cardiologie ");
                startActivity(it);
            }
        });
        ImageView pneumologie =findViewById(R.id.imageView9);
        pneumologie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(ChoisirSpecialitesActivity.this,ActivityChoisirMedecin.class);
                it.putExtra("title","pneumologie ");
                startActivity(it);
            }
        });
        ImageView Neurologie =findViewById(R.id.imageView5);
        Neurologie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(ChoisirSpecialitesActivity.this,ActivityChoisirMedecin.class);
                it.putExtra("title","Neurologie ");
                startActivity(it);
            }
        });








    }
}
