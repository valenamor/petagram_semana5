package com.jorgeloayza.tareas5.pojo;
//clase mascota
public class Mascota {
    int id;
    String nombre;
    int raiting;
    int foto;
    public Mascota(int id,String nombre, int raiting, int foto) {
        this.id = id;
        this.nombre = nombre;
        this.raiting = raiting;
        this.foto = foto;
    }
    public Mascota(String nombre, int raiting, int foto) {
        this.nombre = nombre;
        this.raiting = raiting;
        this.foto = foto;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
