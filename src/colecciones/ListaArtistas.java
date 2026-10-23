package colecciones;

import modelos.Artista;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import busquedas.*;

public class ListaArtistas {
   private List<Artista> artistas;

   public ListaArtistas(){
       artistas = new ArrayList<>();
    }

   public void agregarArtista(Artista artista){
    artistas.add(artista);
   }

   public void eliminarArtista(Artista artista){
    artistas.remove(artista);
   }

   public int tamanioListaArtistas(){
    return artistas.size();
   }

   public boolean buscarArtista(String nombre){
      
      return BusquedaLineal.busquedaLinealBoolean(artistas, nombre);
   }

   //Obtener artista por nombre (BORRAR COMENTARIO ANTES DE ACABAR EL TRABAJO)
   public Artista getArtista(String nombre){
      
      return BusquedaLineal.busquedaLinealArtista(artistas, nombre);
   }

   //Obtener artista por indice
   public Artista getArtista(int indice){
      return artistas.get(indice);
   }

   public void swapArtista(int i, int j){
      Collections.swap(artistas,i,j);
   }



}
