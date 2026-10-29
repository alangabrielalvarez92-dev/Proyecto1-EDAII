package opciones;

import utilidades.*;
import colecciones.HashPlaylist;
import colecciones.ListaCanciones;
import modelos.Cancion;
import modelos.Playlist;

import java.util.Scanner;

import busquedas.BusquedaLineal;

public class OpcionesPlaylist {
    public static void ejecutar(HashPlaylist playlist, Scanner entrada,ListaCanciones cancionesGenerales){
        int opcion;

        do{
            Menus.mostrarMenuPlaylist();
            opcion=Utilidades.leerEntero(entrada);
            switch(opcion){
                case 1->{
                 nuevaPlaylist(playlist,cancionesGenerales, entrada);
                }
                case 2->{
                    eliminarPlayList(playlist, entrada);
                }
                case 3->{
                    playlist.mostrarPlaylists();
                }
                case 4->{
                    agregarCancionesPlayList(playlist, cancionesGenerales, entrada);
                }
                case 5->{
                    eliminarCancionesPlayList(playlist, entrada);
                }
                case 6->{
                    mostrarCancionesPlayList(playlist, entrada);
                }
                case 7->{
                    ordenarCancionesPlayList(playlist, entrada);
                }
                case 8->{
                    buscarCancionPlayList(playlist, entrada);
                }
                case 9->{
                    reproducirPlayList(playlist, entrada);
                }
                case 10->{
                    System.out.println("Regresando");
                }
                default->{
                    System.out.println("Ingrese una opción válida!");
                }

            }
        }while(opcion!=10);

    }

    public static void nuevaPlaylist(HashPlaylist playlist,ListaCanciones cancionesGenerales ,Scanner entrada){
        int opcion;
        System.out.println("Ingrese el nombre de su nueva PlayList");
        String nombre = Utilidades.leerTexto(entrada);
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
        if(!playlist.isEmpty()){
        System.out.println("Ingrese el ID de su PlayList");
        int id= Utilidades.seleccionarIdPlayList(playlist, entrada);
        if(id==-1){
            return;
        }
        cicloAgregarCanciones(playlist, cancionesGenerales, entrada, id);

    }
    else{
        System.out.println("Aun no se ha creado ninguna Playlist");
    }
    }

    public static void cicloAgregarCanciones(HashPlaylist playlist, ListaCanciones cancionesGenerales, Scanner entrada, int id){
        int opcion=0;
        if(cancionesGenerales.estaVacio()){
                System.out.println("No ha registrado todavía ninguna canción");
                System.out.println("Por favor registre al menos una");
            }
        else{
        while(opcion!=2){
            agregarCancion(playlist, cancionesGenerales, entrada,id);
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

    public static void agregarCancion(HashPlaylist playlist, ListaCanciones cancionesGenerales, Scanner entrada, int idPlayList){
        if(cancionesGenerales.estaVacio()){
                System.out.println("No ha registrado todavía ninguna canción");
                System.out.println("Por favor registre al menos una");
            }
        else{
            cancionesGenerales.mostrarCanciones();
            System.out.print("Ingresa el nombre de la canción: ");
            String nombre = Utilidades.leerTexto(entrada);

        ListaCanciones coincidencias = BusquedaLineal.busquedaLinealCancion(cancionesGenerales, nombre);

        if(coincidencias.getCanciones().isEmpty()){
            System.out.println("La canción no existe");
            return;
        }

        System.out.println("Coincidencias de la búsqueda:");
        coincidencias.mostrarCanciones();

        System.out.print("Ingresa el ID de la canción que deseas agregar: ");
        int id = Utilidades.leerEntero(entrada);

        if (!BusquedaLineal.busquedaLinealID(coincidencias, id)) {
            System.out.println("ID inválido");
            return;
        }
        Cancion newCancion=cancionesGenerales.buscar(id);

        if(playlist.buscar(idPlayList).getCanciones().insertar(newCancion)){
            System.out.println("Canción Agregada exitosamente!");
        }
        else{
            System.out.println("No se pudo agregar: la canción ya está en la playlist");
        }
        }
    }

    public static void eliminarPlayList(HashPlaylist playlist, Scanner entrada){
        if(!playlist.isEmpty()){
        System.out.println("Ingrese el ID de la PlayList que desea borrar");
        int id=Utilidades.seleccionarIdPlayList(playlist, entrada);
        if(id==-1){
            return;
        }
        playlist.eliminar(id);
        System.out.println("PlayList eliminada");
        }
        else{
            System.out.println("No hay ninguna PlayList registrada");
        }


    }

    public static void eliminarCancionesPlayList(HashPlaylist playlist, Scanner entrada){
        if(!playlist.isEmpty()){
        System.out.println("Ingrese el ID de su PlayList");
        int id=Utilidades.seleccionarIdPlayList(playlist, entrada);
        if(id==-1){
            return;
        }
        cicloEliminarCanciones(playlist, entrada, id);
        }
        else{
            System.out.println("Aun no se ha creado ninguna PlayList");
        }


    }

    public static void eliminarCancionPlaylist(HashPlaylist playlist, Scanner entrada, int id){
            playlist.buscar(id).mostrarPlaylist();
           ListaCanciones canciones = playlist.buscar(id).getCanciones();
            if (canciones.estaVacio()) {
                System.out.println("La playlist no tiene canciones");
                return;
            }
            System.out.print("Ingresa el nombre de la canción: ");
            ListaCanciones coincidencias = BusquedaLineal.busquedaLinealCancion(canciones, Utilidades.leerTexto(entrada));
            if (coincidencias.estaVacio()) {
                System.out.println("La canción no existe en esta playlist");
                return;
            }
            coincidencias.mostrarCanciones();
            System.out.print("Ingresa el ID de la canción que deseas quitar: ");
            int idCancion = Utilidades.leerEntero(entrada);
            if (!BusquedaLineal.busquedaLinealID(coincidencias, idCancion)) {
                System.out.println("ID inválido");
                return;
            }
            canciones.eliminar(idCancion);
            System.out.println("Canción retirada de esta playlist");
    }

    public static void cicloEliminarCanciones(HashPlaylist playlist, Scanner entrada, int id){
        int opcion=0;
        if(!playlist.buscar(id).getCanciones().estaVacio()){
        while(opcion!=2 && !playlist.buscar(id).getCanciones().estaVacio()){
            eliminarCancionPlaylist(playlist,entrada, id);
            if (playlist.buscar(id).getCanciones().estaVacio()) {
                System.out.println("La playlist quedó vacía");
                break;
            }
            System.out.println("Desea eliminar otra canción?");
            System.out.println("1)Si\n2)No");
            opcion=Utilidades.leerEntero(entrada);
            while(opcion!=2 && opcion!=1){
                System.out.println("Ingrese un valor valido");
                opcion=Utilidades.leerEntero(entrada);
            }
            }
         }
        else{
            System.out.println("La PlayList no tiene ninguna canción guardada");
        }
        }

    public static void mostrarCancionesPlayList(HashPlaylist playlist, Scanner entrada){
        if(!playlist.isEmpty()){
        System.out.println("Ingrese el ID de la PlayList que desea mostrar");
        int id=Utilidades.seleccionarIdPlayList(playlist, entrada);
        if(id==-1){
            return;
        }
        playlist.buscar(id).mostrarPlaylist();
    } else {
        System.out.println("Aun no se ha creado ninguna playlist");
    }
    }

    public static void ordenarCancionesPlayList(HashPlaylist playlist, Scanner entrada){
        if(!playlist.isEmpty()){
        System.out.println("Ingrese el ID de la PlayList que desea ordenar");
        int id=Utilidades.seleccionarIdPlayList(playlist, entrada);
        if(id==-1){
            return;
        }
        OpcionesCanciones.ordenar(playlist.buscar(id).getCanciones(), entrada, true);
    }

    else{
        System.out.println("Aun no se ha creado ninguna Playlist");
    }

}

    public static void reproducirPlayList(HashPlaylist playlist, Scanner entrada){
      if(!playlist.isEmpty()){
        System.out.println("Ingrese el ID de la PlayList que desea reproducir");
        int id=Utilidades.seleccionarIdPlayList(playlist, entrada);
        if(id==-1){
            return;
        }
        playlist.buscar(id).reproducirPlaylist(entrada);
    }
    else{
        System.out.println("Aun no se ha creado ninguna Playlist");
    }


    }

    public static void buscarCancionPlayList(HashPlaylist playlist, Scanner entrada){
        if(!playlist.isEmpty()){
        System.out.println("Ingrese el ID de la PlayList donde desea buscar");
        int id=Utilidades.seleccionarIdPlayList(playlist, entrada);
        if(id==-1){
            return;
        }
        OpcionesCanciones.busquedaBinaria(playlist.buscar(id).getCanciones(), entrada);

        }
        else{
            System.out.println("Aun no se ha creado ninguna Playlist");
        }
    }

}


