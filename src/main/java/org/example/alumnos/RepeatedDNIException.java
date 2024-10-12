package org.example.alumnos;

public class RepeatedDNIException extends Exception {
    public RepeatedDNIException(String dni){
        super("El dni con número " + dni + " ya está registrado, pruebe otra vez");
    }
}
