package modelos;

public class Cancion{
    
    private int id;
    private String nombre;
    private Artista artista;
    private static int contador = 0;

    public Cancion(String nombre,Artista artista){
        this.id = contador++;
        this.nombre = nombre;
        this.artista = artista;

    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public Artista getArtista(){
        return artista;
    }

    public void setId(int nuevoID){
        this.id = nuevoID;
    }

    public void setNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public void setArtista(Artista nuevoArtista){
        this.artista = nuevoArtista;
    }

    public String toString(){
        return id + ".-" + nombre + " de " + artista.getNombre();
    }
}
