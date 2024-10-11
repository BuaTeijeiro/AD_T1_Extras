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

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
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

    @Override
    public String toString() {
        return new StringBuilder(getTitulo())
                .append("\n")
                .append(getIsbn())
                .append("\n")
                .append(String.valueOf(getYear()))
                .append("\n")
                .append(estaPrestado())
                .toString();
    }
}
