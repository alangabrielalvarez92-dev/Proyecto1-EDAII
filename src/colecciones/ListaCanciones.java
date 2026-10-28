package colecciones;

import modelos.Cancion;

import java.util.ArrayList;

public class ListaCanciones {
    private ArrayList<Cancion> canciones;

    public ListaCanciones(){
        canciones = new ArrayList<>();
    }

    public boolean insertar(Cancion cancion){
        if (cancion == null || cancion.getId() < 0 || buscar(cancion.getId()) != null) {
            return false;
        }
        canciones.add(cancion);
        return true;
    }

    public Cancion buscar(int id){
        if (id < 0) {
            return null;
        }
        for (Cancion cancion : canciones) {
            if (cancion.getId() == id) {
                return cancion;
            }
        }
        return null;
    }

    public boolean eliminar(int id){
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).getId() == id) {
                canciones.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cancion> getCanciones(){
        return canciones;
    }

    

    public Cancion getCancion(int indice){
        return canciones.get(indice);
    }

    public void swapCancion(int i, int j){
        Cancion temporal = canciones.get(i);
        canciones.set(i, canciones.get(j));
        canciones.set(j, temporal);
    }

    public int size(){
        return canciones.size();
    }

    public void mostrarCanciones(){
        if (canciones.isEmpty()) {
            System.out.println("La lista de canciones esta vacia");
            return;
        }
        System.out.println("====Canciones Disponibles====");
        for (Cancion cancion : canciones) {
            System.out.println(cancion.toString());
            System.out.println("-------------------------");
        }
    }

    public boolean estaVacio(){
        return canciones.isEmpty();
    }


}
