package com.gmbdesign.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gmbdesign.db.BaseDatosCochePersona;
import com.gmbdesign.modelos.Coche;
import com.gmbdesign.modelos.Persona;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseDatosCochePersona dbCochesPersonas = new BaseDatosCochePersona(this, "midb", null, 1);


        Persona persona1 = new Persona(1, "Gustavo");
        Persona persona2 = new Persona(2, "Martin");
        Persona persona3 = new Persona(3, "Eva");

        /*
        dbCochesPersonas.insertarPersona(persona1);
        dbCochesPersonas.insertarPersona(persona2);
        dbCochesPersonas.insertarPersona(persona3);
        */

        Coche coche1 = new Coche("Ferrari", persona2);
        Coche coche2 = new Coche("Renault", persona3);
        Coche coche3 = new Coche("Toyota", persona1);

        /*
        dbCochesPersonas.insertarCoche(coche1);
        dbCochesPersonas.insertarCoche(coche2);
        dbCochesPersonas.insertarCoche(coche3);
        */

        List<Coche> coches = dbCochesPersonas.consultaCochesPersona(persona1);

        for(Coche c : coches){
            Log.e("TAG", "modelo: " + c.getModelo());
        }
    }
}
