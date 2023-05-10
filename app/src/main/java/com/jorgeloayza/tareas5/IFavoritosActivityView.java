package com.jorgeloayza.tareas5;

import com.jorgeloayza.tareas5.adapter.MascotaAdaptador;
import com.jorgeloayza.tareas5.pojo.Mascota;

import java.util.ArrayList;

public interface IFavoritosActivityView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
