package utilidades;

import java.util.Scanner;
import colecciones.HashPlaylist;

public class Utilidades {
    public static int leerEntero(Scanner entrada) {
        while (true) {
            String texto = entrada.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número entero válido: ");
            }
        }
    }

    public static String leerTexto(Scanner entrada) {
        while (true) {
            String texto = entrada.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.print("El texto no puede estar vacío. Intenta de nuevo: ");
        }
    }

    public static int seleccionarIdPlayList(HashPlaylist playlist, Scanner entrada) {
        int id = leerEntero(entrada);
        while (id != -1 && playlist.buscar(id) == null) {
            System.out.println("Ingrese un ID válido o -1 para salir");
            id = leerEntero(entrada);
        }
        if (id == -1) {
            System.out.println("Regresando...");
        }
        return id;
    }
}
