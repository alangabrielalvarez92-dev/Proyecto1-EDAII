package colecciones;
import modelos.Cancion;

import java.util.ArrayList;
public class HashCanciones {
    private ArrayList<ArrayList<Cancion>> tabla;
    private int capacidad;

    public HashCanciones(int capacidad) {
        this.capacidad = capacidad;
        tabla = new ArrayList<>();

        for (int i = 0; i < capacidad; i++) {
            tabla.add(new ArrayList<Cancion>());
        }
    }

    public int funcionHash(int id){
        if(id < 0){
            System.out.println("El ID no puede ser negativo");
            return -1;
        }
        return id % capacidad;
    }

    public boolean insertar(Cancion cancion){
        if(cancion == null || cancion.getId() < 0){
            return false;
        }

        int index = funcionHash(cancion.getId());

        for(Cancion actual : tabla.get(index)){
            if (actual.getId() == cancion.getId()){
                return false;
            }
        }

        tabla.get(index).add(cancion);
        return true;
    }

    public Cancion buscar(int id) {
        if (id < 0) {
            System.out.println("Ingresa un ID válido");
            return null;
        }

        int index = funcionHash(id);

        for(Cancion cancion : tabla.get(index)){
            if (cancion.getId() == id){
                return cancion;
            }
        }

        return null;
    }

    public boolean eliminar(int id){
        if(id < 0){
            System.out.println("Ingresa un ID válido");
            return false;
        }

        int index = funcionHash(id);

        for (int i = 0; i < tabla.get(index).size(); i++) {
            if (tabla.get(index).get(i).getId() == id) {
                tabla.get(index).remove(i);
                return true;
            }
        }

        return false;
    }

}
