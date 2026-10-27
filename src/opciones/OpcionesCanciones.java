package opciones;

import busquedas.BusquedaBinaria;
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
    public static void ejecutar(ListaCanciones canciones, ListaArtistas artistas, Scanner entrada){
        int opcion;

        do{
            Menus.mostrarMenuCanciones();
            opcion = Utilidades.leerEntero(entrada);
            switch (opcion){
                case 1 -> {
                    agregarCancion(canciones, artistas, entrada);
                }
                case 2 -> {
                    eliminarCancion(canciones, entrada);
                }
                case 3 -> {
                    canciones.mostrarCanciones();
                }
                case 4 -> {
                    ordenar(canciones, entrada);
                }
                case 5 -> {}
                case 6 -> {
                    busquedaBinaria(canciones, entrada);
                }
                case 7 -> {}
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
        String nombre = entrada.nextLine();

        System.out.print("Ingresa el nombre del artista: ");
        String nombreArtista = entrada.nextLine();

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

        if(canciones.insertar(new Cancion(nombre, artista))){
            System.out.println("La canción se agregó exitosamente!");
        }else{
            System.out.println("No se pudo agregar la canción");
        }
    }

    public static void eliminarCancion(ListaCanciones canciones, Scanner entrada){
        System.out.print("Ingresa el nombre de la canción: ");
        String nombre = entrada.nextLine();

        ListaCanciones coincidencias = BusquedaLineal.busquedaLinealCancion(canciones, nombre);

        if(coincidencias.getCanciones().isEmpty()){
            System.out.println("La canción no existe");
            return;
        }

        System.out.println("Coincidencias de la búsqueda:");
        canciones.mostrarCanciones();

        System.out.print("Ingresa el ID de la canción que deseas eliminar: ");
        int id = Utilidades.leerEntero(entrada);

        if (!BusquedaLineal.busquedaLinealID(coincidencias, id)) {
            System.out.println("ID inválido");
            return;
        }

        if(canciones.eliminar(id)){
            System.out.println("Canción eliminada exitosamente!");
        }

        System.out.println("No se puedo eliminar la canción");

    }

    public static void ordenar(ListaCanciones canciones, Scanner entrada) {
        int opcion;

        do {
            Menus.mostrarMenuOrdenarCanciones();
            opcion = Utilidades.leerEntero(entrada);

            if (opcion >= 1 && opcion <= 6) {

                ArrayList<Cancion> copia = new ArrayList<>(canciones.getCanciones());

                Comparator<Cancion> criterio = switch (opcion) {
                    case 1 -> Comparator.comparing(Cancion::getNombre, String.CASE_INSENSITIVE_ORDER);
                    case 2 -> Comparator.comparing(Cancion::getNombre, String.CASE_INSENSITIVE_ORDER).reversed();
                    case 3 -> Comparator.comparing((Cancion c) -> c.getArtista().getNombre(), String.CASE_INSENSITIVE_ORDER);
                    case 4 -> Comparator.comparing((Cancion c) -> c.getArtista().getNombre(), String.CASE_INSENSITIVE_ORDER).reversed();
                    case 5 -> Comparator.comparingInt(Cancion::getId);
                    case 6 -> Comparator.comparingInt(Cancion::getId).reversed();
                    default -> throw new IllegalArgumentException("Opción de ordenamiento inválida");
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

    System.out.print("Ingresa el nombre de la canción: ");
    String nombre = entrada.nextLine();

    MergeSort.mergeSort(canciones.getCanciones(), (a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
    List<Cancion> resultado = BusquedaBinaria.busquedaBinaria(canciones.getCanciones(), c -> c.getNombre(), nombre);

    if(resultado.isEmpty()){
        System.out.println("No se encontró la canción");
    }else{
        System.out.println("Canciones encontradas:");
        for(Cancion c : resultado){
            System.out.println(c);
        }
    }
    }

}
