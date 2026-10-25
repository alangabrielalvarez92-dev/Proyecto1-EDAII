package ordenamientos;
import colecciones.*;
import modelos.*;



public class QuickSort {

    //QUICKSORT PARA ARTISTAS
    public static void quickSort(ListaArtistas artistas,int inicio, int fin){
        if(inicio<fin){
            int indice= partition(artistas,inicio,fin);
            quickSort(artistas, inicio, indice-1);
            quickSort(artistas, indice+1, fin); 
        }
    }

    private static int partition(ListaArtistas artistas, int inicio, int fin){
        Artista pivote= artistas.getArtista(fin);
        int i= inicio-1;
        for(int j=inicio; j<=fin-1;j++){
            int comparacion =artistas.getArtista(j).getNombre().compareTo(pivote.getNombre());
            if(comparacion<=0){
                i=i+1;
                artistas.swapArtista(i, j);
            }
        }
        artistas.swapArtista(i+1, fin);
        return i+1;
    }
    
    public static void quickSort(ListaCanciones canciones,int inicio, int fin){
        if(inicio<fin){
            int indice= partition(canciones,inicio,fin);
            quickSort(canciones, inicio, indice-1);
            quickSort(canciones, indice+1, fin); 
        }
    }

    private static int partition(ListaCanciones canciones, int inicio, int fin){
        Cancion pivote= canciones.getCancion(fin);
        int i= inicio-1;
        for(int j=inicio; j<=fin-1;j++){
            int comparacion =canciones.getCancion(j).getNombre().compareTo(pivote.getNombre());
            if(comparacion<=0){
                i=i+1;
                canciones.swapCancion(i, j);
            }
        }
        canciones.swapCancion(i+1, fin);
        return i+1;
    }





}
