package com.reservation.app;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
public class MedecinAdapter extends ArrayAdapter<MedecinAm> {
    private Context context;
    private int resource;

    public MedecinAdapter(Context context, int resource, List<MedecinAm> medecins) {
        super(context, resource, medecins);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Vérifie si une vue recyclée est disponible, sinon inflates une nouvelle vue
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.medecin_item, parent, false);
        }

        // Récupère le médecin à la position donnée
        MedecinAm medecin = getItem(position);

        // Récupère les éléments de la mise en page XML
        TextView textViewNomMedecin = convertView.findViewById(R.id.textViewNomMedecin);
        TextView textViewEmailMedecin = convertView.findViewById(R.id.textViewEmailMedecin);

        // Définit les données du médecin sur les éléments de la mise en page XML
        textViewNomMedecin.setText(medecin.getNom());
        textViewEmailMedecin.setText(medecin.getEmail());

        // Renvoie la vue mise à jour
        return convertView;
    }
}
