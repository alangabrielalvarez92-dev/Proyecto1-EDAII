package modelos;

import colecciones.ListaCanciones;
import ordenamientos.*;
import java.util.*;

public class Playlist {

    private int id;
    private String nombre;
    private ListaCanciones canciones;
    private static int contador=0;

    public Playlist(String nombre) {
        this.id = contador++;
        this.nombre = nombre;
        this.canciones = new ListaCanciones();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ListaCanciones getCanciones() {
        return canciones;
    }

    public boolean isEmpty(){
        return canciones.estaVacio();
    }

    public void addCancion(Cancion c) {
        if (!canciones.insertar(c)) {
            System.out.println("La cancion no es valida o ya existe en la playlist.");
        }
    }

    public void removeCancion(Cancion c) {
        if (c != null) {
            canciones.eliminar(c.getId());
        }
    }

    public Cancion buscarCancion(int id) {
        return canciones.buscar(id);
    }

    public void ordenar(Comparator<Cancion> criterio) {
        MergeSort.mergeSort(canciones.getCanciones(), criterio);
    }

    public void mostrarPlaylist() {
        if (canciones.size() == 0) {
            System.out.println(nombre + " se encuentra vacia");
            return;
        }
        System.out.println("====="+nombre+"=====");
        canciones.mostrarCanciones();
    }

    public void reproducirPlaylist(Scanner sc) {
        if (canciones.size() == 0) {
            System.out.println("No hay canciones para reproducir");
            return;
        }
        for (Cancion c : canciones.getCanciones()) {
            System.out.println("Reproduciendo: " + c);
            System.out.println("Presiona Enter para continuar...");
            sc.nextLine();
        }
        System.out.println("Fin de la playlist");
    }

    public String toString() {
        return id + ".-" + nombre + " (" + canciones.size() + " canciones)";
    }
}
