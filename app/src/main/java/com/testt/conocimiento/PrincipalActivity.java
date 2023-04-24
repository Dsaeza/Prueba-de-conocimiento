package com.testt.conocimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class PrincipalActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().replaceAll(" ","").length() > 0 && password.getText().toString().replaceAll(" ","").length() > 0){
                    if(username.getText().toString().length() >= 3 && password.getText().toString().length() >= 8){
                        Toast.makeText(PrincipalActivity.this, "Iniciando sesión.", Toast.LENGTH_LONG).show();
                        TimerTask tarea = new TimerTask() {
                            @Override
                            public void run() {
                                Intent logeado = new Intent(PrincipalActivity.this, SecondActivity.class);
                                String usuario = username.getText().toString();
                                logeado.putExtra("nombre", usuario);
                                startActivity(logeado);
                                finish();
                            }
                        };
                        Timer tiempo = new Timer();
                        tiempo.schedule(tarea, 1000);
                    }
                    else{
                        Toast.makeText(PrincipalActivity.this, "Al parecer no cumples los requisitos de inicio.", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(PrincipalActivity.this, "Campo(s) vacio(s). Rellene porfavor ", Toast.LENGTH_LONG).show();
                }

            }

        });
    }


}