package opciones;

import busquedas.BusquedaBinaria;
import colecciones.HashPlaylist;
import modelos.Playlist;
import ordenamientos.MergeSort;
import java.util.List;
import busquedas.BusquedaLineal;
import colecciones.ListaArtistas;
import colecciones.ListaCanciones;
import modelos.Artista;
import modelos.Cancion;
import utilidades.Menus;
import utilidades.Utilidades;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class OpcionesCanciones {
    public static void ejecutar(ListaCanciones canciones, ListaArtistas artistas, HashPlaylist playlists, Scanner entrada){
        int opcion;

        do{
            Menus.mostrarMenuCanciones();
            opcion = Utilidades.leerEntero(entrada);
            switch (opcion){
                case 1 -> {
                    agregarCancion(canciones, artistas, entrada);
                }
                case 2 -> {
                    eliminarCancion(canciones, playlists, entrada);
                }
                case 3 -> {
                    canciones.mostrarCanciones();
                }
                case 4 -> {
                    ordenar(canciones, entrada);
                }
                case 5 -> {
                    busquedaLineal(canciones, entrada);
                }
                case 6 -> {
                    busquedaBinaria(canciones, entrada);
                }
                case 7 -> {
                    buscarPorId(canciones, entrada);
                }
                case 8 -> {
                    System.out.println("Regresando");
                }
                default -> {
                    System.out.println("Ingresa una opción válida!");
                }
            }
        }while(opcion != 8);

    }

    public static void agregarCancion(ListaCanciones canciones, ListaArtistas artistas, Scanner entrada){
        System.out.print("Ingresa el nombre de la canción: ");
        String nombre = Utilidades.leerTexto(entrada);

        System.out.print("Ingresa el nombre del artista: ");
        String nombreArtista = Utilidades.leerTexto(entrada);

        Artista artista = BusquedaLineal.busquedaLinealArtista(artistas, nombreArtista);

        if(artista == null){
            System.out.println("No se encontró el artista.");
            System.out.println("¿Desea agregar uno? \n 1. Si \n 2. No \n Ingresa una opción: ");

            int opcion = Utilidades.leerEntero(entrada);

            if(opcion == 1){
                artista = OpcionesArtistas.agregarArtista(artistas,entrada);

                if(artista == null){
                    System.out.println("No se pudo agregar al artista");
                    return;
                }

            } else{
                System.out.println("Regresando...");
                return;
            }
        }

        Cancion cancion = new Cancion(nombre, artista);

        if(canciones.insertar(cancion)){
            System.out.println("La canción se agregó exitosamente!");
            artista.addCancion(cancion);
        }else{
            System.out.println("No se pudo agregar la canción");
        }
    }


    public static void eliminarCancion(ListaCanciones canciones, HashPlaylist playlists, Scanner entrada) {

        System.out.print("Ingresa el nombre de la canción: ");
        String nombre = Utilidades.leerTexto(entrada);

        ListaCanciones coincidencias =
                BusquedaLineal.busquedaLinealCancion(canciones, nombre);

        if (coincidencias.getCanciones().isEmpty()) {
            System.out.println("La canción no existe");
            return;
        }

        System.out.println("Coincidencias de la búsqueda:");
        coincidencias.mostrarCanciones();

        System.out.print("Ingresa el ID de la canción que deseas eliminar: ");
        int id = Utilidades.leerEntero(entrada);

        if (!BusquedaLineal.busquedaLinealID(coincidencias, id)) {
            System.out.println("ID inválido");
            return;
        }

        Cancion cancion = canciones.buscar(id);

        if (canciones.eliminar(id)) {

            cancion.getArtista().removeCancion(cancion);

            for (Playlist p : playlists.getPlaylists()) {
                p.removeCancion(cancion);
            }

            System.out.println("¡Canción eliminada exitosamente!");
        } else {
            System.out.println("No se puede eliminar la canción");
        }
    }


    public static void busquedaLineal(ListaCanciones canciones, Scanner entrada) {
        if (canciones.estaVacio()) {
            System.out.println("No hay canciones registradas");
            return;
        }
        System.out.print("Ingresa el nombre de la canción: ");
        ListaCanciones coincidencias = BusquedaLineal.busquedaLinealCancion(canciones, Utilidades.leerTexto(entrada));
        if (coincidencias.estaVacio()) {
            System.out.println("No se encontró la canción");
        } else {
            coincidencias.mostrarCanciones();
        }
    }

    public static void buscarPorId(ListaCanciones canciones, Scanner entrada) {
        if (canciones.estaVacio()) {
            System.out.println("No hay canciones registradas");
            return;
        }
        System.out.print("Ingresa el ID de la canción: ");
        Cancion cancion = canciones.buscar(Utilidades.leerEntero(entrada));
        System.out.println(cancion == null ? "No se encontró la canción" : cancion);
    }

    public static void ordenar(ListaCanciones canciones, Scanner entrada) {
        ordenar(canciones, entrada, false);
    }

    public static void ordenar(ListaCanciones canciones, Scanner entrada, boolean guardarOrden) {
        if (canciones.estaVacio()) {
            System.out.println("No hay canciones para ordenar");
            return;
        }
        int opcion;

        do {
            Menus.mostrarMenuOrdenarCanciones();
            opcion = Utilidades.leerEntero(entrada);

            if (opcion >= 1 && opcion <= 6) {

                List<Cancion> copia = guardarOrden ? canciones.getCanciones() : new ArrayList<>(canciones.getCanciones());

                Comparator<Cancion> criterio = switch (opcion) {
                    case 1 -> (a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre());
                    case 2 -> (a, b) -> b.getNombre().compareToIgnoreCase(a.getNombre());
                    case 3 -> (a, b) -> a.getArtista().getNombre().compareToIgnoreCase(b.getArtista().getNombre());
                    case 4 -> (a, b) -> b.getArtista().getNombre().compareToIgnoreCase(a.getArtista().getNombre());
                    case 5 -> Comparator.comparingInt(Cancion::getId);
                    case 6 -> Comparator.comparingInt(Cancion::getId).reversed();
                    default -> Comparator.comparingInt(Cancion::getId);
                };
                MergeSort.mergeSort(copia, criterio);

                System.out.println("Canciones ordenadas:");
                for (Cancion cancion : copia) {
                    System.out.println(cancion);
                }

            } else if (opcion == 7) {
                System.out.println("Regresando...");
            } else {
                System.out.println("Opción inválida");
            }

        } while (opcion != 7);
    }

    public static void busquedaBinaria(ListaCanciones canciones, Scanner entrada){
        if(canciones.size() == 0){
            System.out.println("No hay canciones registradas");
            return;
        }

        ArrayList<Cancion> copia = new ArrayList<>(canciones.getCanciones());

        System.out.print("Ingresa el nombre de la canción: ");
        String nombre = Utilidades.leerTexto(entrada);

        MergeSort.mergeSort(copia, (a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
        List<Cancion> coincidencias = BusquedaBinaria.busquedaBinaria(copia, Cancion::getNombre, nombre);

        if(coincidencias.isEmpty()){
            System.out.println("No se encontró la canción");
        }else{
            System.out.println("Canciones encontradas:");
            for(Cancion cancion : coincidencias){
            System.out.println(cancion);
            }
        }
    }
}
