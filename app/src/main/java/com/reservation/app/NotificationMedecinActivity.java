package com.reservation.app;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class NotificationMedecinActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_notification_patient);

        // Obtenez une référence à la ListView depuis le layout XML
        ListView listView = findViewById(R.id.listViewNotifications);

        // Créez une liste de rendez-vous des patients (à remplacer par vos données réelles)
        List<RendezVousAm> rendezVousList = new ArrayList<>();
        rendezVousList.add(new RendezVousAm(R.drawable.profilef, "Nom1", "01/05/2024", "08:00"));
        rendezVousList.add(new RendezVousAm(R.drawable.profilef, "Nom2", "02/05/2024", "09:00"));
        // Ajoutez plus de rendez-vous si nécessaire

        // Créez un adaptateur personnalisé (NotificationMedecinAdapter) et définissez-le pour la ListView
        NotificationMedecinAdapter adapter = new NotificationMedecinAdapter(this, R.layout.notification_patient_item, rendezVousList);
        listView.setAdapter(adapter);
    }
}
