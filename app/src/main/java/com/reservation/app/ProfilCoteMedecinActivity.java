package com.reservation.app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilCoteMedecinActivity extends AppCompatActivity {
    ImageView boutonRendezVous,boutonNotif,boutonEvaluation,boutonModification;
    TextView tAdresse,tnumTel,tSpecialite,tJourTravail,tHouverture,tHfermeture;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_medecin_m);
        boutonRendezVous=findViewById(R.id.btnRendezVous);
        boutonNotif=findViewById(R.id.btnNotification);
        boutonEvaluation=findViewById(R.id.btnEvaluation);
        boutonModification=findViewById(R.id.btnModification);
        tAdresse=findViewById(R.id.adresseCabinet);
        tnumTel=findViewById(R.id.numTel);
        tSpecialite=findViewById(R.id.specialite);
        tJourTravail=findViewById(R.id.jourTraveil);
        tHouverture=findViewById(R.id.hOuverture);
        tHfermeture=findViewById(R.id.hFermeture);



    }

}
