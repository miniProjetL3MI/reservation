package com.reservation.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.RatingBar;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EvaluerActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private EditText commentEditText;
    private ImageView submitButton;
    private ListView listViewCommentaires; // Ajout ici

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluer_commenter);

        // Associer les éléments de l'interface utilisateur avec les variables Java
        ratingBar = findViewById(R.id.ratingBar3);
        commentEditText = findViewById(R.id.commentEditText2);
        submitButton = findViewById(R.id.imageViewValider);
        listViewCommentaires = findViewById(R.id.listViewCommentaires); // Initialisation de la ListView

        // Créer une liste de commentaires (à remplacer par vos données réelles)
        List<Commentaire> commentaires = new ArrayList<>();
        commentaires.add(new Commentaire(R.drawable.profile, "Nom1", "Commentaire 1", 4.5f));
        commentaires.add(new Commentaire(R.drawable.profile, "Nom2", "Commentaire 2", 3.0f));
        // Ajoutez plus de commentaires si nécessaire

        // Créer un adaptateur pour les commentaires
        CommentaireAdapter adapter = new CommentaireAdapter(this, R.layout.commentaire_item, commentaires);

        // Associer l'adaptateur à la ListView
        listViewCommentaires.setAdapter(adapter);

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

        // Définir un écouteur d'événements pour le RatingBar
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // Vous pouvez mettre à jour votre application en fonction de la note sélectionnée ici
            }
        });
    }
}
