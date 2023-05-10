package com.jorgeloayza.tareas5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgeloayza.tareas5.R;
import com.jorgeloayza.tareas5.pojo.FotoMascota;

import java.util.ArrayList;

public class MascotaFotosAdaptador extends RecyclerView.Adapter<MascotaFotosAdaptador.MascotaFotoViewHolder> {

    ArrayList<FotoMascota> fotosMascota;

    public MascotaFotosAdaptador(ArrayList<FotoMascota> fotosMascotas) {
        this.fotosMascota = fotosMascotas;
    }

    @NonNull
    @Override
    public MascotaFotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_foto,parent,false);
        return new MascotaFotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaFotoViewHolder holder, int position) {
        final FotoMascota fotoMascota = fotosMascota.get(position);
        holder.imgFotoMascota.setImageResource(fotoMascota.getFoto());
        holder.tvRatingFotoMascota.setText(fotoMascota.getRating()+"");
    }

    @Override
    public int getItemCount() {
        return fotosMascota.size();
    }

    public static class MascotaFotoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoMascota;
        private TextView tvRatingFotoMascota;

        public MascotaFotoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoMascota = itemView.findViewById(R.id.imgFotoMascota);

            tvRatingFotoMascota = itemView.findViewById(R.id.tvRatingFoto);
        }
    }
}
