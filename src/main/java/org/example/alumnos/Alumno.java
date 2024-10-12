package org.example.alumnos;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alumno {
    private static String ALUMNOS_XML = "src/main/resources/alumnos/alumnos.xml";
    private static String ALUMNOS_APROBADOS_XML = "src/main/resources/alumnos/alumnos_aprobados.xml";
    private static String ALUMNOS_REPETIDORES_XML = "src/main/resources/alumnos/alumnos_repetidores.xml";
    private static List<Alumno> alumnos = new ArrayList<>();

    public String dni;
    public String nombre;
    public int edad;
    public float notaMedia;
    public boolean repetidor;

    public Alumno(String dni, String nombre, int edad, float notaMedia, boolean repetidor) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
        this.repetidor = repetidor;
        this.alumnos.add(this);
    }

    public Alumno() {
        this.alumnos.add(this);
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
                "dni=" + dni +
                ", nombre=" + nombre +
                ", edad=" + edad +
                ", notaMedia=" + notaMedia +
                ", repetidor=" + repetidor +
                '}';
    }

    public static String getAlumnosXml(){
        return ALUMNOS_XML;
    }

    public static String getAlumnosAprobadosXml(){
        return ALUMNOS_APROBADOS_XML;
    }

    public static String getAlumnosRepetidoresXml(){
        return ALUMNOS_REPETIDORES_XML;
    }

    public static List<Alumno> getAllAlumnos(){
        return alumnos;
    }

    private static List<Alumno> filterAlumnosRepetidores(){
        return alumnos.stream().filter(a -> a.isRepetidor()).toList();
    }

    private static List<Alumno> filterAlumnosAprobados(){
        return alumnos.stream().filter(a -> a.getNotaMedia() >= 5).toList();
    }

    public static void guardarTodosLosAlumnos(){
        guardarAlumnosXML(getAllAlumnos(),getAlumnosXml());
    }

    public static void guardarAlumnosRepetidores(){
        guardarAlumnosXML(filterAlumnosRepetidores(),getAlumnosRepetidoresXml());
    }

    public static void guardarAlumnosAprobados(){
        guardarAlumnosXML(filterAlumnosAprobados(),getAlumnosAprobadosXml());
    }

    public static void showAllAlumnos(){
        getAllAlumnos().forEach(System.out::println);
        String pause = new Scanner(System.in).nextLine();
    }


    public static void guardarAlumnosXML(List<Alumno> alumnos, String url){
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();
            Document document = domImpl.createDocument(null, "alumnos", null);
            document.setXmlVersion("1.0");
            Element raiz = document.getDocumentElement();
            for(Alumno alumno: alumnos){
                Element alumnoElement = document.createElement("alumno");
                raiz.appendChild(alumnoElement);

                Element dniElement = document.createElement("dni");
                alumnoElement.appendChild(dniElement);
                dniElement.appendChild(document.createTextNode(alumno.getDni()));

                Element nombreElement = document.createElement("nombre");
                alumnoElement.appendChild(nombreElement);
                nombreElement.appendChild(document.createTextNode(alumno.getNombre()));

                Element mediaElement = document.createElement("media");
                alumnoElement.appendChild(mediaElement);
                mediaElement.appendChild(document.createTextNode(String.valueOf(alumno.getNotaMedia())));

                Element edadElement = document.createElement("edad");
                alumnoElement.appendChild(edadElement);
                edadElement.appendChild(document.createTextNode(String.valueOf(alumno.getEdad())));

                Element repetidorElement = document.createElement("repetidor");
                alumnoElement.appendChild(repetidorElement);
                repetidorElement.appendChild(document.createTextNode(String.valueOf(alumno.isRepetidor())));
            }

            File xml = new File(url);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult result = new StreamResult(xml);
            DOMSource source = new DOMSource(document);
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e){
            System.out.println(e.getMessage());
        }
    }

}
