package utilidades;

import java.util.Scanner;

public class Utilidades {
    public static int leerEntero(Scanner entrada){
        int entero = entrada.nextInt();
        entrada.nextLine();
        return entero;
    }
}
