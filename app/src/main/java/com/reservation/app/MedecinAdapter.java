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

public class MedecinAdapter extends ArrayAdapter<Medecin>{
    public ArrayList<Medecin> medecinArrayList;
    public MedecinAdapter(Context context, ArrayList<Medecin> medecinArrayList){
        super(context, 0,medecinArrayList);
        this.medecinArrayList=medecinArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    //la classe ou on affiche les medecin
                    R.layout.medecin_list_view_row, parent, false
            );
        }
        //id de la page du medecin
        TextView textViewMedecin=convertView.findViewById(R.id.view_id_medecin);
        Medecin currentMedecin = getItem(position);
        if(currentMedecin != null){
            textViewMedecin.setText(currentMedecin.getNomMedecin());
            textViewMedecin.setText(currentMedecin.getPrenomMedecin());
            textViewMedecin.setText(currentMedecin.getEmailMedecin());
            textViewMedecin.setText(currentMedecin.getHeurOuverture());
            textViewMedecin.setText(currentMedecin.getHeurFermeture());
            textViewMedecin.setText(currentMedecin.getJourTravail());
            textViewMedecin.setText(currentMedecin.getNumTel());
            textViewMedecin.setText(currentMedecin.getSpecialite());

        }
        return convertView;

    }
}