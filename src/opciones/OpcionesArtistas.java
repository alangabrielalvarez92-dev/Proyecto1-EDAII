package opciones;

import colecciones.*;
import modelos.*;
import java.util.*;
import ordenamientos.*;
import utilidades.*;

public class OpcionesArtistas {
    public static void ejecutar(ListaArtistas artistas, ListaCanciones canciones, HashPlaylist playlists, Scanner entrada){
        int opcion;

        do{
            Menus.mostrarMenuArtistas();
            opcion = Utilidades.leerEntero(entrada);
            switch (opcion){
                case 1 -> {
                    nuevoArtista(artistas, entrada);
                }
                case 2 -> {
                    eliminarArtista(artistas, canciones, playlists, entrada);
                }
                case 3 -> {
                    artistas.mostrarArtistas();
                }
                case 4 -> {
                    ordenarArtistas(artistas, entrada);
                }
                case 5 -> {
                    buscarArtistaYMostrar(artistas, entrada);
                }
                case 6 -> {
                    System.out.println("Regresando al menú de inicio");
                }
                default -> {
                    System.out.println("Ingresa una opción válida!");
                }
            }
        }while(opcion != 6);
    }

    public static Artista agregarArtista(ListaArtistas artistas, Scanner entrada) {
        System.out.print("Nombre del artista: ");
        String nombre = entrada.nextLine();

        System.out.print("Género musical: ");
        String genero = entrada.nextLine();

        Artista artista = new Artista(nombre, genero);

        if (artistas.agregarArtista(artista)) {
            return artista;
        }

        return null;
    }

    public static void nuevoArtista(ListaArtistas artistas, Scanner entrada){
        Artista artista = agregarArtista(artistas, entrada);

        if(artista != null){
            System.out.println("El artista se agregó exitosamente!");
        }else{
            System.out.println("No se pudo agregar: el nombre está vacío o el artista ya existe");
        }
    }

    public static void eliminarArtista(ListaArtistas artistas, ListaCanciones canciones, HashPlaylist playlists, Scanner entrada){
        System.out.print("Nombre del artista a eliminar: ");
        String nombre = entrada.nextLine();

        Artista artista = artistas.buscarArtista(nombre);

        if(artista == null){
            System.out.println("No se encontró el artista");
            return;
        }

        int total = artista.getCanciones().size();

        if(total > 0){
            System.out.println("El artista tiene " + total + " canciones y también se eliminarán.");
            System.out.println("¿Deseas continuar? \n 1. Si \n 2. No");
            System.out.print("Ingresa una opción: ");
            int confirmacion = Utilidades.leerEntero(entrada);

            if(confirmacion != 1){
                System.out.println("Operación cancelada");
                return;
            }
        }

        for(Cancion c : new ArrayList<>(artista.getCanciones())){
            canciones.eliminar(c.getId());
            for(Playlist p : playlists.getPlaylists()){
                p.removeCancion(c);
            }
        }

        artistas.eliminarArtista(artista);
        System.out.println("Artista eliminado junto con " + total + " canciones");
    }

    public static void ordenarArtistas(ListaArtistas artistas, Scanner entrada){
        if(artistas.size() == 0){
            System.out.println("La lista de artistas esta vacia");
            return;
        }

        System.out.println("1.- Por nombre (QuickSort)");
        System.out.println("2.- Por género (MergeSort)");
        System.out.print("Ingresa una opción: ");
        int tipo = Utilidades.leerEntero(entrada);

        switch (tipo){
            case 1 -> QuickSort.quickSort(artistas, 0, artistas.size() - 1);
            case 2 -> MergeSort.mergeSort(artistas.getArtistas(), (a, b) -> a.getGenero().compareToIgnoreCase(b.getGenero()));
            default -> {
                System.out.println("Opción no válida");
                return;
            }
        }

        artistas.mostrarArtistas();
    }

    public static void buscarArtistaYMostrar(ListaArtistas artistas, Scanner entrada){
        System.out.print("Nombre del artista: ");
        String nombre = entrada.nextLine();

        Artista artista = artistas.buscarArtista(nombre);

        if(artista == null){
            System.out.println("No se encontró el artista");
            return;
        }

        System.out.println(artista);
        artista.mostrarCanciones();
    }
}