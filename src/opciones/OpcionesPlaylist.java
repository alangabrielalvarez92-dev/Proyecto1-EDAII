package opciones;

import utilidades.*;
import colecciones.HashPlaylist;
import colecciones.ListaCanciones;

import java.util.Scanner;

public class OpcionesPlaylist {
    public static void ejecutar(HashPlaylist playlist, Scanner entrada){

    }

    public static void nuevaPlaylist(HashPlaylist playlist,ListaCanciones cancionesGenerales ,Scanner entrada){
        int opcion;
        System.out.println("Ingrese el nombre de su nueva PlayList");
        String nombre = entrada.nextLine();
        /*System.out.println("Ingrese el ID de su PlayList");
        int id=Utilidades.leerEntero(entrada);
        */
        System.out.println("¿Desea agregar canciones?");
        System.out.println("1)Si\n2)No");
        opcion=Utilidades.leerEntero(entrada);

        while(opcion!=1 && opcion!=2){
            System.out.println("Ingrese un valor valido");
            opcion=Utilidades.leerEntero(entrada);
        }
        if(opcion==1){
            if(!cancionesGenerales.estaVacio()){
                System.out.println("No ha registrado todavía ninguna canción");
                System.out.println("Por favor registre al menos una");
            }
            else{
                System.out.println("Las canciones disponibles son:");

            }
        }


    }






}
