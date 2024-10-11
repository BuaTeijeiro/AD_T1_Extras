package org.example.biblioteca;

import java.io.Serializable;

public class Publicacion implements Serializable {
    public String isbn;
    public String titulo;
    public int year;

    public Publicacion(String isbn, String titulo, int year) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.year = year;
    }

    public Publicacion() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return new StringBuilder(getTitulo())
                .append("\n")
                .append(getIsbn())
                .append("\n")
                .append(String.valueOf(getYear()))
                .toString();
    }
}
