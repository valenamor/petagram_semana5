package com.jorgeloayza.tareas5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jorgeloayza.tareas5.R;
import com.jorgeloayza.tareas5.correo.Config;
import com.jorgeloayza.tareas5.correo.MailJob;

public class ContacoActivity extends AppCompatActivity {
    EditText etNombre,etCorreo,etMensaje;
    Button btnEnviarComentario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contaco);

        Toolbar miActionBar = findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etMensaje = findViewById(R.id.etMensaje);

        btnEnviarComentario= findViewById(R.id.btnEnviarComentario);
        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNombre.getText().toString().isEmpty() || etCorreo.getText().toString().isEmpty() ||
                        etMensaje.getText().toString().isEmpty()){
                    Toast.makeText(view.getContext(),"Ingrese todos los datos",Toast.LENGTH_LONG).show();
                } else {
                    new MailJob(Config.EMAIL, Config.PASSWORD).execute(
                      new MailJob.Mail(etCorreo.getText().toString(),Config.EMAIL ,
                              "Comentario",etMensaje.getText().toString())
                    );
                    Toast.makeText(view.getContext(),"Correo Enviado.",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    /*new MailJob(user, passwd).execute(
              new MailJob.Mail("from@gmail.com", "to@otromail.com", "subjeto", "contenido")
            );*/
}