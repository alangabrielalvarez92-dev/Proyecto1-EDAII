package opciones;

import utilidades.*;
import colecciones.HashPlaylist;
import colecciones.ListaCanciones;
import modelos.Cancion;
import modelos.Playlist;

import java.util.Scanner;

import busquedas.BusquedaLineal;

public class OpcionesPlaylist {
    public static void ejecutar(HashPlaylist playlist, Scanner entrada){

    }

    public static void nuevaPlaylist(HashPlaylist playlist,ListaCanciones cancionesGenerales ,Scanner entrada){
        int opcion;
        System.out.println("Ingrese el nombre de su nueva PlayList");
        String nombre = entrada.nextLine();
        Playlist newPlaylist = new Playlist(nombre);
        System.out.println("El ID asignado para su PlayList es: "+newPlaylist.getId());
        System.out.println("Anote dicho ID para busquedas futuras");
        playlist.insertar(newPlaylist);

        System.out.println("¿Desea agregar canciones?");
        System.out.println("1)Si\n2)No");
        opcion=Utilidades.leerEntero(entrada);

        while(opcion!=1 && opcion!=2){
            System.out.println("Ingrese un valor valido");
            opcion=Utilidades.leerEntero(entrada);
        }
        if(opcion==1){
            cicloAgregarCanciones(playlist, cancionesGenerales, entrada, newPlaylist.getId());
        }

    }

    public static void agregarCancionesPlayList(HashPlaylist playlist, ListaCanciones cancionesGenerales, Scanner entrada){
        System.out.println("Ingrese el ID de su PlayList");
        int id= Utilidades.leerEntero(entrada);
        while(playlist.buscar(id)==null && id!=-1){
            System.out.println("Ingrese un ID valido o presione -1 para salir");
            id=Utilidades.leerEntero(entrada);
        }
        if(id==-1){
            return;
        }
        cicloAgregarCanciones(playlist, cancionesGenerales, entrada, id);

    }

    public static void cicloAgregarCanciones(HashPlaylist playlist, ListaCanciones cancionesGenerales, Scanner entrada, int id){
        int opcion=0;
        if(cancionesGenerales.estaVacio()){
                System.out.println("No ha registrado todavía ninguna canción");
                System.out.println("Por favor registre al menos una");
            }
        else{
        while(opcion!=2){
            agregarCancion(playlist, cancionesGenerales, entrada, id);
            System.out.println("Desea ingresar otra canción?");
            System.out.println("1)Si\n2)No");
            opcion=Utilidades.leerEntero(entrada);
            while(opcion!=2 && opcion!=1){
                System.out.println("Ingrese un valor valido");
                opcion=Utilidades.leerEntero(entrada);
            }
        }
        }

    }

    public static void agregarCancion(HashPlaylist playlist, ListaCanciones cancionesGenerales, Scanner entrada, int id){
        int opcion;
        if(cancionesGenerales.estaVacio()){
                System.out.println("No ha registrado todavía ninguna canción");
                System.out.println("Por favor registre al menos una");
            }
        /*if(playlist.buscar(id)==null){
            System.out.println("No se encontró la PlayList");
        }*/
        else{
            cancionesGenerales.mostrarCanciones();

            System.out.println("Agregar canción por:\n1)Nombre\n2)ID");
            opcion= Utilidades.leerEntero(entrada);

            while(opcion!=1 && opcion!=2){
                System.out.println("Ingrese una opción valida");
                opcion= Utilidades.leerEntero(entrada);    
            }
            
            if(opcion==1){
                System.out.println("Ingrese el nombre de la canción");
                System.out.println("Escriba tal y como aparece en la lista");
                String nombre= entrada.nextLine();
                Cancion newCancion = BusquedaLineal.busquedaLinealCancion(cancionesGenerales, nombre);   
                if(newCancion!=null){
                    playlist.buscar(id).addCancion(newCancion);
                }
                else{
                    System.out.println("No se encontró la canción buscada");
                }
            }
            else{
                System.out.println("Ingrese el ID de su canción");
                int idCancion= Utilidades.leerEntero(entrada);
                Cancion newCancion= cancionesGenerales.buscar(idCancion);
                if(newCancion!=null){
                    playlist.buscar(id).addCancion(newCancion);
                }
                else{
                    System.out.println("No se encontró la canción buscada");
                }
            }

        }
    }




}
