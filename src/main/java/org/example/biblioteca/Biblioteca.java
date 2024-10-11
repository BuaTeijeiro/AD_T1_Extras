package org.example.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private static final String LIBROS_FILE_URL= "src/main/resources/libros.dat";
    private static final String REVISTAS_FILE_URL= "src/main/resources/revistas.dat";
    private List<Publicacion> publicaciones;

    public Biblioteca() {
        publicaciones = new ArrayList<Publicacion>();
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void addPublicacion(Publicacion publicacion) {
        this.publicaciones.add(publicacion);
    }

    public List<Publicacion> getLibros() {
        return this.getPublicaciones().stream().filter(o -> o instanceof Libro).toList();
    }

    public List<Publicacion> getRevistas() {
        return this.getPublicaciones().stream().filter(o -> o instanceof Revista).toList();
    }

    public void safeBiblioteca() {
        safeLibros();
        safeRevistas();
    }

    private void safeLibros(){
        try (FileOutputStream fileEscritor = new FileOutputStream(LIBROS_FILE_URL);
             ObjectOutputStream escritor = new ObjectOutputStream(fileEscritor);){
            for (Publicacion publicacion : this.getLibros()) {
                System.out.println(publicacion);
                escritor.writeObject(publicacion);
            }
        } catch (IOException e){
            System.out.println("Error al abrir el archivo");
        }
    }

    private void safeRevistas(){
        try (FileOutputStream fileEscritor = new FileOutputStream(REVISTAS_FILE_URL);
             ObjectOutputStream escritor = new ObjectOutputStream(fileEscritor);){
            for (Publicacion publicacion : this.getRevistas()) {
                escritor.writeObject(publicacion);
            }
        } catch (IOException e){
            System.out.println("Error al abrir el archivo");
        }
    }

    public static Biblioteca loadBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.loadLibros();
        biblioteca.loadLRevistas();
        return biblioteca;
    }

    public void loadLibros(){
        try (FileInputStream fileLector = new FileInputStream(LIBROS_FILE_URL);
             ObjectInputStream lector = new ObjectInputStream(fileLector);){
            while(fileLector.available()>0){
                Object o = lector.readObject();
                System.out.println(o.getClass().getName());
                if(o instanceof Libro){
                    addPublicacion((Libro)o);
                }
            }
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error al abrir el archivo");
        }
    }

    public void loadLRevistas(){
        try (FileInputStream fileLector = new FileInputStream(REVISTAS_FILE_URL);
             ObjectInputStream lector = new ObjectInputStream(fileLector);){
            while(fileLector.available()>0){
                Object o = lector.readObject();
                if(o instanceof Revista){
                    addPublicacion((Revista)o);
                }
            }
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error al abrir el archivo");
        }
    }

    public int countPublicaciones(){
        return getPublicaciones().size();
    }
}
