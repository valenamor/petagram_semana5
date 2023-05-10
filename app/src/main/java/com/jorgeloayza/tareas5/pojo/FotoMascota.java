package com.jorgeloayza.tareas5.pojo;

public class FotoMascota {
    int foto,rating;

    public FotoMascota(int foto, int rating) {
        this.foto = foto;
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
