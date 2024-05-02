package com.reservation.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUserName.getText().toString();
                String password=edPassword.getText().toString();
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(), "Remplissez les champs s'il vous plait", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Authentification validée", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,ChoisirSpecialitesActivity.class));

                }

            }
        });
    }
}