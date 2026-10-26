package opciones;

import colecciones.ListaArtistas;
import modelos.Artista;
import java.util.Scanner;

public class OpcionesArtistas {
    public static void ejecutar(ListaArtistas artistas, Scanner entrada){

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
}
