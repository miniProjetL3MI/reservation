package com.reservation.app;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class NotificationPatientActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_notification_patient);

        // Obtenez une référence à la ListView depuis le layout XML
        ListView listView = findViewById(R.id.listViewNotifications);

        // Créez un adaptateur personnalisé (CustomListAdapter) et définissez-le pour la ListView
        NotificationAdapter adapter = new NotificationAdapter(this, R.layout.item_layout, yourDataList);
        listView.setAdapter(adapter);
    }
}

