package com.reservation.app;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChoisirSpecialitesActivity extends AppCompatActivity {
    ImageView btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_specialites);

        btn1 = findViewById(R.id.imageView4);
        btn2 = findViewById(R.id.imageView9);
        btn3 = findViewById(R.id.imageView5);

        btn1.setOnClickListener(v -> {
            startActivity(new Intent(ChoisirSpecialitesActivity.this, Medecin.class));
        });

        btn2.setOnClickListener(v -> {
            startActivity(new Intent(ChoisirSpecialitesActivity.this, Medecin.class));

        });

        btn3.setOnClickListener(v -> {
            startActivity(new Intent(ChoisirSpecialitesActivity.this, Medecin.class));

        });
    }
}
