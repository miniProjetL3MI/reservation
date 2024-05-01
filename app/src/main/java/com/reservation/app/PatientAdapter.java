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

public class PatientAdapter extends ArrayAdapter<Patient>{
    public ArrayList<Patient> patientArrayList;
    public PatientAdapter(Context context, ArrayList<Patient> patientArrayList){
        super(context, 0,patientArrayList);
        this.patientArrayList=patientArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    //la classe ou on affiche les patients
                    R.layout.patient_list_view_row, parent, false
            );
        }
        //id de la page du patient
        TextView textViewPatient=convertView.findViewById(R.id.view_id_patient);
        Patient currentPatient = getItem(position);
        if(currentPatient != null){
            textViewPatient.setText(currentPatient.getNomPatient());
            textViewPatient.setText(currentPatient.getPrenomPatient());
            textViewPatient.setText(currentPatient.getDateNaissance());
            textViewPatient.setText(currentPatient.getEmailPatient());
            textViewPatient.setText(currentPatient.getMdpPatient());



        }
        return convertView;

    }
}