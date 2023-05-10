package com.jorgeloayza.tareas5.presentador;

import android.content.Context;

import com.jorgeloayza.tareas5.IFavoritosActivityView;
import com.jorgeloayza.tareas5.db.ConstructorMascotas;
import com.jorgeloayza.tareas5.pojo.Mascota;

import java.util.ArrayList;

public class FavoritosPresenter implements  IFavoritosPresenter{
    private IFavoritosActivityView iFavoritosActivityView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FavoritosPresenter(IFavoritosActivityView iFavoritosActivityView, Context context) {
        this.iFavoritosActivityView = iFavoritosActivityView;
        this.context = context;
        obtenerContactosBadeDatos();
    }

    @Override
    public void obtenerContactosBadeDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        this.mascotas = constructorMascotas.obtenerMascotas();
        mostarContactosRV();
    }

    @Override
    public void mostarContactosRV() {
        iFavoritosActivityView.inicializarAdaptadorRV(iFavoritosActivityView.crearAdaptador(mascotas));
        iFavoritosActivityView.generarLinearLayoutVertical();
    }
}
