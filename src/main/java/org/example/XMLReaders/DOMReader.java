package org.example.XMLReaders;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMReader {
    private static String REPERIDORES_XML = "src/main/resources/alumnos/alumnos_repetidores.xml";

    private String xmlURL;

    public DOMReader(String XML_URL) {
        this.xmlURL = XML_URL;
    }

    public DOMReader(){
        this.xmlURL = REPERIDORES_XML;
    }

    public String getXmlURL(){
        return this.xmlURL;
    }

    public void Read(){
        try{
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new File(getXmlURL()));
            NodeList nodes = doc.getElementsByTagName("alumno");
            System.out.println("Alumnos:");
            for (int i=0; i<nodes.getLength(); i++){
                Element elementAlumno = (Element) nodes.item(i);
                System.out.println("\tAlumno:");
                System.out.println("\t\t" + "dni: " + elementAlumno.getElementsByTagName("dni").item(0).getTextContent());
                System.out.println("\t\t" + "nombre: " +elementAlumno.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("\t\t" + "edad: " + elementAlumno.getElementsByTagName("edad").item(0).getTextContent());
                System.out.println("\t\t" + "media: " + elementAlumno.getElementsByTagName("media").item(0).getTextContent());
                System.out.println("\t\t" + "repetidor: " + elementAlumno.getElementsByTagName("repetidor").item(0).getTextContent());
            }
        } catch (ParserConfigurationException e){
            System.out.println("Error al congigurar el Document Builder");
        } catch (IOException | SAXException e){
            System.out.println("Error al parsear el archivo");
        }

    }
}
