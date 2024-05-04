package com.reservation.app;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class EssaiCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous_medecin);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // Ici, vous pouvez ajouter la logique pour vérifier si un rendez-vous existe pour la date sélectionnée
                // Si un rendez-vous existe, vous pouvez marquer cette date en rouge
                // Par exemple, ici, je marque la date actuelle en rouge
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH);
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (year == currentYear && month == currentMonth && dayOfMonth == currentDay) {
                    view.setDateColor(Color.RED);
                } else {
                    view.setDateColor(Color.BLACK);
                }
            }
        });
    }
}
