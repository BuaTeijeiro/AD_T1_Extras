package org.example.alumnos;

public class DNI {
    private String numero;

    private DNI(String dni) {
        this.numero = dni;
    }

    public String getNumero(){
        return numero;
    }

    public static DNI createNewDNI(String dni) throws RepeatedDNIException{
        if (Alumno.getAllDNI().contains(dni)){
            throw new RepeatedDNIException(dni);
        } else {
            return new DNI(dni);
        }
    }

    @Override
    public String toString(){
        return getNumero();
    }
}
