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

        // Récupérer la référence de la ListView
        medecinListView = findViewById(R.id.medecinListView);

        // Créer une liste de médecins (c'est juste un exemple, tu devras récupérer tes médecins depuis quelque part)
        List<String> medecins = new ArrayList<>();
        medecins.add("Dr. Smith");
        medecins.add("Dr. Johnson");
        medecins.add("Dr. Brown");

        // Créer un adaptateur pour la ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medecins);

        // Associer l'adaptateur à la ListView
        medecinListView.setAdapter(adapter);

        // Ajouter un écouteur de clic sur la ListView si nécessaire
        medecinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Logique à exécuter lorsqu'un élément de la liste est cliqué
                String medecinSelectionne = medecins.get(position);
                Toast.makeText(ActivityChoisirMedecin.this, "Médecin sélectionné : " + medecinSelectionne, Toast.LENGTH_SHORT).show();
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
