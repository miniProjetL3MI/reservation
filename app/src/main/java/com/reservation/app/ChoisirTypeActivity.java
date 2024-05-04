package com.reservation.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChoisirTypeActivity extends AppCompatActivity {

    Button btnpatien,btnassistante;
    ImageView btnreturn ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_type);
        btnassistante = findViewById(R.id.button6);
        btnpatien = findViewById(R.id.button7);
        btnreturn = findViewById(R.id.imageView14);

        btnassistante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChoisirTypeActivity.this, SignupAssistanteActivity.class));
            }
        });

        btnpatien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChoisirTypeActivity.this, SignupPatientActivity.class));
            }
        });

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChoisirTypeActivity.this, LoginActivity.class));
            }
        });



    }


}
