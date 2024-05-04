package com.reservation.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityChoisirMedecin extends AppCompatActivity {
    ImageView btn1,btn3;
    TextView btn2 ,btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_medecin);
        btn1 = findViewById(R.id.imageViewA);
        btn2=findViewById(R.id.textViewA);
        btn3 = findViewById(R.id.imageView4);
        btn4=findViewById(R.id.textView15);

        btn1.setOnClickListener(v -> {
            startActivity(new Intent(ActivityChoisirMedecin.this, ProfilMedecinCotePatient.class));
        });
        btn2.setOnClickListener(v -> {
            startActivity(new Intent(ActivityChoisirMedecin.this, ProfilMedecinCotePatient.class));
        });
        btn3.setOnClickListener(v -> {
            startActivity(new Intent(ActivityChoisirMedecin.this, ProfilMedecinCotePatient.class));
        });
        btn4.setOnClickListener(v -> {
            startActivity(new Intent(ActivityChoisirMedecin.this, ProfilMedecinCotePatient.class));
        });

    }
}
