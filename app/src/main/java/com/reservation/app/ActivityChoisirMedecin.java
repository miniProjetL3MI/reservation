package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityChoisirMedecin extends AppCompatActivity {
    TextView tv,nomPatient;
    ListView medecinListView;
    ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_medecin);

        // Récupère la référence de la ListView
        medecinListView = findViewById(R.id.medecinListView);
        profileImageView = findViewById(R.id.imageView3);

        // Crée une liste de médecins (tu devras remplacer ceci par ta propre logique de récupération des médecins)
        List<MedecinAm> medecins = new ArrayList<>();
        medecins.add(new MedecinAm("Dr. Smith", "email1@example.com"));
        medecins.add(new MedecinAm("Dr. Johnson", "email2@example.com"));
        medecins.add(new MedecinAm("Dr. Brown", "email3@example.com"));



        // Crée une instance de l'adaptateur personnalisé et l'associe à la ListView
        MedecinAdapter adapter = new MedecinAdapter(this, R.layout.medecin_item, medecins);
        medecinListView.setAdapter(adapter);

        // Ajoute un écouteur de clic sur la ListView si nécessaire
        medecinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Logique à exécuter lorsqu'un élément de la liste est cliqué
                MedecinAm medecinSelectionne = medecins.get(position);
                Toast.makeText(ActivityChoisirMedecin.this, "Médecin sélectionné : " + medecinSelectionne.getNom(), Toast.LENGTH_SHORT).show();
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
        String profileImageBase64 = sharedPreferences.getString("profile_image", "");
        // Afficher l'image de profil
        if (!profileImageBase64.isEmpty()) {
            byte[] decodedString = Base64.decode(profileImageBase64, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            profileImageView.setImageBitmap(decodedByte);
        }
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
