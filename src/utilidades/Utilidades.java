package utilidades;

import java.util.Scanner;

import colecciones.HashPlaylist;
import opciones.*;

public class Utilidades {
    public static int leerEntero(Scanner entrada){
        int entero = entrada.nextInt();
        entrada.nextLine();
        return entero;
    }

    public static int seleccionarIdPlayList(HashPlaylist playlist, Scanner entrada){
        int id=Utilidades.leerEntero(entrada);

        while(playlist.buscar(id)==null && id!=-1){
            System.out.println("Ingrese un ID valido o presione -1 para salir");
            id=Utilidades.leerEntero(entrada);
        }
        if(id==-1){
            System.out.println("Regresando...");
        }
        return id;
    }
    


}
