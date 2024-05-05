package com.reservation.app;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
public class MedecinAdapter extends ArrayAdapter<Medecin> {
    private Context context;
    private int resource;

    public MedecinAdapter(Context context, int resource, List<Medecin> medecins) {
        super(context, resource, medecins);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        ImageView imageViewMedecin = convertView.findViewById(R.id.imageViewMedecin);
        TextView textViewNomMedecin = convertView.findViewById(R.id.textViewNomMedecin);
        TextView textViewEmailMedecin = convertView.findViewById(R.id.textViewEmailMedecin);

        Medecin medecin = getItem(position);

        if (medecin != null) {
            // Set data to views
            imageViewMedecin.setImageResource(R.drawable.profile2);
            textViewNomMedecin.setText(medecin.getNomMedecin());
            textViewEmailMedecin.setText(medecin.getEmailMedecin());
        }

        return convertView;
    }
}
