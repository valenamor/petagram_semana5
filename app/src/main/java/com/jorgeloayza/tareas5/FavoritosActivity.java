package com.jorgeloayza.tareas5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jorgeloayza.tareas5.R;
import com.jorgeloayza.tareas5.adapter.MascotaAdaptador;
import com.jorgeloayza.tareas5.db.ConstructorMascotas;
import com.jorgeloayza.tareas5.pojo.Mascota;
import com.jorgeloayza.tareas5.presentador.FavoritosPresenter;
import com.jorgeloayza.tareas5.presentador.IFavoritosPresenter;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity  implements IFavoritosActivityView{
    //ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView rvMascotasFavoritas;
    //private ConstructorMascotas constructorMascotas;
    private IFavoritosPresenter iFavoritosPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        //definimos nuestro toobar
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Para el objetivo de este ejemplo, lo único que deberás mostrar es un RecyclerView
        // con 5 mascotas “Dummy” o Hardcodeadas.
        /*mascotasFavoritas = new ArrayList<Mascota>();
        mascotasFavoritas.add(new Mascota("Shadow",350,R.drawable.foto4));
        mascotasFavoritas.add(new Mascota("Ronny",200,R.drawable.foto1));
        mascotasFavoritas.add(new Mascota("Lucky",160,R.drawable.foto2));
        mascotasFavoritas.add(new Mascota("Cookie",160,R.drawable.foto3));
        mascotasFavoritas.add(new Mascota("Cookie",150,R.drawable.dog3_logo));
*/
        //constructorMascotas = new ConstructorMascotas(this);
        //mascotasFavoritas = constructorMascotas.obtenerMascotas();



        rvMascotasFavoritas = findViewById(R.id.rvMacotasFavoritas);


        iFavoritosPresenter = new FavoritosPresenter(this,this);


    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas);
        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotasFavoritas.setAdapter(adaptador);
    }
}