package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityChoisirMedecin extends AppCompatActivity {
    TextView tv, nomMedecin,nom;
    ListView medecinListView;
    List<MedecinAm> medecins = new ArrayList<>();
    MedecinAdapter adapter;
    HashMap<String, String> map;
    Params p = new Params();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_medecin);

        // Récupère la référence de la ListView
        medecinListView = findViewById(R.id.medecinListView);


        // Crée une instance de l'adaptateur personnalisé et l'associe à la ListView
        adapter = new MedecinAdapter(this, R.layout.medecin_item, medecins);
        medecinListView.setAdapter(adapter);

        // Ajoute un écouteur de clic sur la ListView pour afficher un toast avec le nom du médecin sélectionné
        medecinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MedecinAm medecinSelectionne = medecins.get(position);
                Toast.makeText(ActivityChoisirMedecin.this, "Médecin sélectionné : " + medecinSelectionne.getNom(), Toast.LENGTH_SHORT).show();
            }
        });

        // Récupère le titre de l'activité précédente et l'affiche dans le TextView
        tv = findViewById(R.id.textView6);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);




        SimpleAdapter adapt = new SimpleAdapter(ActivityChoisirMedecin.this, p.values, R.layout.medecin_item,
                new String[]{"nom"}, new int[]{R.id.textViewNomMedecin});
        medecinListView.setAdapter(adapt);



        // Définit un clic sur le nom du médecin pour ouvrir le profil du patient
        nomMedecin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ActivityChoisirMedecin.this, ProfilPatientActivity.class);
                startActivity(it);
            }
        });
    }
}
