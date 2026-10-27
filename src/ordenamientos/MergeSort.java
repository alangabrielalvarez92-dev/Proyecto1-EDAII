package ordenamientos;

import modelos.Cancion;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void mergeSort(List<Cancion> lista, int opcion) {
        if (opcion < 1 || opcion > 6) {
            System.out.println("Opción de ordenamiento inválida");
            return;
        }

        mergeSort(lista, 0, lista.size() - 1, opcion);
    }

    private static void mergeSort(List<Cancion> lista, int inicio, int fin, int opcion) {
        if (inicio < fin) {
            int mid = (inicio + fin) / 2;

            mergeSort(lista, inicio, mid, opcion);
            mergeSort(lista, mid + 1, fin, opcion);

            merge(lista, inicio, mid, fin, opcion);
        }
    }

    private static void merge(List<Cancion> lista, int inicio, int mid, int fin, int opcion) {

        ArrayList<Cancion> izq = new ArrayList<>();
        ArrayList<Cancion> der = new ArrayList<>();

        for (int i = inicio; i <= mid; i++) {
            izq.add(lista.get(i));
        }

        for (int i = mid + 1; i <= fin; i++) {
            der.add(lista.get(i));
        }

        int i = 0, j = 0, k = inicio;

        while (i < izq.size() && j < der.size()) {

            if (comparar(izq.get(i), der.get(j), opcion)) {
                lista.set(k, izq.get(i));
                i++;
            } else {
                lista.set(k, der.get(j));
                j++;
            }
            k++;
        }

        while (i < izq.size()) {
            lista.set(k, izq.get(i));
            i++;
            k++;
        }

        while (j < der.size()) {
            lista.set(k, der.get(j));
            j++;
            k++;
        }
    }

    private static boolean comparar(Cancion a, Cancion b, int opcion) {

        switch (opcion) {
            case 1: // Nombre ascendente
                return a.getNombre().compareToIgnoreCase(b.getNombre()) <= 0;

            case 2: // Nombre descendente
                return a.getNombre().compareToIgnoreCase(b.getNombre()) >= 0;

            case 3: // ID ascendente
                return a.getId() <= b.getId();

            case 4: // ID descendente
                return a.getId() >= b.getId();

            case 5: // Artista ascendente
                return a.getArtista().getNombre()
                        .compareToIgnoreCase(b.getArtista().getNombre()) <= 0;

            case 6: // Artista descendente
                return a.getArtista().getNombre()
                        .compareToIgnoreCase(b.getArtista().getNombre()) >= 0;

            default:
                return false;
        }
    }
}
