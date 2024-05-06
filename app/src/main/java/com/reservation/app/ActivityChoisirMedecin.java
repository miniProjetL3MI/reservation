package com.reservation.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;


public class ActivityChoisirMedecin extends AppCompatActivity {
    TextView tv;
    ListView medecinListView;
    List<Medecin> medecins = new ArrayList<>();
    MedecinAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_medecin);

        medecinListView = findViewById(R.id.medecinListView);

        adapter = new MedecinAdapter(this, R.layout.medecin_item, medecins);
        medecinListView.setAdapter(adapter);

        medecinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Medecin medecinSelectionne = medecins.get(position);
                Toast.makeText(ActivityChoisirMedecin.this, "Médecin sélectionné : " + medecinSelectionne.getNomMedecin(), Toast.LENGTH_SHORT).show();
                // Vous pouvez ajouter ici le code pour ouvrir le profil du médecin sélectionné
            }
        });

        tv = findViewById(R.id.textView6);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        // Ajoutez ici le code pour charger la liste de médecins en fonction de la spécialité sélectionnée
        // Par exemple :
        loadMedecinsBySpecialite(title);
    }

    // Méthode pour charger la liste de médecins en fonction de la spécialité sélectionnée
    private void loadMedecinsBySpecialite(String specialite) {
        // Vous devez charger ici la liste des médecins en fonction de la spécialité sélectionnée
        // Remplacez cette démo par votre logique réelle
        medecins.clear();
        medecins.add(new Medecin("Nom1", "Spécialité1"));
        medecins.add(new Medecin("Nom2", "Spécialité2"));
        // Ajoutez plus de médecins si nécessaire
        // Ajoutez ce code juste avant adapter.notifyDataSetChanged()

        for (Medecin medecin : medecins) {
            Log.d("Medecin", "Nom : " + medecin.getNomMedecin() + ", Spécialité : " + medecin.getSpecialite());
        }

        adapter.notifyDataSetChanged();
    }
}
