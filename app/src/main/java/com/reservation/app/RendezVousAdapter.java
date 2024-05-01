package com.reservation.app;


import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.reservation.app.Medecin;
import com.reservation.app.R;

import java.util.ArrayList;

public class RendezVousAdapter extends ArrayAdapter<RendezVous>{
    public ArrayList<RendezVous> rendezVousArrayList;
    public RendezVousAdapter(Context context, ArrayList<RendezVous> rendezVousArrayList){
        super(context, 0,rendezVousArrayList);
        this.rendezVousArrayList=rendezVousArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    //la classe ou on affiche les rdv
                    R.layout.rendezvous_list_view_row, parent, false
            );
        }
        //id de la page du rdv
        TextView textViewRendezVous=convertView.findViewById(R.id.view_id_rendezvous);
        RendezVous currentRendezVous = getItem(position);
        if(currentRendezVous != null){
            textViewRendezVous.setText(currentRendezVous.getDateRDV());
            textViewRendezVous.setText(currentRendezVous.getHeurRDV());

        }
        return convertView;

    }
}