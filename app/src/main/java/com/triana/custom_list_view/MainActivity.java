package com.triana.custom_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listaPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] fotoPerfil = {
                R.drawable.primo,
                R.drawable.juice1,
                R.drawable.juice2,
                R.drawable.juice3,
                R.drawable.juice4,
        };
        String[] nombres = {
                "Juicewrdl",
                "mac miller producción",
                "Lil peep",
                "Post malone",
                "mac miller",
        };
        String[] biografias = {
                "Biografía de Juicewrdl",
                "Biografía de Mac Miller",
                "Biografía de Lil peep",
                "Biografía de Post malone",
                "Biografía de Mac Miller",
        };
        String[] telefonos = {
                "1111111",
                "2222222",
                "3333333",
                "4444444",
                "5555555",
        };

        ListAdapter personas = new ListAdapter(MainActivity.this,nombres,telefonos,fotoPerfil,biografias);
        listaPersona = (ListView) findViewById(R.id.listaUsuario);
        listaPersona.setAdapter(personas);

        listaPersona.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> Lista, View Vista, int Posicion, long Id){

                Intent EnviarInfo = new Intent(MainActivity.this, UserActivity.class)
                        .putExtra("Nombre: ", nombres[Posicion])
                        .putExtra("Teléfono: ", telefonos[Posicion])
                        .putExtra("Foto de Perfil: ", fotoPerfil[Posicion])
                        .putExtra("Biografia: ", biografias[Posicion]);
                startActivity(EnviarInfo);
            }
        });

        }
    }