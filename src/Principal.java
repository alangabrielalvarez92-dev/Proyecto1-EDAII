import colecciones.HashPlaylist;
import colecciones.ListaArtistas;
import colecciones.ListaCanciones;
import opciones.OpcionesArtistas;
import opciones.OpcionesCanciones;
import opciones.OpcionesPlaylist;
import utilidades.Menus;
import utilidades.Utilidades;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        HashPlaylist playlists = new HashPlaylist(15);
        ListaArtistas artistas = new ListaArtistas();
        ListaCanciones canciones = new ListaCanciones();

        int opcion;
        Menus.mostrarBanner();

        do{
            Menus.mostrarMenuPrincipal();
            opcion = Utilidades.leerEntero(entrada);
            switch (opcion){
                case 1 ->{
                    OpcionesCanciones.ejecutar(canciones,artistas,entrada);
                }
                case 2 ->{
                    OpcionesArtistas.ejecutar(artistas,entrada);
                }
                case 3 ->{
                    OpcionesPlaylist.ejecutar(playlists,entrada);
                }
                case 4 ->{
                    System.out.println("Saliendo de SpotiFI");
                }
                default -> {
                    System.out.println("Ingresa una opción válida!");
                }
            }
        }while(opcion != 4);

    }
}
