package com.testt.conocimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends AppCompatActivity {
    TextView username;
    Button cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        username = findViewById(R.id.username);
        Bundle datos = getIntent().getExtras();
        String nombre1 = datos.getString("nombre");
        username.setText(nombre1);
        cerrar = findViewById(R.id.cerrar);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cerrar programa
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        });
    }
}