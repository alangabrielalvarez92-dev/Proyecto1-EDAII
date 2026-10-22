package modelos;

import java.util.*;

public class Artista {

    private String nombre;
    private String genero;
    private List<Cancion> canciones;

    public Artista(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void addCancion(Cancion c) {
        canciones.add(c);
    }

    public void removeCancion(Cancion c) {
        canciones.remove(c);
    }

    public void mostrarCanciones() {
        if (canciones.isEmpty()) {
            System.out.println("La lista de canciones del Artista esta vacia");
        }
        for (Cancion c : canciones) {
            System.out.println(c);
        }
    }

    public String toString() {
        return nombre + " " + genero + ".";
    }

}