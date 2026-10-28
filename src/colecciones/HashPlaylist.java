package colecciones;
import modelos.Playlist;

import java.util.ArrayList;
public class HashPlaylist {
    private ArrayList<ArrayList<Playlist>> tabla;
    private int capacidad;

    public HashPlaylist(int capacidad) {
        if (capacidad <= 0) {
            System.out.println("La capacidad debe ser mayor que cero");
            this.capacidad = 10;
        } else {
            this.capacidad = capacidad;
        }

        tabla = new ArrayList<>();

        for (int i = 0; i < this.capacidad; i++) {
            tabla.add(new ArrayList<Playlist>());
        }
    }


    public int funcionHash(int id){
        if(id < 0){
            System.out.println("El ID no puede ser negativo");
            return -1;
        }
        return id % capacidad;
    }

    public boolean insertar(Playlist playlist){
        if(playlist == null || playlist.getId() < 0){
            return false;
        }

        int index = funcionHash(playlist.getId());

        for(Playlist actual : tabla.get(index)){
            if (actual.getId() == playlist.getId()){
                return false;
            }
        }

        tabla.get(index).add(playlist);
        return true;
    }

    public Playlist buscar(int id) {
        if (id < 0) {
            System.out.println("Ingresa un ID válido");
            return null;
        }

        int index = funcionHash(id);

        for(Playlist playlist : tabla.get(index)){
            if (playlist.getId() == id){
                return playlist;
            }
        }

        return null;
    }

    public boolean eliminar(int id){
        if(id < 0){
            System.out.println("Ingresa un ID válido");
            return false;
        }

        int index = funcionHash(id);

        for (int i = 0; i < tabla.get(index).size(); i++) {
            if (tabla.get(index).get(i).getId() == id) {
                tabla.get(index).remove(i);
                return true;
            }
        }

        return false;
    }

    public ArrayList<Playlist> getPlaylists(){
        ArrayList<Playlist> playlists = new ArrayList<>();
        for (ArrayList<Playlist> grupo : tabla) {
            playlists.addAll(grupo);
        }
        return playlists;
    }

    public void mostrarPlaylists(){
        if (getPlaylists().isEmpty()) {
            System.out.println("No hay playlists registradas");
            return;
        }
        System.out.println("=====PlayList Creadas=====");
        for (Playlist playlist : getPlaylists()) {
            playlist.mostrarPlaylist();
            System.out.println("=====================");
        }
    }

    public boolean isEmpty(){
        for(ArrayList<Playlist> playlist: tabla){
            if(playlist.isEmpty()){
                return true;
            }
        }
        return false;
    }

}
