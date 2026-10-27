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
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> {
                    busquedaBinaria(canciones, entrada);
                }
                case 7 -> {}
                case 8 -> {}
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

        Cancion cancion = BusquedaLineal.busquedaLinealCancion(canciones, nombre);
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
