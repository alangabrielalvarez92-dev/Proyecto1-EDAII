package utilidades;

public class Menus {
    public static void mostrarBanner() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                                                       |");
        System.out.println("|                            _     _   _____   ___      |");
        System.out.println("|      ___   _ __     ___   | |_  (_) |  ___| |_ _|     |");
        System.out.println("|     / __| | '_ \\   / _ \\  | __| | | | |_     | |      |");
        System.out.println("|     \\__ \\ | |_) | | (_) | | |_  | | |  _|    | |      |");
        System.out.println("|     |___/ | .__/   \\___/   \\__| |_| |_|     |___|     |");
        System.out.println("|           |_|                                         |");
        System.out.println("|                                                       |");
        System.out.println("|    Reproductor de musica  *  EDA II  *  Equipo 07     |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|            |       | |           |         |          |");
        System.out.println("|        |   | |     | |   |     | |     |   | |        |");
        System.out.println("|        | | | |   | | | | |   | | | |   | | | |        |");
        System.out.println("|      | | | | | | | | | | | | | | | | | | | | | |      |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|   > Reproduciendo:  Tu cancion favorita               |");
        System.out.println("|   01:24 [==============o---------------------] 03:45  |");
        System.out.println("|   [ |<< ]   [ || ]   [ >>| ]   VOL [||||||....]       |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println();
    }

    public static void mostrarMenuPrincipal(){
        System.out.println("=====SpotiFI=====");
        System.out.println("1. Canciones");
        System.out.println("2. Artistas");
        System.out.println("3. Playlists");
        System.out.println("4. Salir de SpotiFI");
        System.out.print("Ingresa una opción: ");
    }

    public static void mostrarMenuCanciones(){
        System.out.println("=====Canciones=====");
        System.out.println("1. Agregar canción");
        System.out.println("2. Eliminar canción");
        System.out.println("3. Mostrar todas las canciones");
        System.out.println("4. Ordenar canciones");
        System.out.println("5. Búsqueda lineal");
        System.out.println("6. Búsqueda binaria");
        System.out.println("7. Buscar canción por ID");
        System.out.println("8. Regresar al menú de inicio");
        System.out.print("Ingresa una opción: ");
    }

    public static void mostrarMenuOrdenarCanciones(){
        System.out.println("=====Ordenar canciones por: ======");
        System.out.println("1. Nombre ascendente");
        System.out.println("2. Nombre descendente");
        System.out.println("3. Artista ascendente");
        System.out.println("4. Artista descendente");
        System.out.println("5. ID ascendente");
        System.out.println("6. ID descendente");
        System.out.println("7. Regresar");
        System.out.print("Ingresa una opción: ");
    }

    public static void mostrarMenuArtistas(){
        System.out.println("=====Artistas=====");
        System.out.println("1. Agregar artista");
        System.out.println("2. Eliminar artista");
        System.out.println("3. Mostrar artistas");
        System.out.println("4. Ordenar artistas");
        System.out.println("5. Buscar artista y mostrar sus canciones");
        System.out.println("6. Regresar al menú de inicio");
        System.out.print("Ingresa una opción: ");
    }

    public static void mostrarMenuPlaylist(){
        System.out.println("=====Playlist=====");
        System.out.println("1. Nueva Playlist");
        System.out.println("2. Eliminar Playlist");
        System.out.println("3. Mostrar Playlists");
        System.out.println("4. Agregar canciones a Playlist");
        System.out.println("5. Eliminar canción de la Playlist");
        System.out.println("6. Mostrar canciones de la Playlist");
        System.out.println("7. Ordenar canciones de la Playlist");
        System.out.println("8. Buscar canción en la Playlist");
        System.out.println("9. Reproducir Playlist");
        System.out.println("10. Regresar al menú de inicio.");
    }
}
