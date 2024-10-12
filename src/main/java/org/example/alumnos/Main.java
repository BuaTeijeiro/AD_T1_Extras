package org.example.alumnos;

import org.w3c.dom.Document;

import java.util.List;

public class Main {
    public static void main(String[] args){
        XmlAlumnosLoader loader = new XmlAlumnosLoader(Alumno.getAlumnosXmlUrl());
        try {
            Document doc = loader.createDocument();
            List<Alumno> alumnos = loader.loadAlumnos(doc);
            System.out.println(alumnos);
        } catch (UnsuccesfulDocumentCreationException e){
            System.out.println("No se pudo cargar el fichero xml, compruebe que se halla en la ruta adecuada");
        }

    }
}
