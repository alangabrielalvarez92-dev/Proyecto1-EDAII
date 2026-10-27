package busquedas;

import java.util.*;
import java.util.function.Function;

public class BusquedaBinaria {

    public static <T> List<T> busquedaBinaria(List<T> lista, Function<T, String> campo, String clave) {
        List<T> encontrados = new ArrayList<>();
        int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio <= fin) {
            int mid = (inicio + fin) / 2;
            int comparacion = campo.apply(lista.get(mid)).compareToIgnoreCase(clave);

            if (comparacion == 0) {
                int izq = mid;
                while (izq > 0 && campo.apply(lista.get(izq - 1)).equalsIgnoreCase(clave)) {
                    izq--;
                }
                int der = mid;
                while (der < lista.size() - 1 && campo.apply(lista.get(der + 1)).equalsIgnoreCase(clave)) {
                    der++;
                }
                for (int i = izq; i <= der; i++) {
                    encontrados.add(lista.get(i));
                }
                return encontrados;
            } else if (comparacion < 0) {
                inicio = mid + 1;
            } else {
                fin = mid - 1;
            }
        }
        return encontrados;
    }
}