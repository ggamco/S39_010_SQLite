package com.gmbdesign.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gmbdesign.modelos.Coche;
import com.gmbdesign.modelos.Persona;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggamboa on 8/2/17.
 */

public class BaseDatosCochePersona extends SQLiteOpenHelper {

    //Sintaxis SQLite
    private static final String SQL_TABLA_PERSONA = "CREATE TABLE Personas (id INTEGER PRIMARY KEY, nombre TEXT)";
    private static final String SQL_TABLA_COCHE = "CREATE TABLE Coches (id INTEGER PRIMARY KEY AUTOINCREMENT, modelo TEXT, idPersona INTEGER, FOREIGN KEY (idPersona) REFERENCES Personas (id))";

    public BaseDatosCochePersona(Context context, String name, SQLiteDatabase.CursorFactory cursor, int version) {
        super(context, name, cursor, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //aqui vamos a crear las tablas de nuestra base de datos.
        db.execSQL(SQL_TABLA_PERSONA);
        db.execSQL(SQL_TABLA_COCHE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertarCoche(Coche coche){
        //Instanciamos la base de datos preparandola para escritura
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Sentencia Insert
        String sql = "INSERT INTO Coches ('modelo', 'idPersona') VALUES ('"+coche.getModelo()+"', "+coche.getPersona().getId()+")";

        //ejecutamos la sentencia
        sqLiteDatabase.execSQL(sql);

        //liberamos recursos
        sqLiteDatabase.close();
    }

    public void insertarPersona(Persona persona){
        //Instanciamos la base de datos preparandola para escritura
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Sentencia Insert
        String sql = "INSERT INTO Personas ('id', 'nombre') VALUES ('"+persona.getId()+"', '"+persona.getNombre()+"')";

        //ejecutamos la sentencia
        sqLiteDatabase.execSQL(sql);

        //liberamos recursos
        sqLiteDatabase.close();
    }

    public List<Coche> consultaCochesPersona(Persona persona){
        //Buenas practicas de programación
        List<Coche> listado = null;

        //Instanciamos la base de datos preparandola para escritura
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Sentencia Select
        String consulta = "SELECT modelo FROM Coches WHERE idPersona = "+persona.getId();

        //Ejecutamos la sentencia
        Cursor cursor = sqLiteDatabase.rawQuery(consulta, null);

        if(cursor != null && cursor.getCount() > 0){
            //nos ha devuelto resultados
            cursor.moveToFirst();

            listado = new ArrayList<Coche>();

            do{

                String modelo = cursor.getString(0);
                Coche coche = new Coche(modelo);
                listado.add(coche);

            }while(cursor.moveToNext());
        }

        //Liberamos recursos
        sqLiteDatabase.close();

        return listado;
    }
}
