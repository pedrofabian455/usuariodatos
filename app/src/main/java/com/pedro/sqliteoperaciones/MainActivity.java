package com.pedro.sqliteoperaciones;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText usuario, password;
    DbAdapter helper;
    @Override
    protected void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.usuarioNombre);
        password = (EditText) findViewById(R.id.usuarioNombre2);

        helper = new Dbdapter(this);
    }
    public void agregarUsuario(View view){
        String datoUsuario = usuario.getText.toString();
        String datoPassword = password.getText.toString();

        if(datoUsuario.isEmpty() || datoPassword.isEmpty()){
            mensaje.aviso(this, "Ingrese tanto el nombre como la contraseña");


        }else {
            long resultado = helper.insertarDatos(datoUsuario, datoPassword);
            if(resultado <=0){
                mensaje.aviso(this, "insercion fallida");
                usuario.setText("");
                password.setText("");
            }
        }
    }
}
