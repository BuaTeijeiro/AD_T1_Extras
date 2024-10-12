package org.example.alumnos;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class XmlAlumnosLoader {
    private String path;

    public XmlAlumnosLoader(String path) {
        this.path = path;
    }

    public Document createDocument() throws UnsuccesfulDocumentCreationException{
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(path);
            return doc;
        }  catch (ParserConfigurationException | IOException | SAXException e){
            throw new UnsuccesfulDocumentCreationException();
        }
    }

    public List<Alumno> loadAlumnos(Document document){
        List<Alumno> alumnos = new ArrayList<>();
        NodeList dniNodes = document.getElementsByTagName("dni");
        NodeList nombreNodes = document.getElementsByTagName("nombre");
        NodeList edadNodes = document.getElementsByTagName("edad");
        NodeList mediaNodes = document.getElementsByTagName("media");
        NodeList repetidorNodes = document.getElementsByTagName("repetidor");
        for(int i = 0; i < dniNodes.getLength(); i++){
            String dni = dniNodes.item(i).getTextContent();
            String nombre = nombreNodes.item(i).getTextContent();
            int edad = Integer.parseInt(edadNodes.item(i).getTextContent());
            float media = Float.parseFloat(mediaNodes.item(i).getTextContent());
            boolean repetidor = Boolean.parseBoolean(repetidorNodes.item(i).getTextContent());
            alumnos.add(new Alumno(dni, nombre, edad, media, repetidor));
        }
        return alumnos;
    }
}
