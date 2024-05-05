package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class ActivityChoisirMedecin extends AppCompatActivity {
    TextView tv,nomPatient;
    ListView medecinListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_medecin);

        // Récupère la référence de la ListView
        medecinListView = findViewById(R.id.medecinListView);

        // Crée une liste de médecins (tu devras remplacer ceci par ta propre logique de récupération des médecins)
        List<Medecin> medecins = new ArrayList<>();
        medecins.add(new Medecin("Dr. Smith", "email1@example.com"));
        medecins.add(new Medecin("Dr. Johnson", "email2@example.com"));
        medecins.add(new Medecin("Dr. Brown", "email3@example.com"));

        // Crée une instance de l'adaptateur personnalisé et l'associe à la ListView
        MedecinAdapter adapter = new MedecinAdapter(this, R.layout.medecin_item, medecins);
        medecinListView.setAdapter(adapter);

        // Ajoute un écouteur de clic sur la ListView si nécessaire
        medecinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Logique à exécuter lorsqu'un élément de la liste est cliqué
                Medecin medecinSelectionne = medecins.get(position);
                Toast.makeText(ActivityChoisirMedecin.this, "Médecin sélectionné : " + medecinSelectionne.getNomMedecin(), Toast.LENGTH_SHORT).show();
            }
        });

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
