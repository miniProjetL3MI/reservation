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

public class ActivityChoisirMedecin extends AppCompatActivity {
    TextView tv;
    ListView medecinListView;
    List<MedecinAm> medecins = new ArrayList<>();
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
                MedecinAm medecinSelectionne = medecins.get(position);
                Toast.makeText(ActivityChoisirMedecin.this, "Médecin sélectionné : " + medecinSelectionne.getNom(), Toast.LENGTH_SHORT).show();
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
        medecins.add(new MedecinAm("Nom1", "Spécialité1"));
        medecins.add(new MedecinAm("Nom2", "Spécialité2"));
        // Ajoutez plus de médecins si nécessaire
        adapter.notifyDataSetChanged();
    }
}
