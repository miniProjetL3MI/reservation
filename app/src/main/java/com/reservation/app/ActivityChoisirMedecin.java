package com.reservation.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityChoisirMedecin extends AppCompatActivity {
    ImageView btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_medecin);

        btn1 = findViewById(R.id.imageViewA);


        btn1.setOnClickListener(v -> {
            startActivity(new Intent(ActivityChoisirMedecin.this, ProfilMedecinCotePatient.class));
        });
    }
}
