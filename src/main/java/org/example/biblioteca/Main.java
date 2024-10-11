package org.example.biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro = new Libro("978-2-3255-4452-0", "La Sombra del Viento", 2002);
        Libro libro2 = new Libro("978-3-4327-1722-7", "La Asombrosa tienda de la señora Yeom", 2022);
        Revista revista = new Revista("978-2-6756-3580-0","Science",2024,248);

        libro.presta();

        biblioteca.addPublicacion(libro);
        biblioteca.addPublicacion(libro2);
        biblioteca.addPublicacion(revista);

        biblioteca.safeBiblioteca();

        Biblioteca bibliotecaCargada = Biblioteca.loadBiblioteca();

        System.out.println(bibliotecaCargada.countPublicaciones());
        System.out.println(bibliotecaCargada.getPublicaciones());
    }
}
