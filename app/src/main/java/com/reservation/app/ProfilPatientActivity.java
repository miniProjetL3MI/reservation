package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilPatientActivity extends AppCompatActivity {

    TextView nomPatient, email;
    Button buttonModifierProfil;
    ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_patient);

        nomPatient = findViewById(R.id.textView9);
        email = findViewById(R.id.textView10);
        buttonModifierProfil = findViewById(R.id.button3);
        profileImageView = findViewById(R.id.imageView2);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String nomP = sharedPreferences.getString("nom", "testToto");
        String prenomP = sharedPreferences.getString("prenom", "testToto");
        String mailP = sharedPreferences.getString("email", "testToto");
        String profileImageBase64 = sharedPreferences.getString("profile_image", "");

        // Concaténer le nom et le prénom
        String nomComplet = nomP + " " + prenomP;
        nomPatient.setText(nomComplet);
        email.setText(mailP);

        // Afficher l'image de profil
        if (!profileImageBase64.isEmpty()) {
            byte[] decodedString = Base64.decode(profileImageBase64, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            profileImageView.setImageBitmap(decodedByte);
        }

        buttonModifierProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilPatientActivity.this, ModifierProfilPatientActivity.class);
                startActivity(intent);
            }

        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilPatientActivity.this, ChoisirSpecialitesActivity.class);
                startActivity(intent);
            }
        });
    }
}
