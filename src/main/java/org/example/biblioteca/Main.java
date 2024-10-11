package org.example.biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro = new Libro("978-2-3255-4452-0", "La Sombra del Viento", 2002);
        Revista revista = new Revista("978-2-6756-3580-0","Science",2024,248);

        biblioteca.addPublicacion(libro);
        biblioteca.addPublicacion(revista);

        System.out.println(biblioteca.getPublicaciones());


    }
}
