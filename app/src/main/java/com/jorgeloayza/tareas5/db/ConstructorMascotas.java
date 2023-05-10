package com.jorgeloayza.tareas5.db;

import android.content.ContentValues;
import android.content.Context;
import com.jorgeloayza.tareas5.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotas(){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerCincoMascotasFavoritas();
    }

    /*public void insertarTresContactos(BaseDatos baseDatos){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Anahi Salgado");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "7777744444");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "anahi@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.imagen_contacto);
        baseDatos.insertarMascota(contentValues);
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Nombre 2");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "7777744444");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "anahi@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.imagen_contacto);
        baseDatos.insertarMascota(contentValues);
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Nombre 3");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "7777744444");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "anahi@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.imagen_contacto);
        baseDatos.insertarMascota(contentValues);
    }*/


    public void insertarMascota(Mascota mascota){
        BaseDatos baseDatos = new BaseDatos(context);
        if (baseDatos.verificaExiste(mascota)){
            baseDatos.borrarRegistro(mascota);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ID, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, mascota.getRaiting());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, mascota.getFoto());
        baseDatos.insertarMascota(contentValues);
    }

}
