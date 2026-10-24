package busquedas;
import modelos.*;
import java.util.List;
import java.util.ArrayList;

public class BusquedaLineal {

    public static boolean busquedaLinealBoolean(List<Artista> artistas,String nombre){
        for(Artista artista: artistas){
         if(artista.getNombre().equals(nombre)){
            return true;
         }
      }
      return false;
    }

    public static Artista busquedaLinealArtista(List<Artista> artistas,String nombre){
        for(Artista artista: artistas){
         if(artista.getNombre().equals(nombre)){
            return artista;
         }
      }
      return null;
    }

    




}
