package com.reservation.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MedecinAdapter extends ArrayAdapter<Medecin> {
    private Context mContext;
    private int mResource;

    public MedecinAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Medecin> objects) {
        super(context, 0, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        Medecin medecin = getItem(position);

        if (medecin != null) {
            TextView nomTextView = convertView.findViewById(R.id.nomTextView);
            TextView specialiteTextView = convertView.findViewById(R.id.specialiteTextView);

            nomTextView.setText(medecin.getNomMedecin());
            specialiteTextView.setText(medecin.getSpecialite());
        }

        return convertView;
    }
}
