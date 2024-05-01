package com.reservation.app;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edUserName, edPassword;
    ImageView btn;
    TextView newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName=findViewById(R.id.editTextTextPersonName);
        edPassword=findViewById(R.id.editTextTextPasswordName);
        btn=findViewById(R.id.bouttonLogin);
        newUser=findViewById(R.id.newUtilisateur);

        btn.setOnClickListener(view -> Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show())

        ;
    }
}
