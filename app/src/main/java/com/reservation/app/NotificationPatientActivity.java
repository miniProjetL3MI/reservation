package com.reservation.app;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class NotificationPatientActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_notification_patient);

        // Obtenez une référence à la ListView depuis le layout XML
        ListView listView = findViewById(R.id.listViewNotifications);

        // Créer une liste d'objets ItemNotificationPatient et remplissez-la avec des données
        List<ItemNotificationPatient> yourDataList = new ArrayList<>();
        yourDataList.add(new ItemNotificationPatient(R.drawable.profilef, "Nom1", "Date1", "Heure1"));
        yourDataList.add(new ItemNotificationPatient(R.drawable.profilef, "Nom2", "Date2", "Heure2"));
        // Ajoutez plus d'éléments à votre liste si nécessaire

        // Créez un adaptateur personnalisé (NotificationAdapter) et définissez-le pour la ListView
        NotificationAdapter adapter = new NotificationAdapter(this, R.layout.notification_patient_item, yourDataList);
        listView.setAdapter(adapter);
    }
}
