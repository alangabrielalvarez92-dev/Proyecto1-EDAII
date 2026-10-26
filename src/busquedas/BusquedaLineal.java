package busquedas;
import colecciones.ListaArtistas;
import colecciones.ListaCanciones;
import modelos.*;
import java.util.List;
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

    public static Cancion busquedaLinealCancion(ListaCanciones canciones, String nombre){
        for(Cancion cancion: canciones.getCanciones()){
            if(cancion.getNombre().trim().equalsIgnoreCase(nombre.trim())){
                return cancion;
            }
        }
        return null;
    }

    




}
