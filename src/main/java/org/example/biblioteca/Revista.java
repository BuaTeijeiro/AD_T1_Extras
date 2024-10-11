package org.example.biblioteca;

import java.io.Serializable;

public class Revista extends Publicacion implements Serializable {
    private int numero;

    public Revista(String isbn, String titulo, int year, int numero) {
        super(isbn, titulo, year);
        this.numero = numero;
    }

    public Revista() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
                .append("\n")
                .append(getNumero())
                .toString();
    }
}
