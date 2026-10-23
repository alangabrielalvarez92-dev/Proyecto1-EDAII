package modelos;

import java.util.*;

public class Playlist {

    private int id;
    private String nombre;
    private List<Cancion> canciones;

    public Playlist(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void addCancion(Cancion c) {
        if (canciones.contains(c)) {
            System.out.println("Esta cancion no se puede agregar porque ya existe en la playlist.");
        } else {
            canciones.add(c);
        }
    }

    public void removeCancion(Cancion c) {
        canciones.remove(c);
    }

    public void mostrarPlaylist() {
        if (canciones.isEmpty()) {
            System.out.println(nombre + " se encuentra vacia");
            return;
        }
        System.out.println(nombre);
        for (Cancion c : canciones) {
            System.out.println(c);
        }
    }

    public void reproducirPlaylist() {
        if (canciones.isEmpty()) {
            System.out.println("No hay canciones para reproducir");
            return;
        }
        Scanner sc = new Scanner(System.in);
        for (Cancion c : canciones) {
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
