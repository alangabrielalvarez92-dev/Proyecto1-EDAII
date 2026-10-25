package colecciones;

import modelos.Artista;

import java.util.ArrayList;

public class ListaArtistas {
    private ArrayList<Artista> artistas;

    public ListaArtistas(){
        artistas = new ArrayList<>();
    }

    public boolean agregarArtista(Artista artista){
        if (artista == null || artista.getNombre() == null || artista.getNombre().trim().isEmpty()) {
            return false;
        }
        if (buscarArtista(artista.getNombre()) != null) {
            return false;
        }
        artistas.add(artista);
        return true;
    }

    public boolean eliminarArtista(String nombre){
        Artista artista = buscarArtista(nombre);
        if (artista == null) {
            return false;
        }
        artistas.remove(artista);
        return true;
    }

    public Artista buscarArtista(String nombre){
        if (nombre == null) {
            return null;
        }
        for (Artista artista : artistas) {
            if (artista.getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                return artista;
            }
        }
        return null;
    }

    public ArrayList<Artista> getArtistas(){
        return artistas;
    }

    public Artista getArtista(int indice){
        return artistas.get(indice);
    }

    public void swapArtista(int i, int j){
        Artista temporal = artistas.get(i);
        artistas.set(i, artistas.get(j));
        artistas.set(j, temporal);
    }

    public int size(){
        return artistas.size();
    }

    public void mostrarArtistas(){
        if (artistas.isEmpty()) {
            System.out.println("La lista de artistas esta vacia");
            return;
        }
        for (Artista artista : artistas) {
            System.out.println(artista);
        }
    }
}
