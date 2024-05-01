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

public class CabinetAdapter extends ArrayAdapter<CabinetMedicale>{
    public ArrayList<CabinetMedicale> cabinetMedicaleArrayList;
    public CabinetAdapter(Context context, ArrayList<CabinetMedicale> cabinetMedicaleArrayList){
        super(context, 0,cabinetMedicaleArrayList);
        this.cabinetMedicaleArrayList=cabinetMedicaleArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    //la classe ou on affiche les cabinet
                    R.layout.cabinet_list_view_row, parent, false
            );
        }
        //id de la page du cabinet
        TextView textViewCabinet=convertView.findViewById(R.id.view_id_cabinet);
        CabinetMedicale currentCabinet = getItem(position);
        if(currentCabinet != null){
            textViewCabinet.setText(currentCabinet.getAdresse());

        }
        return convertView;

    }
}