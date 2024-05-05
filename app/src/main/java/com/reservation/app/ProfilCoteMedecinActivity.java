package com.reservation.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilCoteMedecinActivity extends AppCompatActivity {
    ImageView boutonRendezVous,boutonNotif,boutonEvaluation,boutonModification;
    TextView tnom,tprenom,tmail,tAdresse,tnumTel,tSpecialite,tJourTravail,tHouverture,tHfermeture;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_medecin_m);
        boutonRendezVous=findViewById(R.id.btnRendezVous);
        boutonNotif=findViewById(R.id.btnNotification);
        boutonEvaluation=findViewById(R.id.btnEvaluation);
        boutonModification=findViewById(R.id.btnModification);
        tnom=findViewById(R.id.textView8);
        tmail=findViewById(R.id.textView12);
        tAdresse=findViewById(R.id.adresseCabinet);
        tnumTel=findViewById(R.id.numTel);
        tSpecialite=findViewById(R.id.specialite);
        tJourTravail=findViewById(R.id.jourTraveil);
        tHouverture=findViewById(R.id.hOuverture);
        tHfermeture=findViewById(R.id.hFermeture);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefsss", Context.MODE_PRIVATE);
        String nomP=sharedPreferences.getString("nom","testToto");
        String prenomP=sharedPreferences.getString("prenom","testToto");

        // Concaténer le nom et le prénom
        String nomComplet = nomP + " " + prenomP;
        tnom.setText(nomComplet);

        SharedPreferences sharedPreference = getSharedPreferences("shared_prefss", Context.MODE_PRIVATE);
        String email=sharedPreferences.getString("email","testToto");
        tmail.setText(email);





        SharedPreferences sharedPreferences0 = getSharedPreferences("shared_prefsss", Context.MODE_PRIVATE);
        String adresse=sharedPreferences.getString("adresse","testToto");
       tAdresse.setText(adresse);

        SharedPreferences sharedPreferences1 = getSharedPreferences("shared_prefsss", Context.MODE_PRIVATE);
        String num=sharedPreferences.getString("numTel","testToto");
        tnumTel.setText(num);

        SharedPreferences sharedPreferences2 = getSharedPreferences("shared_prefsss", Context.MODE_PRIVATE);
        String specialite=sharedPreferences.getString("specialite","testToto");
        tSpecialite.setText(specialite);

        SharedPreferences sharedPreferences3 = getSharedPreferences("shared_prefsss", Context.MODE_PRIVATE);
        String jTravail=sharedPreferences.getString("jourTravail","testToto");
        tJourTravail.setText(jTravail);

        SharedPreferences sharedPreferences4 = getSharedPreferences("shared_prefsss", Context.MODE_PRIVATE);
        String ouvert=sharedPreferences.getString("heurOuverture","testToto");
        tHouverture.setText(ouvert);

        SharedPreferences sharedPreferences5 = getSharedPreferences("shared_prefsss", Context.MODE_PRIVATE);
        String fermer=sharedPreferences.getString("heurFermeture","testToto");
        tHfermeture.setText(fermer);



    }

}
