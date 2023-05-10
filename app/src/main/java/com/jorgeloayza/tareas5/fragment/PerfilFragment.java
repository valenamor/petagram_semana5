package com.jorgeloayza.tareas5.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgeloayza.tareas5.R;
import com.jorgeloayza.tareas5.adapter.MascotaFotosAdaptador;
import com.jorgeloayza.tareas5.pojo.FotoMascota;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {
    ArrayList<FotoMascota> fotosMascota;
    private RecyclerView rvFotos;


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_perfil, container, false);
        fotosMascota  = new ArrayList<>();
        fotosMascota.add(new FotoMascota(R.drawable.perfil1,212));
        fotosMascota.add(new FotoMascota(R.drawable.perfil2,234));
        fotosMascota.add(new FotoMascota(R.drawable.perfil3,133));
        fotosMascota.add(new FotoMascota(R.drawable.perfil4,535));
        fotosMascota.add(new FotoMascota(R.drawable.perfil5,235));
        fotosMascota.add(new FotoMascota(R.drawable.perfil6,242));
        fotosMascota.add(new FotoMascota(R.drawable.perfil7,224));
        fotosMascota.add(new FotoMascota(R.drawable.perfil8,223));
        fotosMascota.add(new FotoMascota(R.drawable.foto1,215));
        fotosMascota.add(new FotoMascota(R.drawable.foto2,822));

        rvFotos = view.findViewById(R.id.rvPerfil);
        rvFotos.setLayoutManager(new GridLayoutManager(view.getContext(),3));
        MascotaFotosAdaptador mascotaFotosAdaptador = new MascotaFotosAdaptador(fotosMascota);
        rvFotos.setAdapter(mascotaFotosAdaptador);


        return view;
    }
}