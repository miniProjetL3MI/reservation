package com.reservation.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;
public class CommentaireAdapter extends ArrayAdapter<Commentaire>{
    private Context mContext;
    private int mResource;

    public CommentaireAdapter(Context context, int resource, List<Commentaire> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Récupérer les informations du commentaire à cette position
        Commentaire commentaire = getItem(position);

        // Utiliser un LayoutInflater pour gonfler le layout de chaque élément de la liste
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        // Associer les vues de layout avec les variables Java
        ImageView imageViewCommentateur = convertView.findViewById(R.id.imageViewCommentateur);
        TextView textViewNomCommentateur = convertView.findViewById(R.id.textViewNomCommentateur);
        TextView textViewCommentaire = convertView.findViewById(R.id.textViewCommentaire);
        RatingBar ratingBarCommentaire = convertView.findViewById(R.id.ratingBarCommentaire);

        // Remplir les vues avec les données du commentaire
        imageViewCommentateur.setImageResource(commentaire.getImageResource());
        textViewNomCommentateur.setText(commentaire.getNomCommentateur());
        textViewCommentaire.setText(commentaire.getContenuCommentaire());
        ratingBarCommentaire.setRating(commentaire.getNote());

        return convertView;
    }
}
