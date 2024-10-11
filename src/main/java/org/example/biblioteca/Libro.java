package org.example.biblioteca;

import java.io.Serializable;

public class Libro extends Publicacion implements Serializable {
    private boolean prestado;

    public Libro(String isbn, String titulo, int year) {
        super(isbn, titulo, year);
        prestado = false;
    }


}
