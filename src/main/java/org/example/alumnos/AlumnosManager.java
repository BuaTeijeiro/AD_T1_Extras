package org.example.alumnos;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class AlumnosManager {
    private static final Class<?> clase = Alumno.class;
    private static final Field[] fields = clase.getFields();

    public static void crearAlumno(){
        Alumno newAlumno = new Alumno();
        for (Field field: fields){
            askField(newAlumno,field);
        }
    }

    public static void askField(Alumno alumno, Field field){
        String fieldClass = field.getType().getName();
        Scanner sc = new Scanner(System.in);
        String value;
        boolean keepGoing = true;
        while (keepGoing){
            try{
                System.out.println("Introduzca el valor de " + field.getName() + " que debe ser de tipo " + fieldClass);
                value = sc.nextLine();
                switch (fieldClass){
                    case  "int":
                        field.set(alumno, Integer.valueOf(value));
                        break;
                    case "float":
                        field.set(alumno, Float.valueOf(value));
                        break;
                    case "boolean":
                        field.set(alumno, Boolean.valueOf(value));
                        break;
                    default:
                        field.set(alumno,value);
                        break;
                }
                keepGoing = false;
            } catch (Exception e){
                System.out.println("No se trata de un valor correcto para el campo, vuelva a intentarlo");
            }
        }
    }
}
