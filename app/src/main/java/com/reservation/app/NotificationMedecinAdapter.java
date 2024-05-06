package com.reservation.app;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NotificationMedecinAdapter extends ArrayAdapter<RendezVousAm> {
    private Context mContext;
    private int mResource;
    private List<RendezVousAm> mRendezVousList;

    public NotificationMedecinAdapter(@NonNull Context context, int resource, @NonNull List<RendezVousAm> rendezVousList) {
        super(context, resource, rendezVousList);
        mContext = context;
        mResource = resource;
        mRendezVousList = rendezVousList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        RendezVousAm currentRendezVous = mRendezVousList.get(position);

        // Récupérer les vues de la mise en page
        ImageView imageView = listItemView.findViewById(R.id.imageView4);
        TextView nameTextView = listItemView.findViewById(R.id.textView15);
        TextView dateTextView = listItemView.findViewById(R.id.textView18);
        TextView timeTextView = listItemView.findViewById(R.id.textView17);

        // Lier les données des rendez-vous des patients aux vues de la mise en page
        imageView.setImageResource(currentRendezVous.getImageResource());
        nameTextView.setText(currentRendezVous.getName());
        dateTextView.setText(currentRendezVous.getDate());
        timeTextView.setText(currentRendezVous.getTime());

        return listItemView;
    }
}
