package ordenamientos;

import java.util.*;

public class MergeSort {

    public static <T> void mergeSort(List<T> lista, Comparator<T> c) {
        mergeSort(lista, c, 0, lista.size() - 1);
    }

    private static <T> void mergeSort(List<T> lista, Comparator<T> c, int inicio, int fin) {
        if (inicio < fin) {
            int mid = (inicio + fin) / 2;
            mergeSort(lista, c, inicio, mid);
            mergeSort(lista, c, mid + 1, fin);
            merge(lista, c, inicio, mid, fin);
        }
    }

    private static <T> void merge(List<T> lista, Comparator<T> c, int inicio, int mid, int fin) {

        ArrayList<T> izq = new ArrayList<>();
        ArrayList<T> der = new ArrayList<>();
        for (int i = inicio; i <= mid; i++) {
            izq.add(lista.get(i));
        }
        for (int i = mid + 1; i <= fin; i++) {
            der.add(lista.get(i));
        }

        int i = 0, j = 0, k = inicio;
        while (i < izq.size() && j < der.size()) {

            if (c.compare(izq.get(i), der.get(j)) <= 0) {
                lista.set(k, izq.get(i));
                i++;
            } else {
                lista.set(k, der.get(j));
                j++;
            }
            k++;
        }

        while (i<izq.size()) {
            lista.set(k, izq.get(i));
            i++;
            k++;
        }while (j<der.size()){
            lista.set(k, der.get(j));
            j++;
            k++;
        }


    }
}
