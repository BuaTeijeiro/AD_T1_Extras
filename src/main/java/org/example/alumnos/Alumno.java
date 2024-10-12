package org.example.alumnos;

public class Alumno {
    private String dni;
    private String nombre;
    private int edad;
    private float notaMedia;
    private boolean repetidor;

    public Alumno(String dni, String nombre, int edad, float notaMedia, boolean repetidor) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
        this.repetidor = repetidor;
    }

    public Alumno() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "dni='" + dni +
                ", nombre='" + nombre +
                ", edad=" + edad +
                ", notaMedia=" + notaMedia +
                ", repetidor=" + repetidor +
                '}';
    }
}
