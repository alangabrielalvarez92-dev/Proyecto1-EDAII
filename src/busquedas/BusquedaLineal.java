package busquedas;
import colecciones.ListaArtistas;
import colecciones.ListaCanciones;
import modelos.*;
import java.util.*;
import java.util.function.Function;

import java.util.ArrayList;

public class BusquedaLineal {

    public static boolean busquedaLinealBoolean(ListaArtistas artistas, String nombre){
        for(Artista artista: artistas.getArtistas()){
         if(artista.getNombre().trim().equalsIgnoreCase(nombre.trim())){
            return true;
         }
      }
      return false;
    }

    public static Artista busquedaLinealArtista(ListaArtistas artistas,String nombre){
        for(Artista artista: artistas.getArtistas()){
         if(artista.getNombre().trim().equalsIgnoreCase(nombre.trim())){
            return artista;
         }
      }
      return null;
    }

    public static ListaCanciones busquedaLinealCancion(ListaCanciones canciones, String nombre){
        ListaCanciones coincidencias = new ListaCanciones();
        for(Cancion cancion: canciones.getCanciones()){
            if(cancion.getNombre().trim().equalsIgnoreCase(nombre.trim())){
                coincidencias.insertar(cancion);
            }
        }
        return coincidencias;
    }

    public static boolean busquedaLinealID(ListaCanciones canciones, int id){
        for(Cancion cancion: canciones.getCanciones()){
            if(cancion.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static <T> List<T> busquedaLineal(List<T> lista, T buscado, Comparator<T> criterio) {
        List<T> coincidencias = new ArrayList<>();

        for (T elemento : lista) {
            if (criterio.compare(elemento, buscado) == 0) {
                coincidencias.add(elemento);
            }
        }

        return coincidencias;
    }



    




}
