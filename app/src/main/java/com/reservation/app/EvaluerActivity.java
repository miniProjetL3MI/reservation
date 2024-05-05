package com.reservation.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class EvaluerActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private EditText commentEditText;
    private ImageView submitButton; // Changement ici

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluer_commenter);

        // Associer les éléments de l'interface utilisateur avec les variables Java
        ratingBar = findViewById(R.id.ratingBar3);
        commentEditText = findViewById(R.id.commentEditText2); // Changement ici
        submitButton = findViewById(R.id.imageViewValider);

        // Définir le gestionnaire d'événements pour le bouton de soumission
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer la note sélectionnée et le commentaire saisi par l'utilisateur
                float rating = ratingBar.getRating();
                String comment = commentEditText.getText().toString();

                // Valider si l'utilisateur a saisi une note et un commentaire
                if (rating > 0 && !comment.isEmpty()) {
                    // Traitement des données, par exemple, envoi à une base de données
                    // Pour l'exemple, affichons simplement la note et le commentaire dans un toast
                    String message = "Note : " + rating + "\nCommentaire : " + comment;
                    Toast.makeText(EvaluerActivity.this, message, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(EvaluerActivity.this, "Veuillez saisir une note et un commentaire", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
