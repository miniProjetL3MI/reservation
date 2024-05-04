package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ChoisirSpecialitesActivity extends AppCompatActivity {
    ImageView btn1, btn2, btn3;
    TextView nomPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_specialites);
        btn1 = findViewById(R.id.imageView4);
        nomPatient=findViewById(R.id.textView4);

        btn2 = findViewById(R.id.imageView9);
        btn3 = findViewById(R.id.imageView5);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String nomP=sharedPreferences.getString("nom","testToto");

        nomPatient.setText(nomP);

        btn1.setOnClickListener(v -> {
            startActivity(new Intent(ChoisirSpecialitesActivity.this, ActivityChoisirMedecin.class));
        });

        btn2.setOnClickListener(v -> {
            startActivity(new Intent(ChoisirSpecialitesActivity.this, ActivityChoisirMedecin.class));

        });

        btn3.setOnClickListener(v -> {
            startActivity(new Intent(ChoisirSpecialitesActivity.this, ActivityChoisirMedecin.class));

        });
    }
}
