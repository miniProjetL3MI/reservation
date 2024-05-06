package com.reservation.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ModifierProfilPatientActivity extends AppCompatActivity {

    TextView nomPatient, prenomPatient, dateNai, NumTel;
    Button buttonModifierProfil;
    ImageView profileImg;
    TextView titleName;
    private static final int IMAGE_PICK_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_profil_patient);
        nomPatient = findViewById(R.id.editTextTextprofileName);
        prenomPatient = findViewById(R.id.editTextTextprofilePrenom);
        dateNai = findViewById(R.id.editTextTextprofileEmail);
        NumTel = findViewById(R.id.editTextTextprofiletelephone);
        buttonModifierProfil = findViewById(R.id.editButton);
        profileImg = findViewById(R.id.profileImg);
        titleName = findViewById(R.id.titleName);

        // Récupérer l'email du patient depuis les SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        final String userEmail = sharedPreferences.getString("email", "");

        // Remplir les champs avec les informations actuelles du patient
        nomPatient.setText(sharedPreferences.getString("nom", ""));
        prenomPatient.setText(sharedPreferences.getString("prenom", ""));
        dateNai.setText(sharedPreferences.getString("datedenaiss", ""));
        NumTel.setText(sharedPreferences.getString("numTel", ""));

        // Ajouter un OnClickListener au titre "Modifier la photo"
        titleName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ouvrir la boîte de dialogue de sélection d'image
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE_PICK_CODE);
            }
        });

        buttonModifierProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = nomPatient.getText().toString();
                String userPrenom = prenomPatient.getText().toString();
                String userNaissance = dateNai.getText().toString();
                String userTel = NumTel.getText().toString();

                if (userName.isEmpty() || userPrenom.isEmpty() || userNaissance.isEmpty()) {
                    // Les champs sont vides, ne rien faire
                    return;
                }

                // Mettre à jour les valeurs dans SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nom", userName);
                editor.putString("prenom", userPrenom);
                editor.putString("datedenaiss", userNaissance);
                editor.putString("numTel", userTel);
                editor.apply();

                // Mettre à jour les valeurs dans la base de données
                Database db = new Database(getApplicationContext(), "miniprojet", null, 1);
                db.updatePatient(userEmail, userName, userPrenom, userNaissance, userTel);

                // Afficher un message de succès ou rediriger l'utilisateur
                Toast.makeText(ModifierProfilPatientActivity.this, "Profil mis à jour avec succès", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ModifierProfilPatientActivity.this, ProfilPatientActivity.class);
                startActivity(intent);
            }
        });

    }

    // Gérer le résultat de la sélection d'image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            Uri imageUri = data.getData();
            Bitmap resizedImage = resizeImage(getApplicationContext(), imageUri, profileImg.getWidth(), profileImg.getHeight());
            if (resizedImage != null) {
                setRoundedImage(resizedImage);
            } else {
                Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private Bitmap resizeImage(Context context, Uri uri, int targetWidth, int targetHeight) {
        try {
            Bitmap original = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            Bitmap resized = Bitmap.createScaledBitmap(original, targetWidth, targetHeight, true);
            return resized;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }
    private void saveImageToSharedPreferences(String base64Image) {
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profile_image", base64Image);
        editor.apply();
    }



    private void setRoundedImage(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }

        // Créer un masque de forme ovale
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = bitmap.getWidth() / 2;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        // Appliquer le masque à l'ImageView
        profileImg.setImageBitmap(output);

        // Convertir la Bitmap en String Base64
        String base64Image = bitmapToBase64(output);

        // Enregistrer l'image dans les SharedPreferences
        saveImageToSharedPreferences(base64Image);
    }


}
