package org.example.alumnos;
import org.w3c.dom.Document;

import java.util.List;

public class Main {
    public static void main(String[] args){
        XmlAlumnosLoader loader = new XmlAlumnosLoader(Alumno.getAlumnosXml());
        try {
            Document doc = loader.createDocument();
            List<Alumno> alumnos = loader.loadAlumnos(doc);

            Menu menuPrincipal = new Menu("Qué quieres hacer?");
            try {
                menuPrincipal.addOption(1, "guardarAlumnosRepetidores", Alumno.class);
                menuPrincipal.addOption(2, "guardarAlumnosAprobados", Alumno.class);
                menuPrincipal.addOption(3, "crearAlumno", AlumnosManager.class);
                menuPrincipal.addOption(4, "showAllAlumnos", Alumno.class);
                menuPrincipal.addOption(5, "guardarYSalir");
                menuPrincipal.activate();
            } catch (NoSuchMethodException e){
                System.out.println("No se ha podido configurar el menú correctamente");
                System.out.println(e);
            }
        } catch (UnsuccesfulDocumentCreationException e){
            System.out.println("No se pudo cargar el fichero xml, compruebe que se halla en la ruta adecuada");
        } catch (RepeatedDNIException e){
            System.out.println("En los datos que se han intentado cargar hay dnis repetidos, compruébelos");
        }

    }
}
