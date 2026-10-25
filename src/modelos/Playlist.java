package modelos;

import colecciones.ListaCanciones;

import java.util.*;

public class Playlist {

    private int id;
    private String nombre;
    private ListaCanciones canciones;

    public Playlist(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.canciones = new ListaCanciones();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones.getCanciones();
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

    public void mostrarPlaylist() {
        if (canciones.size() == 0) {
            System.out.println(nombre + " se encuentra vacia");
            return;
        }
        System.out.println(nombre);
        for (Cancion c : canciones.getCanciones()) {
            System.out.println(c);
        }
    }

    public void reproducirPlaylist() {
        if (canciones.size() == 0) {
            System.out.println("No hay canciones para reproducir");
            return;
        }
        Scanner sc = new Scanner(System.in);
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
