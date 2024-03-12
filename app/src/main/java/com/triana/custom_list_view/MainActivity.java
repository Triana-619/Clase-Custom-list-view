package com.triana.custom_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import javax.swing.text.View;

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
                "mac miller",
                "post malone",
                "lil peep",
                "mac miller",
        };
        String[] telefonos = {
                "1111111",
                "2222222",
                "3333333",
                "4444444",
                "5555555",
        };

        ListAdapter personas = new ListAdapter(MainActivity.this,nombres,telefonos,fotoPerfil);
        listaPersona = (ListView) findViewById(R.id.listaUsuario);
        listaPersona.setAdapter(personas);

        listaPersona.setOnClickListener(new adapterView.OnItemClickListener){
            @override
            public void onItemClick(AdapterView<?> lista, View vista, int posicion, long id){
                    Intent enviarinfo = new Intent(MainActivity.this,UserActivity.class)
                            .putExtra("nombre",nombres[posicion])
                            .putExtra("telefono",telefonos[posicion])
                            .putExtra("imagen",fotoPerfil[posicion]);

                    startActivity(enviarinfo);
            }

        }
    }
}