package com.reservation.app;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.util.Calendar;

public class MainActivity1 extends AppCompatActivity {

    EditText editTextDate, editTextHeure;
    Button validerButton;

    SQLiteDatabase sqLiteDatabase;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_rendez_vous);

        // Initialize EditTexts and Button
        editTextDate = findViewById(R.id.editTextTextDate);
        editTextHeure = findViewById(R.id.editTextTextHeure);
        validerButton = findViewById(R.id.editButton);

        // Create or open the database
        sqLiteDatabase = openOrCreateDatabase("rendezvous", MODE_PRIVATE, null);

        // Set OnClickListener for the editTextDate
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a DatePickerDialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Set the selected date in the editTextDate
                        editTextDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                // Show the DatePickerDialog
                datePickerDialog.show();
            }
        });

        // Set OnClickListener for the editTextHeure
        editTextHeure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a TimePickerDialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Set the selected time in the editTextHeure
                        editTextHeure.setText(hourOfDay + ":" + minute);
                    }
                }, Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), true);
                // Show the TimePickerDialog
                timePickerDialog.show();
            }
        });

        // Set OnClickListener for the validerButton
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected data from EditTexts
                String selectedDate = editTextDate.getText().toString().trim();
                String selectedHeure = editTextHeure.getText().toString().trim();

                // Insert the data into the database
                registerRendezvous(selectedHeure, selectedDate);

                // Show a toast message indicating that data is saved
                Toast.makeText(MainActivity1.this, "Date sélectionnée : " + selectedDate + ", Heure sélectionnée : " + selectedHeure, Toast.LENGTH_SHORT).show();
            }
        });

    }


    // Method to insert data into the database
    public void registerRendezvous(String heurrendezvous, String daterendezvous) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("heurrendezvous", heurrendezvous);
            cv.put("daterendezvous", daterendezvous);
            sqLiteDatabase.insert("rendezvous", null, cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

