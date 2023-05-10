package com.jorgeloayza.tareas5.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.jorgeloayza.tareas5.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context,ConstantesBaseDatos.DATABASE_NAME , null,ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String crearTablaMascota = "CREATE TABLE "+ConstantesBaseDatos.TABLE_MASCOTA +"(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT," +
                ConstantesBaseDatos.TABLE_MASCOTA_RATING + " INTEGER," +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER" +
                ")";
        String crearTablaFavoritos = "CREATE TABLE "+ConstantesBaseDatos.TABLE_MASCOTA +"(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT," +
                ConstantesBaseDatos.TABLE_MASCOTA_RATING + " INTEGER," +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER" +
                ")";


        sqLiteDatabase.execSQL(crearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_MASCOTA);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerCincoMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        //obtenemos las ultimas 5 mascotas raiteadas
        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_MASCOTA + " ORDER BY id DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRaiting(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));;

            mascotas.add(mascotaActual);
        }
        registros.close();
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();
    }
    public boolean verificaExiste(Mascota mascota){
        boolean resultado;
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_ID + "=" + mascota.getId();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.getCount() <= 0){
            cursor.close();
            resultado = false;
        } else {
            resultado = true;
        }
        cursor.close();
        sqLiteDatabase.close();
        return resultado;
    }

    public void borrarRegistro(Mascota mascota) {
        ContentValues cv = new ContentValues();
        cv.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING,mascota.getRaiting());
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ConstantesBaseDatos.TABLE_MASCOTA,
                ConstantesBaseDatos.TABLE_MASCOTA_ID+" = ?",new String[]{mascota.getId()+""});
        db.close();
    }
}
