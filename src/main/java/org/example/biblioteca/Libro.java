package org.example.biblioteca;

import java.io.Serializable;

public class Libro extends Publicacion implements Prestable, Serializable {
    private boolean prestado;

    public Libro(String isbn, String titulo, int year) {
        super(isbn, titulo, year);
        prestado = false;
    }

    public Libro() {
    }

    @Override
    public void presta() {
        prestado = true;
    }

    @Override
    public void devuelve() {
        prestado = false;
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }
}
